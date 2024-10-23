package com.binhcodev.spring_boot_ecommerce.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.binhcodev.spring_boot_ecommerce.dtos.requests.PaymentRequest;
import com.binhcodev.spring_boot_ecommerce.entities.Payment;
import com.binhcodev.spring_boot_ecommerce.entities.User;
import com.binhcodev.spring_boot_ecommerce.repositories.PaymentRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaymentService {
    private PaymentRepository paymentRepository;
    private UserService userService;

    public PaymentService(@Value("${stripe.key.secret}") String secretKey) {
        Stripe.apiKey = secretKey;
    }

    public PaymentIntent createPaymentIntent(PaymentRequest paymentInfoRequest) throws StripeException {
        List<String> paymentMethodTypes = new ArrayList<>();
        paymentMethodTypes.add("card");

        Map<String, Object> params = new HashMap<>();
        params.put("amount", paymentInfoRequest.getAmount());
        params.put("currency", paymentInfoRequest.getCurrency());
        params.put("payment_method_types", paymentMethodTypes);

        return PaymentIntent.create(params);
    }

    public void stripePayment() throws Exception {
        User currentUser = userService.getCurrentUser();
        Payment payment = paymentRepository.findByUserEmail(currentUser.getEmail());

        if (payment == null) {
            throw new Exception("Payment information is missing");
        }
        payment.setAmount(00.00);
        paymentRepository.save(payment);
    }
}
