package com.krafit.financialcalcs.FixedDepositCalculatorApplication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fixeddeposit")
public class FixedDepositRestController {
    @GetMapping("/calculate")
    public ResponseEntity<?> calculateFd(
            @RequestParam(name = "principal", defaultValue = "0") Double principal,
            @RequestParam(name = "rateOfInterest", defaultValue = "0") Double rateOfInterest,
            @RequestParam(name = "timePeriod", defaultValue = "0") Double timePeriod) {

        // Validate input values
        if (principal <= 0 || rateOfInterest <= 0 || timePeriod <= 0) {
            return ResponseEntity.badRequest().body(new FixedDepositErrorResponse("Principal, rate of interest, and time period must be positive numbers."));
        }

        // Calculate compound interest
        double amount = principal * Math.pow(1 + (rateOfInterest / 100), timePeriod);
        double interest = amount - principal;

        FixedDepositRequestDetails response = new FixedDepositRequestDetails(
                principal, rateOfInterest, timePeriod, round(amount, 2), round(interest, 2));

        return ResponseEntity.ok(response);
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException("Negative places not allowed.");
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
