package com.udea.mibank.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.udea.mibank.DTO.TransactionDTO;
import com.udea.mibank.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionFacade;

    public TransactionController(TransactionService transactionFacade) {
        this.transactionFacade = transactionFacade;
    }
    
    // Crear una transación
    @PostMapping
    public ResponseEntity<TransactionDTO> transferMoney(@RequestBody TransactionDTO transactionDTO) {
        // Corrected null check and message
        if (transactionDTO.getAmount() == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
        return ResponseEntity.ok(transactionFacade.transferMoney(transactionDTO));
    }

    //Obtener historial de una cuenta
    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsForAccount(@PathVariable String accountNumber) {
        List<TransactionDTO> transactions = transactionFacade.getTransactionsForAccount(accountNumber);
        return ResponseEntity.ok(transactions);
    }

}
