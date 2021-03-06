package com.dzb.ssm.dao;

import com.dzb.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/24 13:22
 */
public interface IProductDao {

    //根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(Integer id) throws Exception;

    //查询所有的产品信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
