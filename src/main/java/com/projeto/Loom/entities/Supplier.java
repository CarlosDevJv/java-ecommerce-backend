package com.projeto.Loom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Objects;

@Entity
public class Supplier {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String CPNJ;
    @NotBlank
    @NotNull
    private String contact;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL)
    private List<Product> productList;



    public Supplier(Long id, String name, String CPNJ, String contact) {
        this.id = id;
        this.name = name;
        this.CPNJ = CPNJ;
        this.contact = contact;
    }

    public Supplier() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCPNJ() {
        return CPNJ;
    }

    public void setCPNJ(String CPNJ) {
        this.CPNJ = CPNJ;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @JsonIgnore
    public List<Product> getProductList() {
        return productList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
