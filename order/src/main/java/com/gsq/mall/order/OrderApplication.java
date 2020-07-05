package com.gsq.mall.order;

import com.gsq.mall.order.entity.Order;
import com.gsq.mall.order.repository.OrderRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.stream.Stream;

@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    ApplicationRunner init(OrderRepository repository) {
        return args -> {
            Order order1 = new Order(1L, "account1", "张三", 20, new BigDecimal(100.00));
            Order order2 = new Order(2L, "account2", "李四", 28, new BigDecimal(180.00));
            Order order3 = new Order(3L, "account3", "王五", 32, new BigDecimal(280.00));
            Stream.of(order1, order2, order3).forEach(repository::save);
        };
    }

}
