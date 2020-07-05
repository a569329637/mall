package com.gsq.mall.user;

import com.gsq.mall.user.entity.User;
import com.gsq.mall.user.entity.UserAddress;
import com.gsq.mall.user.enums.DeletedEnum;
import com.gsq.mall.user.enums.UserStatusEnum;
import com.gsq.mall.user.repository.UserAddressRepository;
import com.gsq.mall.user.repository.UserRepository;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.LongStream;

@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Bean
    ApplicationRunner initUser(UserRepository repository) {
        return args -> {
            // init user
            LongStream.rangeClosed(1, 5).forEach(idx -> {
                String username = "account" + idx;
                String nickname = "nickname" + idx;
                String password = RandomStringUtils.randomAlphanumeric(10);
                String salt = RandomStringUtils.randomAlphanumeric(10);
                String email = RandomStringUtils.randomAlphanumeric(10) + "@gmail.com";
                User user = new User(idx, username, password, nickname, salt, email,
                        UserStatusEnum.NORMAL.getStatus(), new Date(), new Date());
                repository.save(user);
            });
        };
    }

    @Bean
    ApplicationRunner initUserAddress(UserAddressRepository repository) {
        return args -> {
            // init user address
            LongStream.rangeClosed(6, 10).forEach(idx -> {
                String userName = "guishangquan" + idx;
                String mobile = RandomStringUtils.randomNumeric(11);
                Integer isDefault = idx == 1L ? 1 : 0;

                UserAddress userAddress = new UserAddress(idx, 1L, userName, mobile,
                        "China", "Hunan", "Changsha", "Yuehu Park",
                        isDefault, DeletedEnum.NO.getStatus(), new Date(), new Date());
                repository.save(userAddress);
            });
        };
    }

}
