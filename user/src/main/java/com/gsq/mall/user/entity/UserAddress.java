package com.gsq.mall.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_user_address")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userAddressId;
    @Column
    private Long userId;
    @Column
    private String userName;
    @Column
    private String mobile;
    @Column
    private String country;
    @Column
    private String province;
    @Column
    private String city;
    @Column
    private String detail;
    @Column
    private Integer isDefault;
    @Column
    private Integer deleted;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;
}
