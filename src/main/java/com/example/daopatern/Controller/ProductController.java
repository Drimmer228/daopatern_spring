package com.example.daopatern.Controller;

import com.example.daopatern.dao.GenericDAO;
import com.example.daopatern.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final GenericDAO<ProductModel> productDAO;

    @Autowired
    public ProductController(GenericDAO<ProductModel> productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("products", productDAO.getAll());
        return "products/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productDAO.getById(id).orElse(null));
        return "products/show";
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product") ProductModel productModel) {
        return "products/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") ProductModel productModel) {
        productDAO.create(productModel);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("product", productDAO.getById(id).orElse(null));
        return "products/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("product") ProductModel productModel, @PathVariable("id") int id) {
        productDAO.update(id, productModel);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        productDAO.delete(id);
        return "redirect:/products";
    }
}
