package com.scalian.ArquitecturaSpringBoot.model.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class LibroDTO {
    private String titulo;
    private String autor;


    @Min(value=1, message="El libro debe tener al menos 1 página")
    private int paginas;
}
