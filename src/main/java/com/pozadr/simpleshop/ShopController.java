package com.pozadr.simpleshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopController {
    private Shop shop;

    @Autowired
    public ShopController(Shop shop) {
        this.shop = shop;
    }

    @GetMapping("/json")
    public List<Product> getShop() {
        return shop.getShoppingBasket();
    }

    @RequestMapping("/price")
    public String getBasketPrice() {
        return "Basket price = " + shop.getBasketPrice();
    }
}
