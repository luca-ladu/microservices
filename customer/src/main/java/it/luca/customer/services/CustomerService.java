package it.luca.customer.services;

import it.luca.customer.model.Customer;
import it.luca.customer.dto.CustomerRegistrationRequest;
import it.luca.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public record CustomerService(CustomerRepository customerRepository) {



    public void registerCustomer(CustomerRegistrationRequest request){
        Customer customer = Customer.builder()
                .lastName(request.lastName())
                .email(request.email())
                .firstName(request.firstName())
                .build();

        customerRepository.save(customer);



    }
}
