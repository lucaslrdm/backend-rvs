package br.com.rvsadvogados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rvsadvogados.dao.ClienteDAO;
import br.com.rvsadvogados.model.Cliente;
import br.com.rvsadvogados.model.Processos;

@RestController
@CrossOrigin("*")
public class ClienteController {
	
	@Autowired
	private ClienteDAO dao;
	
	@PostMapping("/loginemailcliente")
	public ResponseEntity<Cliente> logar(@RequestBody Cliente objeto){
		
		Cliente cliente = dao.findByEmailcliAndSenha(objeto.getEmailcli(), objeto.getSenhaCliente());
		
		if(cliente==null) return ResponseEntity.status(404).build();
		
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping("/loginusuariocliente")
	public ResponseEntity<Cliente> logarUsuario(@RequestBody Cliente objeto){
		
		Cliente cliente = dao.findByLoginAndSenha(objeto.getLoginCliente(), objeto.getSenhaCliente());

		if(cliente==null) {
		
			return ResponseEntity.status(405).build();}
		
		return ResponseEntity.ok(cliente);
	}
	
	@GetMapping("/relatorioclientes")
	public ResponseEntity<List<Cliente>> getAll(){
		List<Cliente> lista = (List<Cliente>) dao.findAll();
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/novocliente")
	public ResponseEntity<Cliente> gravar(@RequestBody Cliente objeto){
		try {
			dao.save(objeto);
			return ResponseEntity.ok(objeto);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
	
	@PostMapping("/relatorioporidadvogadocl")
	public ResponseEntity<List<Cliente>> getProcessoIdadvogado(@RequestBody Cliente objeto){
		/*
		
		*/List<Cliente> lista = dao.findByAdvogadoId(objeto.getAdvogado().getIdAdvogado());
		/*if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		*/
		return ResponseEntity.ok(lista);
		
		
	}

}
