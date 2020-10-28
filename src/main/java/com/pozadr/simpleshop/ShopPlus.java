package com.pozadr.simpleshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;



@Service
@Profile("Plus")
public class ShopPlus {
    @Value("${vat.value}")
    protected Integer vat;

    public ShopPlus() {
        super();
    }



    /*@Override
    public BigDecimal getBasketPrice() {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Product product : shoppingBasket) {
            sum = sum.add(product.getPrice());
        }
        System.out.println(sum);
        //int vatPrice = sum * vat;
       // vatPrice /= 100;
       // sum += vatPrice;
       // System.out.println(sum);
        return sum;
    }



    @EventListener(ApplicationReadyEvent.class)
    public void printShopName() {
        System.out.println("Shop PLUS");
    }

    @EventListener(ApplicationReadyEvent.class)
    public void logBasketPrice() {
        System.out.println("Basket price = " + getBasketPrice());
    }

     */
}
