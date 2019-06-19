package design.pgy.ssm.test;

import design.pgy.ssm.domain.Orders;
import design.pgy.ssm.domain.Product;
import design.pgy.ssm.domain.Role;
import design.pgy.ssm.domain.UserInfo;
import design.pgy.ssm.mapper.OrdersMapper;
import design.pgy.ssm.mapper.ProductMapper;
import design.pgy.ssm.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application_mapper.xml")
public class MapperTest {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        List<Product> productList = productMapper.findAll();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Test
    public void test1() {
        List<Orders> ordersList = ordersMapper.findAll();
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
    }

    @Test
    public void test2() {
        UserInfo userInfo = userMapper.findByName("lucy");
        System.out.println(userInfo);
    }

    @Test
    public void test3() {
        UserInfo userInfo = userMapper.findById("001");
        System.out.println(userInfo);
    }

}
