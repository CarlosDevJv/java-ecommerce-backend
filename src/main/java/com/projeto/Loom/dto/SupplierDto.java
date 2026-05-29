package com.projeto.Loom.dto;

import com.projeto.Loom.entities.Supplier;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Getter
@Setter
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

}
