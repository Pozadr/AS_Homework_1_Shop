package com.pozadr.simpleshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
@Profile("Pro")
public class ShopPro implements Shop {
    @Value("${tax.value}")
    private BigDecimal tax;

    @Value("${discount.value}")
    private BigDecimal discount;

    private List<Product> shoppingBasket;


    public ShopPro() {
        shoppingBasket = setShoppingBasket();
    }

    @Override
    public BigDecimal getBasketPrice() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Product product : shoppingBasket) {
            sum = sum.add(product.getPrice());
        }
        // vat in percentage
        // sum + vat
        sum = sum.multiply((tax.divide(BigDecimal.valueOf(100))).add(BigDecimal.valueOf(1)));

        // discount in percentage
        // sum * discount
        discount = BigDecimal.valueOf(1).subtract(discount.divide(BigDecimal.valueOf(100)));
        sum = sum.multiply(discount);
        return sum;
    }

    @Override
    public List<Product> getShoppingBasket() {
        return shoppingBasket;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void logShopName() {
        System.out.println("\nShop PRO: price + tax(" + tax + "%)" + " - discount(" + discount + "%)");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void logBasketPrice() {
        System.out.printf("Basket price = %.2f", getBasketPrice());
    }
}
