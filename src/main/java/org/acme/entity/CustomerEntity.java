package org.acme.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
// Data já injeta os metodos construtores, gets e sets
public class CustomerEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String address;
    private Long age;
}
