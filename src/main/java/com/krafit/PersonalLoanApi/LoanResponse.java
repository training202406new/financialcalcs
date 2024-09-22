package com.example.personalLoanUsingRestApi.demo.PersonalLoanApi;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class LoanResponse {
    private double monthlyPayment;
    private String errorMessage;
}
