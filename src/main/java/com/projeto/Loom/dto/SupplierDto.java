package com.projeto.Loom.dto;

import com.projeto.Loom.entities.Supplier;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class SupplierDto {
    private Long id;
    @NotBlank
    @NotNull
    private String name;
    @NotNull
    @NotBlank
    private String contact;

    public SupplierDto() {
    }
    public SupplierDto(Supplier supplier) {
        BeanUtils.copyProperties(supplier, this);
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
