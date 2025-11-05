package com.scalian.ArquitecturaSpringBoot.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LibroDTO {

    @NotBlank(message = "El título no puede estar vacío")
    @Size(max = 100, message = "El título no puede tener mas de 100 caracteres")
    private String titulo;

    @NotBlank(message = "El autor no puede estar vacío")
    @Size(max = 50, message = "El autor no puede tener mas de 50 caracteres")
    private String autor;


    @Min(value=1, message="El libro debe tener al menos 1 página")
    private int paginas;
}
