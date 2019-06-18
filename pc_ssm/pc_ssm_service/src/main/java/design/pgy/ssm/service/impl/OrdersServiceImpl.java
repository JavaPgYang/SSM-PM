package design.pgy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import design.pgy.ssm.domain.Orders;
import design.pgy.ssm.mapper.OrdersMapper;
import design.pgy.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Orders> ordersList = ordersMapper.findAll();
        return ordersList;
    }

    @Override
    public Orders findById(String id) {
        return ordersMapper.findById(id);
    }
}
