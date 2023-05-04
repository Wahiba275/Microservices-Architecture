package org.sid.projet_spring.repositories;


import org.sid.projet_spring.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
