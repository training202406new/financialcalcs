package com.krafit.financialcalcs.FixedDepositCalculatorApplication;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class FixedDepositRequest {
    List<FixedDepositRequestDetails> myFixedDepositRequest;
}
