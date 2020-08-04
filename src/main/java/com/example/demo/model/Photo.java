package com.example.demo.model;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
public class Photo {

    @Id
    @Column(length = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "sequence" )
    @SequenceGenerator( name = "sequence" , initialValue = 1 , allocationSize = 1)
    private int id;

    @Column(length = 120)
    private String Title;

    @Column(length = 255)
    private String description;

    @Column(length = 20)
    private String privacy;

    @Column
    private Date uploadDate;

    @Column
    @Lob
    private Blob View;
}
