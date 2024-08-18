package edu.hillel.hw28_DispatcherServlet.repo;

import com.github.javafaker.Faker;
import edu.hillel.hw28_DispatcherServlet.entity.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

@Getter
@Setter
public class ProductRepository {

    private final List<Product> productList;

    public ProductRepository() {
        Faker faker = new Faker();
        productList = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            Product product = Product.builder()
                    .id(i)
                    .name(faker.food().fruit())
                    .cost(Math.random() * 100)
                    .build();
            productList.add(product);
        }
    }
}
