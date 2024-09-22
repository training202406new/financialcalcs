package com.krafit.financialcalcs;

import lombok.Getter;
import lombok.Setter;


    public class SipCalculatorResponse {

        private double futureValue;
        private String error;

        public SipCalculatorResponse(double futureValue) {
            this.futureValue = futureValue;
            this.error = null;
        }

        public SipCalculatorResponse(String error) {
            this.error = error;
            this.futureValue = 0;
        }

        public double getFutureValue() {
            return futureValue;
        }

        public void setFutureValue(double futureValue) {
            this.futureValue = futureValue;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

