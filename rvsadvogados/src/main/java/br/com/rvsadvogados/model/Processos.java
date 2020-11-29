package br.com.rvsadvogados.model;



import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"processos","cliente","advogado"})
@Entity
@Table(name="TB_PROCESSOS")
public class Processos {
	
	@JsonProperty("idprocesso")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idprocesso")
	private int idprocesso;

	
	public List<Logs> getLogs() {
		return logs;
	}




	public void setLogs(List<Logs> logs) {
		this.logs = logs;
	}


	@JsonProperty("dtinicio")
	@Column(name="dtinicio")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private Date dtinicio;
	
	
	@OneToMany(mappedBy="processos", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("processos")
	private List<Logs> logs;

	
	@JsonProperty("tipoacao")
	@Column
	(name="tipoacao",length=100)
	private String tipoacao;
	
	//nome da parte contraria
	@JsonProperty("nomecon")
	@Column
	(name="nomecon",length=100)
	private String nomecon;
	
	
	//nome da parte numero principal
	@JsonProperty("nprincipal")
	@Column
	(name="nprincipal",length=100)
	private String nprincipal;
	
	@JsonProperty("orgao")
	@Column
	(name="orgao",length=100)
	private String orgao;
	
	@JsonProperty("natureza")
	@Column
	(name="natureza",length=100)
	private String natureza;
	
	/*
	@Column
	(name="log",length=100)
	private List<Log> log;*/
	
	@JsonIgnoreProperties({ "cliente"})
	@ManyToOne
	private Advogado advogado;
	
	@JsonIgnoreProperties({"processos","cliente"})
	@ManyToOne
	private Cliente cliente;
	

	
	

	public Processos() {
		super();
	}




	public Processos(int idprocesso, Date dtinicio, String tipoacao, String nomecon,
			String nprincipal, String orgao, String natureza, Cliente cliente, Advogado advogado) {
		super();
		this.idprocesso = idprocesso;
		this.dtinicio = dtinicio;
		this.tipoacao = tipoacao;
		this.nomecon = nomecon;
		this.nprincipal = nprincipal;
		this.orgao = orgao;
		this.natureza = natureza;
		this.cliente = cliente;
		this.advogado = advogado;
	}










	public String getTipoacao() {
		return tipoacao;
	}




	public void setTipoacao(String tipoacao) {
		this.tipoacao = tipoacao;
	}




	public String getNomecon() {
		return nomecon;
	}




	public void setNomecon(String nomecon) {
		this.nomecon = nomecon;
	}




	public String getNprincipal() {
		return nprincipal;
	}




	public void setNprincipal(String nprincipal) {
		this.nprincipal = nprincipal;
	}




	public String getOrgao() {
		return orgao;
	}




	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}




	public String getNatureza() {
		return natureza;
	}




	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}




	public Date getDataabertura() {
		return dtinicio;
	}




	public void setDataabertura(Date dataabertura) {
		this.dtinicio = dataabertura;
	}



	public int getIdprocesso() {
		return idprocesso;
	}



	public void setIdprocesso(int idprocesso) {
		this.idprocesso = idprocesso;
	}



	public Date getDataAbertura() {
		return dtinicio;
	}



	public void setDataAbertura(Date dataAbertura) {
		this.dtinicio = dataAbertura;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}




	public Advogado getAdvogado() {
		return advogado;
	}



	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	

}
