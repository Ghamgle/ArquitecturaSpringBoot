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

    public List<LibroDTO> obtenerTodos(){
        return libroRepository.findAll().stream()
                .map( l -> {
                    LibroDTO libroDTO = new LibroDTO();
                    libroDTO.setTitulo(l.getTitulo());
                    libroDTO.setAutor(l.getAutor());
                    libroDTO.setPaginas(l.getPaginas());
                    return libroDTO;
                })
                .collect(Collectors.toList());
    }

    public Libro crearLibro(LibroDTO libroDTO){
        Libro libro = new Libro(null, libroDTO.getTitulo(), libroDTO.getAutor(), libroDTO.getPaginas());
        return libroRepository.save(libro);
    }
}
