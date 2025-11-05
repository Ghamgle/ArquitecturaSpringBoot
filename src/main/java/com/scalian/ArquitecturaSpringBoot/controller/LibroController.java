package com.scalian.ArquitecturaSpringBoot.controller;

import com.scalian.ArquitecturaSpringBoot.model.dto.LibroDTO;
import com.scalian.ArquitecturaSpringBoot.model.entity.Libro;
import com.scalian.ArquitecturaSpringBoot.service.LibroService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
@AllArgsConstructor
public class LibroController {
    private final LibroService libroService;

    @GetMapping
    public List<LibroDTO> obtenerTodos(){return libroService.obtenerTodos();}

    @PostMapping
    public Libro crearLibro(@RequestBody @Valid LibroDTO libroDTO){
        return libroService.crearLibro(libroDTO);

    }

    @GetMapping("/buscar/autor/{autor}")
    public List<LibroDTO> buscarPorAutor(@PathVariable String autor){
        return libroService.buscarPorAutor(autor);
    }

    @GetMapping("/buscar/paginas/{paginas}")
    public List<LibroDTO> buscarNumPaginas(@PathVariable int paginas){
        return libroService.buscarNumPaginas(paginas);
    }


}
