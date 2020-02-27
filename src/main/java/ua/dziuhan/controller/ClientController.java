package ua.dziuhan.controller;

import java.sql.Date;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ua.dziuhan.controller.Util.Sorter;
import ua.dziuhan.entities.CarData;
import ua.dziuhan.entities.OrderData;
import ua.dziuhan.entities.ReviewAboutCarData;
import ua.dziuhan.entities.UserData;
import ua.dziuhan.service.CarService;
import ua.dziuhan.service.OrderService;
import ua.dziuhan.service.ReviewAboutCarService;
import ua.dziuhan.service.UserService;

/**
 * Controller for client's part of application
 */
	@Controller
	@RequestMapping("/client")
	public class ClientController {

	private CarService carService;

	private UserService userService;

	private OrderService orderService;

	private ReviewAboutCarService reviewAboutCarService;

	@Autowired
	@Qualifier(value = "carService")
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@Autowired
	@Qualifier(value = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	@Qualifier(value = "orderService")
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	@Autowired
	@Qualifier(value = "reviewAboutCarService")
	public void setReviewAboutCarService(ReviewAboutCarService reviewAboutCarService) {
		this.reviewAboutCarService = reviewAboutCarService;
	}

	@RequestMapping("/")
	public String main(Model model) {
		model.addAttribute("cars", carService.selectAllCars());
		model.addAttribute("producers", carService.selectAllProducersCar());
		model.addAttribute("ranks", carService.selectAllRanksCar());
		return "/main.jsp";
	}

	@RequestMapping("/cars")
	public String cars(Model model,HttpSession session) {
		model.addAttribute("producers", carService.selectAllProducersCar());
		model.addAttribute("ranks", carService.selectAllRanksCar());
		String[] producers= (String[]) session.getAttribute("producerFilter");
		String[] ranks= (String[]) session.getAttribute("rankFilter");
		List<CarData> cars;
		if (producers == null && ranks==null) {
			cars= carService.selectAllCars();
		} else {
			cars= carService.selectCarsByProducersRanks(producers,ranks);
		}

		String sortCarsBy= (String) session.getAttribute("sortCarsBy");
		if(sortCarsBy!=null) {
			Sorter.sortCars(cars,sortCarsBy );
		}
		model.addAttribute("cars", cars);
		return "/main.jsp";
	}

	@RequestMapping("/manager")
	public String redirectToManager(){
		return "redirect:/manager/";
	}

	@RequestMapping("/admin")
	public String redirectToAdmin(){
		return "redirect:/admin/";
	}

	@RequestMapping( "changeLanguage={locale}")
	public String changeLanguage(@PathVariable("locale")String locale,HttpSession session){
		session.setAttribute("locale",locale);
		return "redirect:/client/";
	}

	@RequestMapping("/car{id}")
	public String chooseCar(@PathVariable("id") int id_car, Model model) {
		CarData car = carService.selectCarById(id_car);
		model.addAttribute("chooseCar", car);
		return "/WEB-INF/jsp/client/Order.jsp";
	}

	@RequestMapping("/ReviewsCar_Id={id}")
	public String reviewsCar(@PathVariable("id") int id_car, Model model) {
		CarData car = carService.selectCarById(id_car);
		model.addAttribute(("idCar"), id_car);
		model.addAttribute("reviewsAboutCar", reviewAboutCarService.selectAllReviewAboutCarData(car));
		//request.setAttribute("idCar",idCar);
		return "/WEB-INF/jsp/client/ReviewsAboutCar.jsp";
	}

	@RequestMapping("/cabinet_user")
	public String cabinetUser(Model model, HttpSession session) {
		String login = (String) session.getAttribute("user_login");
		if (login == null) {
			return "/main.jsp"; /// ???
		}
		model.addAttribute("ordersClient", orderService.selectAllOrdersByLogin(login));
		return "/WEB-INF/jsp/client/CabinetClient.jsp";
	}

	@RequestMapping("/payOrderById={id_order}")
	public String payOrder(@PathVariable("id_order") int id){
		OrderData order=orderService.selectOrderById(id);
		orderService.updateStateOrder(order,"paid order");
		return "redirect:cabinet_user";

	}

	@RequestMapping("/make_order")
	public String makeOrder(@ModelAttribute("order") OrderData orderData, HttpServletRequest request, HttpSession session, Model model) {
		//System.out.println(orderData);
		int idCar = Integer.parseInt(request.getParameter("idCar"));
		String login = (String) session.getAttribute("user_login");
		if (login == null) {
			model.addAttribute("messageForGuest", "Please login first ");
			model.addAttribute("idCar", idCar);
			return "car" + idCar;
		}
		orderService.addOrder(orderData, login, idCar);
		return "redirect:cars";
	}

	// Post

	@RequestMapping("/login")
	public String loginRegistration(@ModelAttribute("user") UserData user, Model model, HttpSession session) {
		UserData userFromDB = userService.selectUserByLogin(user);

		if (userFromDB != null && user.getLogin().equals(userFromDB.getLogin())) {
			if (user.getPassword().equals(userFromDB.getPassword())) {
				session.setAttribute("user_login", user.getLogin());
				session.setAttribute("user_role",userFromDB.getRole().getRole());
				session.setAttribute("currentDate",new Date(Calendar.getInstance().getTimeInMillis()));
				if(userFromDB.isBan()) {
					session.setAttribute("banned","banned");
				}
				return "redirect:cars";
			} else {
				model.addAttribute("messageForGuest", "invalid password");
				model.addAttribute("cars", carService.selectAllCars());
				model.addAttribute("producers", carService.selectAllProducersCar());
				model.addAttribute("ranks", carService.selectAllRanksCar());
				return "/main.jsp";
			}
		}
		userService.createNewUser(user);
		session.setAttribute("user_login", user.getLogin());
		return "redirect:cars";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("user_login");
		session.invalidate();
		return "redirect:cars";
	}

	@RequestMapping("/viewTemplateCars={viewTemplate}")
	public String changeViewTemplateCars(@PathVariable("viewTemplate") String viewTemplate, HttpSession session) {
		session.setAttribute("viewTemplateCars", viewTemplate);
		return "redirect:cars";
	}

	@RequestMapping("/addReviewAboutCar")
	public String makeReviewAboutCar(@ModelAttribute("reviewAboutCarData") ReviewAboutCarData reviewAboutCarData, Model model, HttpSession session, HttpServletRequest request) {
		reviewAboutCarData.setDateReview(new Date(Calendar.getInstance().getTimeInMillis()));
		int idCar = Integer.parseInt(request.getParameter("idCar"));
		String login = (String) session.getAttribute("user_login");
		if (login == null) {
			model.addAttribute("messageForGuest", "Please login first ");
			model.addAttribute("idCar", idCar);
			return "ReviewsCar_Id=" + idCar;
		}
		reviewAboutCarService.addReviewAboutCar(reviewAboutCarData, login, idCar);
		return "redirect:ReviewsCar_Id=" + idCar;

	}

	@RequestMapping("/sorterCars")
	public String sorterCars(HttpServletRequest request,HttpSession session) {
		String sortCarsBy= request.getParameter("sortCarsBy");
		if(sortCarsBy!=null) {
			session.setAttribute("sortCarsBy", sortCarsBy);
		}
		return "redirect:cars";
	}

	@RequestMapping("/filterCars")
	public String filterCars(HttpServletRequest request,HttpSession session){

		String[] producers = request.getParameterValues("producerFilter");
		session.setAttribute("producerFilter",producers);

		String[] ranks = request.getParameterValues("rankFilter");
		session.setAttribute("rankFilter",ranks);

		session.removeAttribute("producersForJsp");
		session.removeAttribute("ranksForJsp");

		if(producers!=null){
			List<String> producersForJsp=new ArrayList<>();
			Collections.addAll(producersForJsp, producers);
			session.setAttribute("producersForJsp", producersForJsp);
		}
		if(ranks!=null){
			List<String> ranksForJsp=new ArrayList<>();
			Collections.addAll(ranksForJsp, ranks);
			session.setAttribute("ranksForJsp", ranksForJsp.toString());
		}

		/*if(producers!=null){
			StringBuilder producersForJsp=new StringBuilder();
			for(String s:producers){
				producersForJsp.append(","+s+",");
			}
			//System.out.println(producersForJsp.toString());
			session.setAttribute("producersForJsp", producersForJsp.toString());
		}
		if(ranks!=null){
			StringBuilder ranksForJsp=new StringBuilder();
			for(String s:ranks){
				ranksForJsp.append(","+s+",");
			}
			//System.out.println(ranksForJsp);
			session.setAttribute("ranksForJsp", ranksForJsp.toString());
		}*/
		session.setAttribute("indexPage",1);
		return "redirect:cars";
	}

	@RequestMapping("/changePageView={indexPage}")
	public String changePageView(@PathVariable(value = "indexPage") int indexPage,HttpSession session){
		session.setAttribute("indexPage",indexPage);
		return "redirect:cars";
	}
}