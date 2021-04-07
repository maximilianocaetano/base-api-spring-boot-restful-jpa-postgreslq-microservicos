package curso.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping(value = "/{id}/codigovenda/{venda}", produces = "application/json")
	public ResponseEntity<Usuario> init(@PathVariable(value = "id") Long id,
			@PathVariable(value = "venda") Long venda) {

		Optional<Usuario> usuario = usuarioRepository.findById(id);

		return new ResponseEntity(usuario.get(), HttpStatus.OK);
	}

	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<List<Usuario>> usuario() {
		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);

	}

	@PostMapping(value = "/")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {

		Usuario usuarioSalvo = usuarioRepository.save(usuario);

		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
	}

	
	@PostMapping(value = "/{iduser}/idvenda/{idvenda}")
	public ResponseEntity<Usuario> cadastrarvenda(@PathVariable Long iduser, @PathVariable Long idvenda) {

		// Usuario usuarioSalvo = usuarioRepository.save(usuario);

		return new ResponseEntity("id user: " + iduser + " idvenda: " + idvenda, HttpStatus.OK);
	}
	
	@PutMapping(value = "/{iduser}/idvenda/{idvenda}")
	public ResponseEntity<Usuario> updatevenda(@PathVariable Long iduser,
			                                   @PathVariable Long idvenda) {

		// Usuario usuarioSalvo = usuarioRepository.save(usuario);

		return new ResponseEntity("Venda Atualizada com sucesso!!!", HttpStatus.OK);
	}
	
	@PutMapping(value = "/",produces = "application/json")	
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/{id}", produces = "application/text")
	public String delete(@PathVariable("id") Long id) {
		
		usuarioRepository.deleteById(id);
		
		return "Ok";

	}
	@DeleteMapping(value = "/{id}/venda", produces = "application/text")
	public String deletevenda(@PathVariable("id") Long id) {
		
		usuarioRepository.deleteById(id);
		
		return "delete venda";

	}


}
