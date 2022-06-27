package com.itproger.shopmyapp.controllers;

import com.itproger.shopmyapp.models.Product;
import com.itproger.shopmyapp.projections.TranslationProjection;
import com.itproger.shopmyapp.repo.LanguageRepository;
import com.itproger.shopmyapp.repo.ProductRepository;
import com.itproger.shopmyapp.repo.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private TranslationRepository translationRepository;

    @GetMapping("")
    public String listProducts(Model model){
        List<Product> listProducts = repo.findAll();
        model.addAttribute("listProducts", listProducts);
        return "products";
    }

    @GetMapping("/my")          //потом удалить
    public String myPage(Model model){
     return "my";
    }

    @GetMapping("/products/new")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        return "form_product";
    }

    @PostMapping("/products/save")
    public String saveProduct(Product product){
        repo.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Integer id, Model model){
        Product product = repo.findById(id).get();
        model.addAttribute("product", product);
    return "form_product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, Model model){
        repo.deleteById(id);
        return "redirect:/";
    }


    @GetMapping("/show/{id}")
    public String findProductById(@RequestParam("id") Integer id, Model model){
//        Product product = repo.findById(id).get();
        Product product = repo.getById(id);
        model.addAttribute("product", product);
        return "show";
    }

//    @GetMapping()
//    public List<TranslationProjection> getAllTranslations() {
//        return translationRepository.getAllTranslationsWithLocaleAndId();
//    }
}