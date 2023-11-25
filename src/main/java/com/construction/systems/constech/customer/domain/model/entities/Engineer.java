package com.construction.systems.constech.customer.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="engineers")
public class Engineer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min=2, max=50)
    @Column(name="first_name", length = 50, nullable = false)
    private String  firstName;

    @NotBlank
    @Size(min=2, max=50)
    @Column(name="last_name", length = 50, nullable = false)
    private String lastName;

    @NotBlank
    @Size(min=2, max=50)
    @Column(name="dni", length = 50, nullable = false)
    private String dni;

    @NotBlank
    @Size(min=2, max=50)
    @Column(name="age", length = 50, nullable = false)
    private String age;

    @Column(name="email", length = 255)
    private String email;

    @Column(name="dob")
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column(name="gender", length = 10)
    private String gender;

    @Column(name="education", length = 50)
    private String education;

    @Column(name="company", length = 100)
    private String company;

    @Column(name="experience")
    private Integer experience;

    @Column(name="package_amount")
    private Double packageAmount;

}
