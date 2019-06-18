package design.pgy.ssm.test;

import design.pgy.ssm.domain.Orders;
import design.pgy.ssm.domain.Product;
import design.pgy.ssm.service.OrdersService;
import design.pgy.ssm.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/application_*.xml")
public class ServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrdersService ordersService;

    @Test
    public void test() {
        List<Product> productList = productService.findAll();

        for (Product product : productList) {
            System.out.println(product.getCityName());
        }
    }
    @Test
    public void test1() {
        List<Orders> ordersList = ordersService.findAll(1,4);

        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
    }


//    public static void main(String[] args) {
//        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("classpath*:/spring*/application_*.xml");
////        ProductService productService = app.getBean(ProductService.class);
////        List<Product> productList = productService.findAll();
//
////        for (Product product : productList) {
////            System.out.println(product);
////        }
//
//        OrdersService ordersService = app.getBean(OrdersService.class);
//        List<Orders> ordersList = ordersService.findAll();
//        for (Orders orders : ordersList) {
//            System.out.println(orders);
//        }
//
//    }

}
