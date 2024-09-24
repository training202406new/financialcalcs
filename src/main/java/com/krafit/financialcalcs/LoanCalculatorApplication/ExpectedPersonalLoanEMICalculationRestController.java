package com.krafit.financialcalcs.LoanCalculatorApplication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpectedPersonalLoanEMICalculationRestController {

    @PostMapping("/loanCalculator")
    public ResponseEntity<ExpectedPersonalLoanEMICalculationResponse> calculateExpectedEMIRelatedValues(@RequestBody ExpectedPersonalLoanEMICalculationRequest lcr){
        try{

            if (lcr.getPrincipalAmount() <= 0 || lcr.getTenureInMonths() <= 0 || lcr.getAnnualInterest() < 0) {
                throw new IllegalArgumentException("Invalid input values");
            }

            double monthlyInterest = (lcr.getAnnualInterest()/ 100) / 12;

            double monthlyEMI = (lcr.getPrincipalAmount() * monthlyInterest * Math.pow(1 + monthlyInterest, lcr.getTenureInMonths())) /
                    (Math.pow(1 + monthlyInterest, lcr.getTenureInMonths()) - 1);

            double totalAmountWithInterest = monthlyEMI * 12;

            ExpectedPersonalLoanEMICalculationResponse obj = new ExpectedPersonalLoanEMICalculationResponse();
            obj.loanEMI = lcr;
            obj.monthlyEMI = monthlyEMI;
            obj.totalAmountWithInterest = totalAmountWithInterest;

            return ResponseEntity.ok(obj);
        }catch(Exception e){
            throw new ExpectedPersonalLoanEMICalculationErrorException("Error while calculating EMI: " + e.getMessage());
        }
    }
}
