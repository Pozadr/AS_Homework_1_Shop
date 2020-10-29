package com.pozadr.simpleshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


@Service
@Profile("Plus")
public class ShopPlus implements Shop {
    @Value("${tax.value}")
    private BigDecimal tax;
    private final List<Product> shoppingBasket;


    public ShopPlus() {
        shoppingBasket = setShoppingBasket();
    }

    @Override
    public BigDecimal getBasketPrice() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Product product : shoppingBasket) {
            sum = sum.add(product.getPrice());
        }
        sum = sum.multiply((tax.divide(BigDecimal.valueOf(100))).add(BigDecimal.valueOf(1)));
        return sum;
    }

    @Override
    public List<Product> getShoppingBasket() {
        return shoppingBasket;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void logShopName() {
        System.out.println("\nShop PLUS: price + tax(" + tax + "%)");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void logBasketPrice() {
        System.out.printf("Basket price = %.2f", getBasketPrice());
    }
}
