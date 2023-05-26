package com.example.Parcial_Back;

import com.example.Parcial_Back.entity.Libro;
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
			Libro libro = libroRepository.findById(1L).get();
			assertEquals(libro.getId(), 1L);
		} catch (Exception e) {
			assert (false);
		}
	}
	@Test
	public void add() {
		try {
			Libro libro = new Libro();
			libro.setTitulo("El principito");
			libro.setAutor("Antoine de Saint-Exupéry");
			libro.setReferencia("Reynal & Hitchcock");
			libro.setPrecio(10000.0);
			libro.setUbicacion("CUNDINAMARCA");
			libroRepository.save(libro);
			Libro libroGuardado = libroRepository.findById(1L).get();
			assertEquals(libroGuardado.getId(), 1L);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assert (false);
		}
	}

}
