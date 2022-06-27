package com.itproger.shopmyapp.models;

import javax.persistence.*;

@Entity
@Table(name = "translations")
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer translationId;

    @Column(name = "product_name", length = 200)
    private String product_name;

    @Column(name = "product_specification", length = 100000)
    private String product_specification;

    @Column(name = "product_price", nullable = false)
    private int product_price;

    @Column(name = "translate_key", length = 1000)
    private String key;

    @ManyToOne
    @JoinColumn(name = "locale")
    private Language language;

    // Constructor, getters, setters
    public Translation() {}

    public Integer getTranslationId() {
        return translationId;
    }

    public void setTranslationId(Integer translationId) {
        this.translationId = translationId;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_specification() {
        return product_specification;
    }

    public void setProduct_specification(String product_specification) {
        this.product_specification = product_specification;
    }

    public int getProduct_price() {
        return product_price;
    }

    public void setProduct_price(int product_price) {
        this.product_price = product_price;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}