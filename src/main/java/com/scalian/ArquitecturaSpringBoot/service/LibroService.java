package com.scalian.ArquitecturaSpringBoot.service;

import com.scalian.ArquitecturaSpringBoot.model.dto.LibroDTO;
import com.scalian.ArquitecturaSpringBoot.model.entity.Libro;
import com.scalian.ArquitecturaSpringBoot.repository.LibroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class LibroService {
    private final LibroRepository libroRepository;

    private LibroDTO MapLibroToLibroDTO(Libro libro){
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setTitulo(libro.getTitulo());
        libroDTO.setAutor(libro.getAutor());
        libroDTO.setPaginas(libro.getPaginas());
        return libroDTO;
    }

    public List<LibroDTO> obtenerTodos(){
        return libroRepository.findAll().stream()
                .map( this::MapLibroToLibroDTO)
                .collect(Collectors.toList());
    }

    public Libro crearLibro(LibroDTO libroDTO){
        Libro libro = new Libro(null, libroDTO.getTitulo(), libroDTO.getAutor(), libroDTO.getPaginas());
        return libroRepository.save(libro);
    }

    public List<LibroDTO> buscarPorAutor (String autor){
        return libroRepository.findByAutorContainingIgnoreCase(autor).stream()
                .map(this::MapLibroToLibroDTO)
                .collect(Collectors.toList());
    }

    public List<LibroDTO> buscarNumPaginas (int paginas){
        return libroRepository.buscarlibrosdemaspaginas(paginas).stream()
                .map(this::MapLibroToLibroDTO)
                .collect(Collectors.toList());
    }
}
