package br.com.rvsadvogados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.rvsadvogados.dao.ProcessosDAO;
import br.com.rvsadvogados.model.Processos;

@RestController
@CrossOrigin("*")
public class ProcessosController {
	
	@Autowired
	private ProcessosDAO dao;
	
	
	//public List<Processos> findByClienteIdcliente(int id);
	@PostMapping("/relatorioporcliente")
	public ResponseEntity<List<Processos>> getProcessoIdcliente(@RequestBody Processos objeto){
		List<Processos> lista = dao.findByClienteIdcli(objeto.getCliente().getIdcli());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	
	//public List<Processos> findByDataabertura(Date dataabertura);
	@PostMapping("/relatoriopordata")
	public ResponseEntity<List<Processos>> getProcessoData(@RequestBody Processos objeto){
		List<Processos> lista = dao.findByDtinicio(objeto.getDataabertura());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	/*
	@GetMapping("/bucaprocessoid/{cod}")
	public ResponseEntity<Processos> getMusica(@PathVariable int cod){

		Processos resposta =  dao.findById(cod).orElse(null);

		if(resposta == null)
			return ResponseEntity.status(404).build();

		return ResponseEntity.ok(resposta);
	}
	
	*/
	
	//public List<Processos> findByIdprocesso(int id);
	@PostMapping("/relatorioporidprocesso")
	public ResponseEntity<List<Processos>> getProcessoIdprocesso(@RequestBody Processos objeto){
		List<Processos> lista = dao.findByIdprocesso(objeto.getIdprocesso());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	
	
	@PostMapping("/novoprocesso")
	public ResponseEntity<Processos> gravar(@RequestBody Processos objeto){
		try {
			dao.save(objeto);
			return ResponseEntity.ok(objeto);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(403).build();
		}
	}
	
	//public List<Processos> findByAdvogadoIdadvogado(int id);
	@PostMapping("/relatorioporidadvogado")
	public ResponseEntity<List<Processos>> getProcessoIdadvogado(@RequestBody Processos objeto){
		List<Processos> lista = dao.findByAdvogadoIdadvogado(objeto.getAdvogado().getIdAdvogado());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	
	
	@GetMapping("/listaprocessos")
	public ResponseEntity<List<Processos>> getAll(){
		List<Processos> lista = (List<Processos>) dao.findAll();
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/listaprocessosordenado")
	public ResponseEntity<List<Processos>> getAllOrdenado(){
		List<Processos> lista = (List<Processos>) dao.findAllByOrderByDtinicioAsc();
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
	}

	//public List<Processos> findByClienteNomecliente(String nomecliente);
	@PostMapping("/relatoriopornomecliente")
	public ResponseEntity<List<Processos>> getProcessoNomecliente(@RequestBody Processos objeto){
		List<Processos> lista = dao.findByClienteNomecli(objeto.getCliente().getNomecli());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	

	//public List<Processos> findByClienteIdclienteAndDataabertura(int id, Date dataabertura);
	@PostMapping("/relatorioporidclientedataabertura")
	public ResponseEntity<List<Processos>> getProcessoIdclienteDataabertura(@RequestBody Processos objeto){
		List<Processos> lista = dao.findByClienteIdcliAndDtinicio(objeto.getCliente().getIdcli(), objeto.getDataAbertura());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	
	
	//public List<Processos> findByClienteIdclienteAndClienteNomecliente(int id, String nomecliente);
	@PostMapping("/relatorioporidclientenomecliente")
	public ResponseEntity<List<Processos>> getProcessoIdclienteNomecliente(@RequestBody Processos objeto){
		List<Processos> lista = dao.findByClienteIdcliAndClienteNomecli(objeto.getCliente().getIdcli(), objeto.getCliente().getNomecli());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	
	
	//public List<Processos> findByClienteNomeclienteAndDataabertura(String nomecliente, Date dataabertura);
	@PostMapping("/relatoriopornomeclientedataabertura")
	public ResponseEntity<List<Processos>> getProcessoNomeclienteDataabertura(@RequestBody Processos objeto){
		List<Processos> lista = dao.findByClienteNomecliAndDtinicio(objeto.getCliente().getNomecli(), objeto.getDataAbertura());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}
	
	//public List<Processos> findByClienteIdclienteAndIdprocessoAndDataabertura(int id, int nomecli,Date dataabertura);
	@PostMapping("/relatorioporidclienteidprocessodataabertura")
	public ResponseEntity<List<Processos>> getProcessoIdclienteIdprocessoDataabertura(@RequestBody Processos objeto){
		List<Processos> lista = dao.findByClienteIdcliAndIdprocessoAndDtinicio(objeto.getCliente().getIdcli(), objeto.getIdprocesso(), objeto.getDataAbertura());
		if(lista.size()==0) return ResponseEntity.status(404).build();
		return ResponseEntity.ok(lista);
		
	}



}
