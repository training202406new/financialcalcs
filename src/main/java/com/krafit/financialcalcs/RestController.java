package com.krafit.financialcalcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class RestController {



    @org.springframework.web.bind.annotation.RestController
    public class RestController2 {

        @Autowired
        private SipCalculator sipService;



        @GetMapping("/calculate-sip")
        public ResponseEntity<SipCalculatorResponse> calculateSIP(
                @RequestParam(value = "principal") double principal,
                @RequestParam(value = "rateOfInterest") double rateOfInterest,
                @RequestParam(value = "periods") int periods) {

            try {
                double futureValue = sipService.calculateSIP(principal, rateOfInterest, periods);
                return new ResponseEntity<>(new SipCalculatorResponse(futureValue), HttpStatus.OK);
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>
                        (new SipCalculatorResponse("Error: " + e.getMessage()), HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                return new ResponseEntity<>
                        (new SipCalculatorResponse("Unexpected error occurred"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}
