package com.construction.systems.constech.company.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResource {
    private Integer id;
    private String assigned;
    private String title;
    private String description;
    private String status;
    private String initialDate;
    private String deadline;
}
