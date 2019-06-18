package design.pgy.ssm.service;

import design.pgy.ssm.domain.Product;

import java.util.List;

public interface ProductService {

    // 查询所有产品
    List<Product> findAll();

    // 添加一个产品
    void save(Product product);
}
