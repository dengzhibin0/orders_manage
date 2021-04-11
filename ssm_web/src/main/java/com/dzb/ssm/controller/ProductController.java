package com.dzb.ssm.controller;

import com.dzb.ssm.domain.Product;
import com.dzb.ssm.service.IProductService;
import com.dzb.ssm.utils.DataStringEditor;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 邓志斌
 * @version 1.0
 * @date 2021/3/24 13:49
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;

//    @InitBinder
//    public void initBinder(WebDataBinder binder){
//        binder.registerCustomEditor(Date.class,new DataStringEditor());
//    }

    //查询全部产品
    @RequestMapping("/findAll.do")
    @RolesAllowed("admin")
    public ModelAndView findAll(@RequestParam(name="page",required = true,defaultValue = "1") Integer page,
                                @RequestParam(name = "size",required = true,defaultValue = "4") Integer size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Product> ps =productService.findAll(page,size);

        PageInfo pageInfo=new PageInfo(ps);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    //根据id查询
    @RequestMapping("/findProductById.do")
    public ModelAndView findProductById() throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Product> ps=new ArrayList<>();
        ps.add(productService.findById(1));
        mv.addObject("productList", ps);
        mv.setViewName("product-list");
        return mv;
    }

    //产品添加
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception {
        productService.save(product);
        return "redirect:findAll.do";
    }


}
