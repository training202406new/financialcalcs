package com.krafit.financialcalcs.LoanCalculatorApplication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanCalculatorRestController {

    @PostMapping("/loanCalculator")
    public ResponseEntity<LoanCalculatorHelper> getLoanDetails(@RequestBody LoanCalculator lc){

        double monthlyInterest = (lc.getAnnualInterest()/ 100) / 12;

        double monthlyEMI = (lc.getPrincipalAmount() * monthlyInterest * Math.pow(1 + monthlyInterest, lc.getTenureOfMonths())) /
                (Math.pow(1 + monthlyInterest, lc.getTenureOfMonths()) - 1);

        double totalAmountWithInterest = monthlyEMI * 12;

        LoanCalculatorHelper obj = new LoanCalculatorHelper();
        obj.loanCalculator = lc;
        obj.monthlyEMI = monthlyEMI;
        obj.totalAmountWithInterest = totalAmountWithInterest;

        return ResponseEntity.ok(obj);
    }

}
