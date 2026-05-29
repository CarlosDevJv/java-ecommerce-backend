package com.projeto.Loom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
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
