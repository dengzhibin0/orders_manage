package com.dzb.ssm.service.impl;

import com.dzb.ssm.dao.IProductDao;
import com.dzb.ssm.domain.Product;
import com.dzb.ssm.service.IProductService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/24 13:25
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;


    @Override
    public Product findById(Integer id) throws Exception {
        return productDao.findById(id);
    }

    public List<Product> findAll(int page, int size) throws Exception {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page, size);
        return productDao.findAll();
    }

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
