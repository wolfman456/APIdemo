package com.contact.apidemo.model;

import com.sun.istack.NotNull;
import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private Integer phone;

    @Column
    @NotNull
    private String name;

    @Column
    private String email;


}
