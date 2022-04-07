package it.luca.fraud.repository;

import it.luca.fraud.model.Fraud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudRepository extends JpaRepository<Fraud,Integer> {
}
