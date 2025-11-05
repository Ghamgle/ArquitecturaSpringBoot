package com.scalian.ArquitecturaSpringBoot.repository;

import com.scalian.ArquitecturaSpringBoot.model.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByAutorContainingIgnoreCase(String autor);

    @Query("Select lib FROM Libro lib where lib.paginas> :paginas")
    List<Libro> buscarlibrosdemaspaginas(@Param("paginas") int paginas);
}
