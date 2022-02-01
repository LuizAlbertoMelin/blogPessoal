package org.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		usuarioRepository.save(new Usuario(0L, "Luiz silva", "luiz@email.com", "13465278"));
		usuarioRepository.save(new Usuario(0L, "Daniel silva", "daniel@email.com", "13465278"));
		usuarioRepository.save(new Usuario(0L, "Glaucya silva", "glaucya@email.com", "13465278" ));
		usuarioRepository.save(new Usuario(0L, "Rebeca", "rebeca@email.com", "13465278"));
		
	}
	@Disabled
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {
		
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("luiz@email.com");
		assertTrue(usuario.get().getUsuario().equals("luiz@email.com"));
		
	}
	@Disabled
	@Test
	@DisplayName("retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("silva");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Luiz silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Daniel silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Glaucya silva"));
	}
	
	
}