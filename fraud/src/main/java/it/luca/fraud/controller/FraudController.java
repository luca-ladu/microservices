package it.luca.fraud.controller;

import it.luca.fraud.dto.FraudResponse;
import it.luca.fraud.service.FraudService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {


    private final FraudService fraudService;

    @GetMapping(path = {"/{customerId}"})
    public  FraudResponse isFraudster(@PathVariable("customerId") Integer customerId){

        Boolean isFraudCustomer =
                fraudService.isFraudlentCustomer(customerId);

        log.info("fraud check request for customer {}",customerId);


        return new FraudResponse(isFraudCustomer);
    }



}
