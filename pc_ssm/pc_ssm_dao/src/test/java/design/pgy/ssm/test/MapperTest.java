package design.pgy.ssm.test;

import design.pgy.ssm.domain.Orders;
import design.pgy.ssm.domain.Product;
import design.pgy.ssm.domain.Role;
import design.pgy.ssm.domain.UserInfo;
import design.pgy.ssm.mapper.OrdersMapper;
import design.pgy.ssm.mapper.ProductMapper;
import design.pgy.ssm.mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MapperTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring/application_mapper.xml");
        ProductMapper productMapper = app.getBean(ProductMapper.class);
        List<Product> productList = productMapper.findAll();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Test
    public void test1() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring/application_mapper.xml");
        OrdersMapper ordersMapper = app.getBean(OrdersMapper.class);
        List<Orders> ordersList = ordersMapper.findAll();
        for (Orders orders : ordersList) {
            System.out.println(orders);
        }
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("spring/application_mapper.xml");
        UserMapper userMapper = app.getBean(UserMapper.class);
        UserInfo userInfo = userMapper.findByName("tom");

        System.out.println(userInfo.getUserName() + "_" + userInfo.getPassword());

        List<Role> roleList = userInfo.getRoleList();
        for (Role role : roleList) {
            System.out.println(role.getRoleName());
        }

    }

}
