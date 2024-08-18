package edu.hillel.hw28_DispatcherServlet.repo;

import edu.hillel.hw28_DispatcherServlet.entity.Order;
import edu.hillel.hw28_DispatcherServlet.entity.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository

@Data
@RequiredArgsConstructor
public class OrderRepository implements InitializingBean {

    private final ProductRepository productRepository;

    private List<Order> orderList;

    @Override
    public void afterPropertiesSet() {
        LocalDateTime now = LocalDateTime.now();
        orderList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            long firstProductId = (long) (Math.random() * 20);
            long secondProductId = (long) (Math.random() * 20);
            long thirdProductId = (long) (Math.random() * 20);
            List<Product> productList = productRepository.getProductList().stream()
                    .filter(product -> product.getId() == firstProductId
                            || product.getId() == secondProductId || product.getId() == thirdProductId)
                    .toList();
            Double orderSum = productList.stream()
                    .map(Product::getCost)
                    .reduce(0.0, Double::sum);
            Order order = Order.builder()
                    .id(i)
                    .date(now.minusHours(i * 3))
                    .cost(orderSum)
                    .products(productList)
                    .build();
            orderList.add(order);
        }
    }

    public Order getOrderById(int id) {
        return orderList.get(id - 1);
    }

    public List<Order> getAllOrders() {
        return orderList;
    }

    public Order addOrder(List<Product> products) {
        double sum = products.stream()
                .mapToDouble(Product::getCost)
                .sum();
        return Order.builder()
                .id(orderList.size() + 1)
                .date(LocalDateTime.now())
                .cost(sum)
                .products(products)
                .build();
    }


}
