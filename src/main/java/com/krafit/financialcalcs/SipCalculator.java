package com.krafit.financialcalcs;

import org.springframework.stereotype.Service;

@Service
    public class SipCalculator {

        public double calculateSIP(double principal, double rateOfInterest, int periods) {

            // Edge cases handling
            if (principal <= 0 || rateOfInterest < 0 || periods <= 0) {
                throw new IllegalArgumentException("Invalid input values");
            }

            double monthlyRate = rateOfInterest / 12 / 100;
            double futureValue = principal * (((Math.pow(1 + monthlyRate, periods) - 1) / monthlyRate) * (1 + monthlyRate));

            return futureValue;
        }
    }

