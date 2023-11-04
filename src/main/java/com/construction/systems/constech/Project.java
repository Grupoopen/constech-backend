package com.construction.systems.constech;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {
       
  @Id // PRIMARY KEY
  @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTOINCREMENT o SEQUENCE
  private Integer id;

  @NotNull
  @NotBlank // Validation: Objeto
  @Size(min = 2, max = 50)  // Validation: Objeto
  @Column(name = "project_name", length = 50, nullable = false)  // Validation: tabla
  private String projectName;

  @NotNull
  @NotBlank
  @Size(min = 10, max = 100)
  @Column(name = "project_description", length = 100, nullable = false)  //
  private String projectDescription;

  @NotNull
  @NotBlank
  @Size(min = 10, max = 100)
  @Column(name = "project_leader", length = 100, nullable = false)
  private String projectLeader;

  @NotNull
  @NotBlank
  @Size(min = 4, max = 50)
  @Column(name = "project_status", length = 50, nullable = false)
  private String projectStatus;

  @Past
  @Column(name = "start_date")
  @Temporal(TemporalType.DATE)
  private Date startDate; // lower Camel Case

  @Past
  @Column(name = "finish_date")
  @Temporal(TemporalType.DATE)
  private Date finishDate; // lower Camel Case

}
