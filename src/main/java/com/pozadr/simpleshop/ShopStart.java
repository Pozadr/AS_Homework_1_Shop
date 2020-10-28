package com.pozadr.simpleshop;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
@Profile("Start")
public class ShopStart implements Shop {
    private List<Product> shoppingBasket;

    public ShopStart() {
        shoppingBasket = new ArrayList<>();
        Random random = new Random();

        // double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        shoppingBasket.add(new Product("Carrot", BigDecimal.valueOf(50 + (300 - 50) * random.nextDouble())));
        shoppingBasket.add(new Product("Cucumber", BigDecimal.valueOf(50 + (300 - 50) * random.nextDouble())));
        shoppingBasket.add(new Product("Tomatoes", BigDecimal.valueOf(50 + (300 - 50) * random.nextDouble())));
        shoppingBasket.add(new Product("Paprika", BigDecimal.valueOf(50 + (300 - 50) * random.nextDouble())));
        shoppingBasket.add(new Product("Avocado", BigDecimal.valueOf(50 + (300 - 50) * random.nextDouble())));    }

    @Override
    public BigDecimal getBasketPrice() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Product product : shoppingBasket) {
            sum = sum.add(product.getPrice());
        }
        return sum;
    }

    public List<Product> getShoppingBasket() {
        return shoppingBasket;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void logShopName() {
        System.out.println("Shop START");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void logBasketPrice() {
        System.out.printf("Basket price = %.2f", getBasketPrice());
    }
}
