package design.pgy.ssm.controller;

import design.pgy.ssm.domain.Product;
import design.pgy.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(ModelAndView modelAndView) {

//        System.out.println(productService);

        List<Product> productList = productService.findAll();

        modelAndView.addObject("productList", productList);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(Product product) {
        System.out.println(product.getDepartureTime());
        productService.save(product);
        return "redirect:findAll";
    }



}
