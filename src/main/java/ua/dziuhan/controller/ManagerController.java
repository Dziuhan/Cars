package ua.dziuhan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.dziuhan.entities.OrderData;
import ua.dziuhan.service.OrderService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/")
    public String main(Model model){
        List<OrderData> orders=orderService.selectAllOrders();
        model.addAttribute("orders",orders);
        return "/WEB-INF/jsp/manager/MainManager.jsp";
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

    @RequestMapping(value = "/order_state={state}")
    public String selectOrdersByState(@PathVariable("state")String state,Model model){
        if (state==null || "all order".equals(state)){
            model.addAttribute("orders",orderService.selectAllOrders());
        }else if("may close order".equals(state)){
            model.addAttribute("orders",orderService.selectMayCloseOrder());

        }else {
            model.addAttribute("orders", orderService.selectOrdersByState(state));
        }
        model.addAttribute("stateOrderByManager",state);
        return "/WEB-INF/jsp/manager/MainManager.jsp";
    }

    @RequestMapping(value = "/acceptOrderId={id_order}")
    public String acceptOrder(@PathVariable("id_order")int id, Model model){
        OrderData order=orderService.selectOrderById(id);
        orderService.updateStateOrder(order,"waiting for payment");
        return "redirect:/manager/order_state=new order";
    }
    @RequestMapping(value = "/rejectOrderId={id_order}")
    public String rejectOrder(@PathVariable("id_order")int id, Model model){
        OrderData order=orderService.selectOrderById(id);
        orderService.updateStateOrder(order,"rejected order");
        return "redirect:order_state=new order";
    }
    @RequestMapping(value = "/ closeOrderById={id_order}")
    public String closeOrder(@PathVariable("id_order")int id, Model model){
        OrderData order=orderService.selectOrderById(id);
        orderService.updateStateOrder(order,"closed order");
        return "redirect:order_state=new order";
    }

}
