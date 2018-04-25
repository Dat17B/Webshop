package com.mysql.example.demo.Controllers;

import com.mysql.example.demo.Interfaces.ProductRepositoryInterface;
import com.mysql.example.demo.Models.ProductModel;
import com.mysql.example.demo.Models.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController
{
    @Autowired
    private ProductRepositoryInterface repository = new ProductRepository();

    @RequestMapping("/product/details")
    public String home(Model model) {
        model.addAttribute("product", repository.get(1));
        return "product/details";
    }

    @GetMapping("/product/")
    public String productIndex(Model model) {
        model.addAttribute("products", repository.get());
        return "product/index";
    }

    @RequestMapping(value = "/product/create", method = RequestMethod.GET)
    public String create(Model model){
        model.addAttribute("product", new ProductModel());
        return "product/create";
    }

    @RequestMapping(value = "/product/create", method = RequestMethod.POST)
    public String create(@ModelAttribute ProductModel product){
        System.out.println("Post create");
        System.out.println("Model example: " + product);
        repository.create(product);

        return "redirect:/product/";
    }
}


















