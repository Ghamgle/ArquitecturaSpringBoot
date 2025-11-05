package com.scalian.ArquitecturaSpringBoot;

import com.scalian.ArquitecturaSpringBoot.model.entity.Libro;
import com.scalian.ArquitecturaSpringBoot.model.entity.Persona;
import com.scalian.ArquitecturaSpringBoot.repository.LibroRepository;
import com.scalian.ArquitecturaSpringBoot.repository.PersonaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ArquitecturaSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArquitecturaSpringBootApplication.class, args);
	}

    @Bean
    public CommandLineRunner init(PersonaRepository repositorio, LibroRepository lrepositorio){
        return  args -> {
            repositorio.save(new Persona(null,"Álvaro", 30));
            repositorio.save(new Persona(null, "Lucía", 25));

            lrepositorio.save(new Libro(null, "El nombre del viento", "Patrick Rothfuss", 662));
            lrepositorio.save(new Libro(null, "La sombra del viento", "Carlos Ruiz Zafón", 565));
            lrepositorio.save(new Libro(null, "Cien años de soledad", "Gabriel García Márquez", 471));
            lrepositorio.save(new Libro(null, "El Señor de los Anillos", "J.R.R. Tolkien", 1216));
            lrepositorio.save(new Libro(null, "1984", "George Orwell", 328));
            lrepositorio.save(new Libro(null, "Don Quijote de la Mancha", "Miguel de Cervantes", 863));
            lrepositorio.save(new Libro(null, "Crónica de una muerte anunciada", "Gabriel García Márquez", 120));
            lrepositorio.save(new Libro(null, "Rayuela", "Julio Cortázar", 600));
            lrepositorio.save(new Libro(null, "Fahrenheit 451", "Ray Bradbury", 249));
            lrepositorio.save(new Libro(null, "La metamorfosis", "Franz Kafka", 120));



        };
    }

}
