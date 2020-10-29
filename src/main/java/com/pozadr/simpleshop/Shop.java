package com.pozadr.simpleshop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface Shop {
    BigDecimal getBasketPrice();

    List<Product> getShoppingBasket();

    default List<Product> setShoppingBasket() {
        List<Product> shoppingBasket = new ArrayList<>();
        Random random = new Random();

        // task: 5 products in shopping basket
        for (int i = 0; i < 5; i++) {
            // double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
            shoppingBasket.add(new Product("Prod_" + (i + 1), BigDecimal.valueOf(50 + (300 - 50) * random.nextDouble())));
        }
        return shoppingBasket;
    }
}
