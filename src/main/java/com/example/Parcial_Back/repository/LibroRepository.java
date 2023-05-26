package com.example.Parcial_Back.repository;

import com.example.Parcial_Back.entity.Libro_SebastianOrjuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro_SebastianOrjuela, Long> {

}
