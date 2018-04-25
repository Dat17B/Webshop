package com.mysql.example.demo.Models.Repositories;

import com.mysql.example.demo.Interfaces.ProductRepositoryInterface;
import com.mysql.example.demo.Models.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ProductRepositoryInterface
{
    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public ProductModel get(int id)
    {
        String sql = "select * from Products where productId = " + id;

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        rs.next();

        // (int id, int webshopId, int quantity, String title, double price)
        ProductModel product =
                new ProductModel(rs.getInt(1), rs.getInt(3),
                        rs.getInt(5), rs.getString(2),
                        rs.getDouble(4));

        return product;
    }

    @Override
    public List<ProductModel> get()
    {
        List<ProductModel> products = new ArrayList<>();
        String sql = "select * from Products";

        SqlRowSet rs = jdbc.queryForRowSet(sql);

        while (rs.next()) {
            products.add(new ProductModel(rs.getInt(1), rs.getInt(3),
                    rs.getInt(5), rs.getString(2),
                    rs.getDouble(4)));
        }

        return products;
    }

    @Override
    public void create(ProductModel p) {
        String sql =
                "insert into Products(title, webshopId, prize, quantity) " +
                        "values(" + p.toSQl() + ")";

        int rowsAffected = jdbc.update(sql);
        System.out.println("Rows affected: " + rowsAffected);
    }
}




















