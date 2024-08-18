package edu.hillel.hw28_DispatcherServlet.controller;

import edu.hillel.hw28_DispatcherServlet.entity.Order;
import edu.hillel.hw28_DispatcherServlet.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")

@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @GetMapping("/get-all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/add-order")
    public Order addOrder(@RequestParam("id") Integer... ids) {
        return orderService.addOrder(ids);
    }
}
