package com.example.demo;


import com.example.demo.models.Product;
import com.example.demo.models.ProductTop;
import com.example.demo.repositories.ProductRepo;
import com.example.demo.repositories.ProductTopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductTopRepo productTopRepo;


    @PostMapping("/product")
    public String product(@RequestParam String title, @RequestParam String description, @RequestParam String month, @RequestParam Long amount, @RequestParam Long price, @RequestParam Long data) {
        Product products = new Product(title, description, month, amount, price, data);
        productRepo.save(products);

        return "redirect:/";
    }

    @PostMapping("/product/top")
    public String producttop(@RequestParam String title, @RequestParam String description, @RequestParam String month, @RequestParam Long amount, @RequestParam Long price, @RequestParam Long data) {
        ProductTop product = new ProductTop(title, description, month, amount, price, data);
        productTopRepo.save(product);
        return "redirect:/";
    }


    @GetMapping("/")
    public String home(Model model) {
        Iterable<Product> products = productRepo.findAll();
        model.addAttribute("products", products);
        return "index";

    }


    @GetMapping("/shop.html")
    public String shop2() {
        return "shop.html";
    }

    @GetMapping("/cart.html")
    public String blog() {
        return "cart.html";
    }

    @GetMapping("/checkout.html")
    public String checkout() {
        return "checkout.html";
    }

    @GetMapping("/wishlist.html")
    public String wishlist() {
        return "wishlist.html";
    }

    @GetMapping("/sign-in.html")
    public String singin() {
        return "sign-in.html";
    }

    @GetMapping("/sign-up.html")
    public String singup() {
        return "sign-up.html";
    }

    @GetMapping("/contact.html")
    public String contact() {
        return "contact.html";
    }

    @GetMapping("/product")
    public String contact2() {
        return "product-details.html";
    }







}