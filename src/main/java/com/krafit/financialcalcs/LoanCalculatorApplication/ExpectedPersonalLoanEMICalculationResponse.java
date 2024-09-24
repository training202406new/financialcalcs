package com.krafit.financialcalcs.LoanCalculatorApplication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExpectedPersonalLoanEMICalculationResponse {
    ExpectedPersonalLoanEMICalculationRequest loanEMI;
    double monthlyEMI;
    double totalAmountWithInterest;
}
