package com.udea.mibank.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.udea.mibank.DTO.CustomerDTO;
import com.udea.mibank.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    CustomerDTO toDTO(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);
    
}
