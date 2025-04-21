package com.udea.mibank.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udea.mibank.DTO.CustomerDTO;
import com.udea.mibank.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerFacade;

    public CustomerController(CustomerService customerFacade) {
        this.customerFacade = customerFacade;
    }

    //Obtener todos los cliente
    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerFacade.getAllCustomer());
    }

    //Obtener un cliente por un ID
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerFacade.getCustomerById(id));
    }

//Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        if(customerDTO.getBalance() == null) {
            throw new IllegalArgumentException("Balance cannot be null");
        }
        return ResponseEntity.ok(customerFacade.createCustomer(customerDTO));
    }
    
}
