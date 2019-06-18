package design.pgy.ssm.service;

import design.pgy.ssm.domain.Orders;

import java.util.List;

public interface OrdersService {

    List<Orders> findAll(Integer page,Integer size);

    Orders findById(String id);

}
