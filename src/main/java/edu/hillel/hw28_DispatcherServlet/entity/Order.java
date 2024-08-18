package edu.hillel.hw28_DispatcherServlet.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Order {
    private Integer id;
    private LocalDateTime date;
    private Double cost;
    private List<Product> products;
}
