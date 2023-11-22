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
@Table(name="projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(min=2,max=50)
    @Column(name="title",length = 50,nullable = false)
    private String  title;

    @Column(name="description",length = 50,nullable = false)
    private String description;

    @Column(name="name",length = 50,nullable = false)
    private String name;

    @Column(name="end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;

/*
    @OneToMany(mappedBy = "engineer")
    private List<Engineer> engineer;*/

    public Project() {

        this.endDate = new Date();
    }


}

