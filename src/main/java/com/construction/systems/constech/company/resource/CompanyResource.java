package com.construction.systems.constech.company.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResource {
    private Integer id;
    private String ruc;
    private String companyName;
    private String description;
    private String ceo;
    private String address;
    private String contactMail;
    private String contactNumber;
}
