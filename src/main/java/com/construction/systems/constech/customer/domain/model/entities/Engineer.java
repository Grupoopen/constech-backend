package com.construction.systems.constech.customer.domain.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="engineers")
public class Engineer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min=2,max=50)
    @Column(name="first_name",length = 50,nullable = false)
    private String  firstName;

    @Column(name="last_name",length = 50,nullable = false)
    private String lastName;

    @Column(name="dni",length = 50,nullable = false)
    private String dni;

    @Column(name="age",length = 50,nullable = false)
    private String age;
/*
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="project_id")
    private   Project project;*/


}
