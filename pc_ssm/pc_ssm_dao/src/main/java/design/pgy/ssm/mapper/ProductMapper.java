package design.pgy.ssm.mapper;

import design.pgy.ssm.domain.Product;

import java.util.List;

public interface ProductMapper {

    // 查询所有产品
    List<Product> findAll();

    // 添加一个产品
    void save(Product product);
}
