package pl.soapworkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.soapworkshop.entity.Product;
import pl.soapworkshop.repository.CategoryRepository;
import pl.soapworkshop.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    //Navbar resources
    @ModelAttribute
    public void addCategories(Model model) {
        model.addAttribute("categories", this.categoryRepository.findAll());
    }

    @RequestMapping(value = "/store/productsList/{id}", method = RequestMethod.GET)
    public String listProducts(@PathVariable Integer id, Model model) {
        //Title
        model.addAttribute("currentCategory", this.categoryRepository.findOne(id));
        //Product list
        model.addAttribute("products", this.productRepository.findProductsByCategoryId(id));
        return "store/productsList";
    }

    @RequestMapping(value = "/store/productDetails/{id}", method = RequestMethod.GET)
    public String productDetails(@PathVariable Integer id, Model model) {
        //Title from the current product
        //Current product
        model.addAttribute("product", this.productRepository.findOne(id));
        return "store/productDetails";
    }


}
