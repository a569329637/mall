package com.gsq.mall.goods.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "t_goods")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long goodsId;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String pictureUrl;
    @Column
    private Integer isOnSale;
    @Column
    private BigDecimal price;
    @Column
    private Integer count;
    @Column
    private Integer deleted;
    @Column
    private Date createTime;
    @Column
    private Date updateTime;
}
