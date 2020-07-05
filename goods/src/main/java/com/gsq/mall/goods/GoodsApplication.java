package com.gsq.mall.goods;

import com.gsq.mall.goods.entity.Goods;
import com.gsq.mall.goods.repository.GoodsRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.stream.Stream;

@SpringBootApplication
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }

    @Bean
    ApplicationRunner init(GoodsRepository repository) {
        return args -> {
            Goods goods1 = new Goods(1L, "account1", "张三", 20, new BigDecimal(100.00));
            Goods goods2 = new Goods(2L, "account2", "李四", 28, new BigDecimal(180.00));
            Goods goods3 = new Goods(3L, "account3", "王五", 32, new BigDecimal(280.00));
            Stream.of(goods1, goods2, goods3).forEach(repository::save);
        };
    }

}
