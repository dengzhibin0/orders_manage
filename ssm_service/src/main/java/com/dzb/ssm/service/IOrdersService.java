package com.dzb.ssm.service;

import com.dzb.ssm.domain.Orders;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/25 21:14
 */
public interface IOrdersService {
    List<Orders> findAll(int page, int size) throws Exception;

    Orders findById(int ordersId) throws Exception;

}
