package com.sxzhongf.distributed.transaction.domain.entity.order;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Table(name = "poc_order")
public class PocOrder {
    /**
     * 订单id
     */
    @Column(name = "order_id")
    private Long orderId;

    /**
     * 订单编码
     */
    @Column(name = "order_code")
    private String orderCode;

    /**
     * 订单创建时间
     */
    @Column(name = "create_time")
    private Long createTime;

    /**
     * 订单更新时间
     */
    @Column(name = "update_time")
    private Long updateTime;
}