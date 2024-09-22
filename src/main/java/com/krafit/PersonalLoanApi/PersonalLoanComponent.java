package com.example.personalLoanUsingRestApi.demo.PersonalLoanApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

    @Component
    public class PersonalLoanComponent {
        private static final Logger logger = LoggerFactory.getLogger(PersonalLoanComponent.class);

        public double calculateMonthlyPayment(double principal, double annualInterestRate, int numberOfPayments) {
            if (annualInterestRate <= 0 || principal <= 0 || numberOfPayments <= 0) {
                logger.warn("Invalid input values: principal={}, annualInterestRate={}, numberOfPayments={}", principal, annualInterestRate, numberOfPayments);
                throw new IllegalArgumentException("Principal, interest rate, and number of payments must be greater than zero.");
            }

            double monthlyInterestRate = annualInterestRate / 100 / 12;
            double numerator = principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments);
            double denominator = Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1;
            double monthlyPayment = numerator / denominator;

            logger.info("Calculated monthly payment: {}", monthlyPayment);
            return monthlyPayment;
        }
    }


