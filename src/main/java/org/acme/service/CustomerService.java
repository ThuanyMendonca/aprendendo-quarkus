package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import org.acme.dto.CustomerDTO;
import org.acme.entity.CustomerEntity;
import org.acme.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@AllArgsConstructor
public class CustomerService {
    @Inject
    private final CustomerRepository customerRepository;

    public List<CustomerDTO> findAllCustomers(){
        List<CustomerDTO> customers = new ArrayList<>();

        customerRepository.findAll().stream().forEach(item->{
            customers.add(mapCustomerEntityToDTO(item));
        });

        return customers;
    }

    public void createCustomer(CustomerDTO customerDTO){
        customerRepository.persist(mapCustomerDTOtoEntity(customerDTO));
    }

    public void changeCustomer(long id, CustomerDTO customerDTO){
        CustomerEntity customer = customerRepository.findById(id);

        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customer.setAge(customerDTO.getAge());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        customerRepository.persist(customer);
    }

    public void deleteCustomer(long id){
        customerRepository.deleteById(id);
    }

    private CustomerDTO mapCustomerEntityToDTO(CustomerEntity customer){
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setAddress(customer.getAddress());
        customerDTO.setAge(customer.getAge());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setName(customer.getName());
        customerDTO.setPhone(customer.getPhone());

        return customerDTO;
    }

    private CustomerEntity mapCustomerDTOtoEntity(CustomerDTO customerDTO){
        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setAddress(customerDTO.getAddress());
        customerEntity.setAge(customerDTO.getAge());
        customerEntity.setName(customerDTO.getName());
        customerEntity.setEmail(customerDTO.getEmail());
        customerEntity.setPhone((customerDTO.getPhone()));

        return customerEntity;
    }
}
