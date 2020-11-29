package br.com.rvsadvogados.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.rvsadvogados.model.Advogado;
import br.com.rvsadvogados.model.Cliente;
import br.com.rvsadvogados.model.Logs;
import br.com.rvsadvogados.model.Processos;

public interface LogsDAO extends CrudRepository<Logs, Integer>{
	
	public List<Logs> findByProcessosIdprocesso(int id);


}
