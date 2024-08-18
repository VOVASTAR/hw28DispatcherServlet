package edu.hillel.hw28_DispatcherServlet.service;

import edu.hillel.hw28_DispatcherServlet.entity.Order;
import edu.hillel.hw28_DispatcherServlet.entity.Product;
import edu.hillel.hw28_DispatcherServlet.repo.OrderRepository;
import edu.hillel.hw28_DispatcherServlet.repo.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service

@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    public Order getOrderById(int id) {
        return orderRepository.getOrderById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    public Order addOrder(Integer... ids) {
        List<Product> products = productRepository.getProductList().stream()
                .filter(prod -> Arrays.stream(ids).anyMatch(id -> Objects.equals(prod.getId(), id)))
                .toList();
        Order order = orderRepository.addOrder(products);
        orderRepository.getAllOrders().add(order);
        return order;
    }
}
