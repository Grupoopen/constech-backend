package com.construction.systems.constech.company.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company {
    @Id//PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    @Column(name="ruc", length = 11, nullable = false)
    private String ruc;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="companyName", length = 50, nullable = false)
    private String companyName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="description", length = 50, nullable = false)
    private String description;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name="ceo", length = 50, nullable = false)
    private String ceo;

    @NotNull
    @NotBlank
    @Size(min = 20, max = 100)
    @Column(name="address", length = 100, nullable = false)
    private String address;

    @NotNull
    @NotBlank
    @Size(min = 20, max = 50)
    @Column(name="contactMail", length = 50, nullable = false)
    private String contactMail;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 20)
    @Column(name="contactNumber", length = 20, nullable = false)
    private String contactNumber;

}
