package ua.dziuhan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.dziuhan.entities.CarData;
import ua.dziuhan.entities.UserData;
import ua.dziuhan.service.CarService;
import ua.dziuhan.service.UserService;

import javax.servlet.http.HttpSession;

@Controller()
@RequestMapping(value = "/admin")
public class AdminController {
    UserService userService;

    CarService carService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/")
    public String main(Model model){
        model.addAttribute("cars",carService.selectAllCars());
        return "/WEB-INF/jsp/admin/MainAdmin.jsp";
    }

    @RequestMapping(value = "/manager")
    public String redirectToManager(){
        return "redirect:/manager/";
    }

    @RequestMapping(value = "/admin")
    public String redirectToAdmin(){
        return "redirect:/admin/";
    }

    @RequestMapping(value = "/cars")
    public  String redirectToCars(){
        return "redirect:/client/";
    }

    @RequestMapping(value = "/client")
    public  String redirectToCar(){
        return "redirect:/client/";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/client/";
    }


    @RequestMapping(value = "/viewAllUsersAdmin")
    public String viewAllUsersAdmin(Model model){
        model.addAttribute("viewAdmin","all users");
        model.addAttribute("users",userService.selectAllUsers());
        return "/WEB-INF/jsp/admin/MainAdmin.jsp";
    }

    @RequestMapping(value = "/edit user login={login}")
    public String editUser(@PathVariable("login") String login, Model model){
        model.addAttribute("viewAdmin","edit user");
        model.addAttribute("userForEditAdmin",userService.selectUserByLogin(login));
        return "/WEB-INF/jsp/admin/MainAdmin.jsp";
    }

    @RequestMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("editedUser") UserData userData,Model model){
        userService.updateUser(userData);
        model.addAttribute("viewAdmin","all users");
        model.addAttribute("users",userService.selectAllUsers());
        return "/WEB-INF/jsp/admin/MainAdmin.jsp";
    }

    @RequestMapping(value = "/viewSearchUserAdmin")
    public String searchUser(@ModelAttribute("searchUser") UserData user,Model model){
       model.addAttribute("users",userService.searchUserByLogin(user.getLogin()));
       model.addAttribute("viewAdmin","all users");
        return "/WEB-INF/jsp/admin/MainAdmin.jsp";
    }

    @RequestMapping(value = "/viewAllCarsAdmin")
    public String viewAllCarsAdmin(Model model){
        model.addAttribute("viewAdmin","all cars");
        model.addAttribute("cars",carService.selectAllCars());
        return "/WEB-INF/jsp/admin/MainAdmin.jsp";
    }

    @RequestMapping(value = "/edit car idCar={id}")
    public String editCar(@PathVariable("id") int id, Model model){
        model.addAttribute("viewAdmin","edit car");
        model.addAttribute("editCar",carService.selectCarById(id));
        return "/WEB-INF/jsp/admin/MainAdmin.jsp";
    }

    @RequestMapping(value = "/viewNewCarAdmin")
    public String createCar(Model model){
        model.addAttribute("viewAdmin","new car");
        return "/WEB-INF/jsp/admin/MainAdmin.jsp";
    }

    @RequestMapping(value = "/saveCar")
    public String saveCar(@ModelAttribute("editedCar") CarData carData,Model model){
        carService.updateCar(carData);
        model.addAttribute("cars",carService.selectAllCars());
        return "/WEB-INF/jsp/admin/MainAdmin.jsp";
    }

    @RequestMapping(value = "/addCar")
    public String addCar(@ModelAttribute("editedCar") CarData carData,Model model){
       carService.addCar(carData);
        model.addAttribute("cars",carService.selectAllCars());
        return "/WEB-INF/jsp/admin/MainAdmin.jsp";
    }

    @RequestMapping(value = "/remove car id={idCar}")
    public String removeCar(@PathVariable(value = "idCar")int idCar,Model model){
        carService.removeCar(idCar);
        model.addAttribute("cars",carService.selectAllCars());
        return "/WEB-INF/jsp/admin/MainAdmin.jsp";
    }

}
