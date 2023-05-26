package com.example.Parcial_Back;

import com.example.Parcial_Back.entity.Libro_SebastianOrjuela;
import com.example.Parcial_Back.repository.LibroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ContextConfiguration(classes = {com.example.Parcial_Back.ParcialBackApplication.class})
class ParcialBackApplicationTests {

	@Autowired
	private LibroRepository libroRepository;

	@Test
	public void getAll() {
		try {
			Libro_SebastianOrjuela libroSebastianOrjuela = libroRepository.findById(1L).get();
			assertEquals(libroSebastianOrjuela.getId(), 1L);
		} catch (Exception e) {
			assert (false);
		}
	}
	@Test
	public void add() {
		try {
			Libro_SebastianOrjuela libroSebastianOrjuela = new Libro_SebastianOrjuela();
			libroSebastianOrjuela.setTitulo("El principito");
			libroSebastianOrjuela.setAutor("Antoine de Saint-Exupéry");
			libroSebastianOrjuela.setReferencia("Reynal & Hitchcock");
			libroSebastianOrjuela.setPrecio(10000.0);
			libroSebastianOrjuela.setUbicacion("CUNDINAMARCA");
			libroRepository.save(libroSebastianOrjuela);
			Libro_SebastianOrjuela libroSebastianOrjuelaGuardado = libroRepository.findById(1L).get();
			assertEquals(libroSebastianOrjuelaGuardado.getId(), 1L);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert (false);
		}
	}

}
