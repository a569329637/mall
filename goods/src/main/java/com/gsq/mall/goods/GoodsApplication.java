package com.gsq.mall.goods;

import com.gsq.mall.goods.entity.Goods;
import com.gsq.mall.goods.enums.DeletedEnum;
import com.gsq.mall.goods.enums.OnSaleEnum;
import com.gsq.mall.goods.repository.GoodsRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.stream.LongStream;

@SpringBootApplication
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }

    @Bean
    ApplicationRunner init(GoodsRepository repository) {
        return args -> {
            // init goods
            LongStream.rangeClosed(1, 5).forEach(idx -> {
                String title = "mac book pro " + idx;
                String description = "description";
                String pictureUrl = "http://localhost:8764/goods/1";
                BigDecimal price = new BigDecimal("100.00");
                Integer number = 10;
                Goods goods = new Goods(idx, title, description, pictureUrl, OnSaleEnum.YES.getStatus(),
                        price, number, DeletedEnum.NO.getStatus(), new Date(), new Date());
                repository.save(goods);
            });
        };
    }

}
