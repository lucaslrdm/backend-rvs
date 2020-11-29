package br.com.rvsadvogados.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.rvsadvogados.model.Processos;

public interface ProcessosDAO extends CrudRepository<Processos, Integer>{
	
	public List<Processos> findByClienteIdcli(int id);
	public List<Processos> findByAdvogadoIdadvogado(int id);
	public List<Processos> findByIdprocesso(int id);
	public List<Processos> findByDtinicio(Date dataabertura);
	public List<Processos> findByClienteNomecli(String nomecliente);
	public List<Processos> findByClienteIdcliAndDtinicio(int id, Date dataabertura);
	public List<Processos> findByClienteIdcliAndClienteNomecli(int id, String nomecliente);
	public List<Processos> findByClienteNomecliAndDtinicio(String nomecliente, Date dataabertura);
	public List<Processos> findByClienteIdcliAndIdprocessoAndDtinicio(int idcliente, int idprocesso,Date dataabertura);
	public List<Processos> findAllByOrderByDtinicioAsc();
	

	


}
