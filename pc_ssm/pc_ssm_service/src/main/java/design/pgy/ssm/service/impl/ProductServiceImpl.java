package design.pgy.ssm.service.impl;

import design.pgy.ssm.domain.Product;
import design.pgy.ssm.mapper.ProductMapper;
import design.pgy.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAll() {
        List<Product> productList = productMapper.findAll();
        return productList;
    }

    @Override
    public void save(Product product) {
        productMapper.save(product);
    }
}
