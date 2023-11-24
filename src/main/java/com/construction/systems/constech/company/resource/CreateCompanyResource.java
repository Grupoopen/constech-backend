package com.construction.systems.constech.company.resource;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CreateCompanyResource {

    @NotNull
    @NotBlank
    @Size(min = 11, max = 11)
    private String ruc;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String companyName;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String description;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String ceo;

    @NotNull
    @NotBlank
    @Size(min = 20, max = 100)
    private String address;

    @NotNull
    @NotBlank
    @Size(min = 20, max = 50)
    private String contactMail;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 20)
    private String contactNumber;

}
