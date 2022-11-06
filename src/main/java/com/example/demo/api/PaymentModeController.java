package com.example.demo.api;

import com.example.demo.domain.PaymentMode;
import com.example.demo.service.PaymentModeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/payment-mode")
public class PaymentModeController {

    private final PaymentModeService paymentModeService;

    public PaymentModeController(PaymentModeService paymentModeService) {
        this.paymentModeService = paymentModeService;
    }

    @GetMapping()
    public List<PaymentMode> findAllPaymentMode(){
        return paymentModeService.findAllPaymentMode();
    }

    @GetMapping("/{id}")
    public Optional<PaymentMode> findPaymentModeById(@PathVariable("id") Long id){
        return paymentModeService.findById(id);
    }

    @PostMapping
    public PaymentMode savePaymentMode(@RequestBody PaymentMode paymentMode){
        return paymentModeService.savePaymentMode(paymentMode);
    }

    @PutMapping
    public PaymentMode updatePaymentMode(@RequestBody PaymentMode paymentMode){
        return paymentModeService.updatePaymentMode(paymentMode);
    }

    @DeleteMapping("/{id}")
    public void deletePaymentMode(@PathVariable("id") Long id){
        paymentModeService.deletPaymentMode(id);
    }

}
