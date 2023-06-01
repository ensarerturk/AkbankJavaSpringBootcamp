package org.example.customer;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.customer.enums.EnumStatus;
import org.example.general.BaseEntity;

/*
 * contains the "Customer" class, which represents a customer.
 * This class is used to store a customer's information and corresponds to a table in the database.
 * */

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "Customer", sequenceName = "CUSTOMER_ID_SEQ")
    private Long id;

    @Column(name = "NAME", length = 50, nullable = false, unique = true)
    private String name;

    @Email
    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 11, nullable = false, unique = true)
    private String phoneNumber;

    @Column(length = 30)
    @Enumerated(EnumType.STRING)
    private EnumStatus status;
}