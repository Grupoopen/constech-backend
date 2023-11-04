package com.construction.systems.constech;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "companies")
public class Company {
    
  @Id // PRIMARY KEY
  @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT o SEQUENCE
  private Integer id;

  @NotNull
  @NotBlank // Validation: Objeto
  @Size(min = 2, max = 50)  // Validation: Objeto
  @Column(name = "company_name", length = 50, nullable = false)  // Validation: tabla
  private String companyName;

  @NotNull
  @NotBlank // Validation: Objeto
  @Size(min = 11, max = 11)  // Validation: Objeto
  @Column(name = "ruc", length = 11, nullable = false)
  private String ruc;

  @NotNull
  @NotBlank
  @Size(min = 10, max = 100)
  @Column(name = "company_description", length = 100, nullable = false)  //
  private String companyDescription;

  @NotNull
  @NotBlank
  @Size(min = 8, max = 12)
  @Column(name = "company_ceo", length = 12, nullable = false)
  private String companyCeo;

  @NotNull
  @NotBlank
  @Size(min = 8, max = 12)
  @Column(name = "company_address", length = 12, nullable = false)
  private String companyAddress;


}

