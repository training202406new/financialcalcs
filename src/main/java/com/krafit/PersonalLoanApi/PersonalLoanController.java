package com.example.personalLoanUsingRestApi.demo.PersonalLoanApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PersonalLoanController {

    @Autowired
    private PersonalLoanComponent personalLoanComponent;

    @PostMapping("/calculate")
    public ResponseEntity<LoanResponse> calculateMonthlyPayment(@RequestBody LoanRequest loanRequest) {
        double principal = loanRequest.getPrincipal();
        double annualInterestRate = loanRequest.getAnnualInterestRate();
        int numberOfPayments = loanRequest.getNumberOfPayments();


        if (principal <= 0 || annualInterestRate <= 0 || numberOfPayments <= 0) {
            // Return a bad request response if input validation fails
            LoanResponse response = new LoanResponse(0, "Invalid input parameters");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        // Perform calculation
        double monthlyPayment = personalLoanComponent.calculateMonthlyPayment(principal, annualInterestRate, numberOfPayments);

        // Return successful response
        LoanResponse response = new LoanResponse(monthlyPayment, null);
        return ResponseEntity.ok(response);
    }
}
