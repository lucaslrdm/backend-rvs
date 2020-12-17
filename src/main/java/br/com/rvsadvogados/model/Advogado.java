package br.com.rvsadvogados.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"advogado","cliente","processos"})
@Entity
@Table(name="TB_ADVOGADO")
public class Advogado {
	
	@JsonProperty("id")
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
    @JsonProperty("nome")
	@Column(name="nomeadvogado",length=50)
	private String nomeadvogado;
	
    @JsonProperty("login")
	@Column(name="login",length=10)
	private String login;
	
    @JsonProperty("email")
	@Column(name="email",length=80)
	private String email;
	
    @JsonProperty("senha")
	@Column(name="senha",length=20)
	private String senha;
	
	
	@Column(name="foto",length=100)
	private String foto;
	
	@JsonIgnoreProperties({"advogado","cliente"})
	@OneToMany(mappedBy="advogado", cascade=CascadeType.ALL)
	private List<Processos> processos;
	
	@JsonIgnoreProperties({"advogado","processos"})
	@OneToMany(mappedBy="advogado", cascade=CascadeType.ALL)
	private List<Cliente> clientes;
	
	@JsonIgnoreProperties({"advogado","cliente","processos"})
	@OneToMany(mappedBy="advogado", cascade=CascadeType.ALL)
	private List<Logs> logs;

	public Advogado() {
		super();
	}



	public Advogado(int idadvogado, String nomeadvogado, String loginadvogado, String emailadvogado,
			String senhaadvogado, String foto, List<Processos> processos, List<Cliente> clientes) {
		super();
		this.id = idadvogado;
		this.nomeadvogado = nomeadvogado;
		this.login = loginadvogado;
		this.email = emailadvogado;
		this.senha = senhaadvogado;
		this.foto = foto;
		this.processos = processos;
		this.clientes = clientes;
	}



	public int getIdAdvogado() {
		return id;
	}

	public void setIdAdvogado(int idAdvogado) {
		this.id = idAdvogado;
	}

	public String getNomeAdvogado() {
		return nomeadvogado;
	}

	public void setNomeAdvogado(String nomeAdvogado) {
		this.nomeadvogado = nomeAdvogado;
	}

	public String getLoginAdvogado() {
		return login;
	}

	public void setLoginAdvogado(String loginAdvogado) {
		this.login = loginAdvogado;
	}

	public String getEmailAdvogado() {
		return email;
	}

	public void setEmailAdvogado(String emailAdvogado) {
		this.email = emailAdvogado;
	}

	public String getSenhaAdvogado() {
		return senha;
	}

	public void setSenhaAdvogado(String senhaAdvogado) {
		this.senha = senhaAdvogado;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	
	public List<Processos> getProcessos() {
		return processos;
	}

	public void setProcessos(List<Processos> processos) {
		this.processos = processos;
	}



	public List<Cliente> getClientes() {
		return clientes;
	}



	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	

}
