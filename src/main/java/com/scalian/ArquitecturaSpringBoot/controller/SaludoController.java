package com.scalian.ArquitecturaSpringBoot.controller;

import com.scalian.ArquitecturaSpringBoot.model.Saludo;
import com.scalian.ArquitecturaSpringBoot.service.SaludoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SaludoController
{
    private final SaludoService saludoService;
    public SaludoController(SaludoService saludoService){
        this.saludoService = saludoService;
    }

    @Value("${mensaje.bienvenido}")
    private String mensajeBienvenida;

    @GetMapping("/saludo")
    public Saludo obtenerSaludo(@RequestParam String nombre){
        return saludoService.generarSaludo(nombre);
    }

    @GetMapping("/saludoValue")
    public Saludo obtenerSaludoValue(@RequestParam String nombre){
        return new Saludo(mensajeBienvenida + " " + nombre);
    }

}
