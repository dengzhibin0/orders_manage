package com.dzb.ssm.service;

import com.dzb.ssm.domain.Product;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/24 13:24
 */
public interface IProductService {

    public Product findById(Integer id) throws Exception;

    public List<Product> findAll(int page, int size) throws Exception;

    void save(Product product) throws Exception;
}
