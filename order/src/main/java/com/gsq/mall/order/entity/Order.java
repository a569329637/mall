package com.gsq.mall.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_order")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    @Column
    private Long userId;
    @Column
    private Integer status;

    @Column
    private Integer LogisticsStatus;
    @Column
    private String LogisticsNumber;

    @Column
    private Long userAddressId;
    @Column
    private String username;
    @Column
    private String userMobile;
    @Column
    private String userCountry;
    @Column
    private String userProvince;
    @Column
    private String userCity;
    @Column
    private String userAddressDetail;

    @Column
    private Long goodsId;
    @Column
    private String goodsTitle;
    @Column
    private String goodsDescription;
    @Column
    private BigDecimal goodsPrice;
    @Column
    private Integer goodsCount;

    @Column
    private Integer deleted;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;
}