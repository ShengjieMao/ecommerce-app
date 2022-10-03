package com.ecoproj.ecommerce.service;

import com.ecoproj.ecommerce.dto.Purchase;
import com.ecoproj.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
