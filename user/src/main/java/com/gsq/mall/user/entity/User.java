package com.gsq.mall.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_user")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String nickname;
    @Column
    private String salt;
    @Column
    private String email;
    @Column
    private Integer deleted;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;
}
