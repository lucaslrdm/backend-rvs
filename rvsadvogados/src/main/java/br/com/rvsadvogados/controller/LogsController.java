package br.com.rvsadvogados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rvsadvogados.dao.LogsDAO;
import br.com.rvsadvogados.model.Logs;
import br.com.rvsadvogados.model.Processos;


@RestController
@CrossOrigin("*")
public class LogsController {
	
	@Autowired
	private LogsDAO dao;
	
	@GetMapping("/logs")
	public ResponseEntity<List<Logs>> getAll(){
		List<Logs> lista = (List<Logs>) dao.findAll();
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
	}
	
	@PostMapping("/gravarlog")
	public ResponseEntity<Logs> gravar(@RequestBody Logs objeto){
		try {
			dao.save(objeto);
			return ResponseEntity.ok(objeto);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
	
	
	@PostMapping("/logporprocesso")
	public ResponseEntity<List<Logs>> getProcessoIdcliente(@RequestBody Logs objeto){
		List<Logs> lista = dao.findByProcessosIdprocesso(objeto.getProcessos().getIdprocesso());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	

}
