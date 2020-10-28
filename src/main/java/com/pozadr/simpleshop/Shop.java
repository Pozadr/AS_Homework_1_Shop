package com.pozadr.simpleshop;

import java.math.BigDecimal;
import java.util.List;

public interface Shop {
    BigDecimal getBasketPrice();
    List<Product> getShoppingBasket();
}
