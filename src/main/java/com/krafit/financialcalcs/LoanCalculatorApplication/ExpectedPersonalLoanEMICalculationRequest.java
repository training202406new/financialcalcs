package com.krafit.financialcalcs.LoanCalculatorApplication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpectedPersonalLoanEMICalculationRequest {
    int principalAmount;
    int tenureInMonths;
    double annualInterest;
}
