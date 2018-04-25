package com.mysql.example.demo.Interfaces;


import com.mysql.example.demo.Models.ProductModel;

import java.util.List;

public interface ProductRepositoryInterface
{
    ProductModel get(int id);
    List<ProductModel> get();
    void create(ProductModel p);
}
