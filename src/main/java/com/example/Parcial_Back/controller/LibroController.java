package com.example.Parcial_Back.controller;

import com.example.Parcial_Back.entity.Libro_SebastianOrjuela;
import com.example.Parcial_Back.repository.LibroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/libro")
@RequiredArgsConstructor
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;


    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        List<Libro_SebastianOrjuela> libroSebastianOrjuelas = new ArrayList<>(libroRepository.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(libroSebastianOrjuelas);
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Libro_SebastianOrjuela libroSebastianOrjuela){
        libroRepository.save(libroSebastianOrjuela);
        return ResponseEntity.status(HttpStatus.CREATED).body(libroSebastianOrjuela);
    }
}
