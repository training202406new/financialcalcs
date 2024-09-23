package com.krafit.financialcalcs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoanRequest {
    double principal;
    double annualInterestRate;
    int numberOfPayments;



}
