package com.udea.mibank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


import com.udea.mibank.DTO.TransactionDTO;
import com.udea.mibank.entity.Transaction;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
    TransactionDTO  toDTO(Transaction transaction);
    Transaction  toEntity(TransactionDTO transactionDTO);
    
}
