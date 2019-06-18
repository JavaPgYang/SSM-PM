package design.pgy.ssm.mapper;

import design.pgy.ssm.domain.Orders;

import java.util.List;

public interface OrdersMapper {

    List<Orders> findAll();

    Orders findById(String id);

}
