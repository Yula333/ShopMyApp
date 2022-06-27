package com.itproger.shopmyapp.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.util.pattern.PathPatternRouteMatcher;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//@EnableJpaAuditing
@Entity
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //    @NotEmpty(message = "Name should not be empty")
    @Column(length = 200, nullable = false, unique = true)
    private String name;

    @Column(length = 100000, nullable = false)
    private String specification;

//    @Min(value = 1, message = "Price should be greater than 0")
    @Column(nullable =  false)
    private int price;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfCreate", nullable = false, updatable = false)
    private Date dateOfCreate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfChange")
    private Date dateOfChange;

    @ManyToOne
    @JoinColumn(name = "locale")
    private Language language;

    public Product() {
    }

    public Product(Integer id, String name, String specification, int price, Date dateOfCreate, Date dateOfChange) {
        this.id = id;
        this.name = name;
        this.specification = specification;
        this.price = price;
        this.dateOfCreate = dateOfCreate;
        this.dateOfChange = dateOfChange;
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(Date dateOfCreate) throws ParseException {
        dateOfCreate = new Date();
        this.dateOfCreate = dateOfCreate;
    }

    public Date getDateOfChange() {
        return dateOfChange;
    }

    public void setDateOfChange(Date dateOfChange) {
        dateOfChange = new Date();
        this.dateOfChange = dateOfChange;
    }
}
