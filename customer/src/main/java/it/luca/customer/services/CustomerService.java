package it.luca.customer.services;

import it.luca.customer.dto.FraudResponse;
import it.luca.customer.model.Customer;
import it.luca.customer.dto.CustomerRegistrationRequest;
import it.luca.customer.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .lastName(request.lastName())
                .email(request.email())
                .firstName(request.firstName())
                .build();


        customerRepository.saveAndFlush(customer);

        FraudResponse response = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudResponse.class,
                customer.getId()
        );

        if(response.isFrauster()){
            throw new IllegalStateException("Fraudster");
        }

    }
}
