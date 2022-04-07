package it.luca.fraud.service;


import it.luca.fraud.model.Fraud;
import it.luca.fraud.repository.FraudRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudService {

    private final FraudRepository fraudRepository;


    public boolean isFraudlentCustomer(Integer customer){
        fraudRepository.save(
                Fraud.builder()
                        .customerId(customer)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
