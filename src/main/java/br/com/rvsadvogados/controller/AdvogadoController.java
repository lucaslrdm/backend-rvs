package br.com.rvsadvogados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import br.com.rvsadvogados.dao.AdvogadoDAO;
import br.com.rvsadvogados.model.Advogado;
import br.com.rvsadvogados.model.Cliente;

@RestController
@CrossOrigin("*")
public class AdvogadoController {
	
	@Autowired
	private AdvogadoDAO dao;
	
	@PostMapping("/loginemail")
	public ResponseEntity<Advogado> logar(@RequestBody Advogado objeto){
		
		Advogado advogado = dao.findByEmailAndSenha(objeto.getEmailAdvogado(), objeto.getSenhaAdvogado());
		
		if(advogado==null) return ResponseEntity.status(404).build();
		
		return ResponseEntity.ok(advogado);
	}
	
	@PostMapping("/loginusuario")
	public ResponseEntity<Advogado> logarUsuario(@RequestBody Advogado objeto){
		
		Advogado advogado = dao.findByLoginAndSenha(objeto.getLoginAdvogado(), objeto.getSenhaAdvogado());

		if(advogado==null) {
		
			return ResponseEntity.status(405).build();}
		
		return ResponseEntity.ok(advogado);
	}
	

	
	@GetMapping("/listaadvogados")
	public ResponseEntity<List<Advogado>> getAll(){
		
		List<Advogado>  lista = (List<Advogado>) dao.findAll();
		
		if(lista.size()==0) {
			return ResponseEntity.status(404).build();
		}
		return ResponseEntity.ok(lista);
	
		
	}
	
	@PostMapping("/novoadvogado")
	public ResponseEntity<Advogado> gravar(@RequestBody Advogado objeto){
		try {
			dao.save(objeto);
			return ResponseEntity.ok(objeto);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}

}
