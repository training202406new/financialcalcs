package com.krafit.financialcalcs.FixedDepositCalculatorApplication;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FixedDepositRequestDetails {
    double principal;
    double rateOfInterest;
    double timePeriod;
    double totalAmount;
    double interestEarned;
}
