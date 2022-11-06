package com.example.demo.api;

import com.example.demo.domain.Payment;
import com.example.demo.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping()
    public List<Payment> findAllPayment(){
        return paymentService.findAllPayment();
    }

    @GetMapping("/{id}")
    public Optional<Payment> findPaymentById(@PathVariable("id") Long id){
        return paymentService.findById(id);
    }

    @PostMapping
    public Payment savePayment(@RequestBody Payment payment){
        return paymentService.savePayment(payment);
    }

    @PutMapping
    public Payment updatePayment(@RequestBody Payment payment){
        return paymentService.updatePayment(payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable("id") Long id){
        paymentService.deletePayment(id);
    }

}
