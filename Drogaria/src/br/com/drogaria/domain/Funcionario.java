package br.com.drogaria.domain;

import java.util.List;

import br.com.drogaria.bean.Estado;

public class Funcionario {
	private Long codigo;
	private String nome;
	private Long cpf;
	private String endereco;
	private String cidade;
	private String estado;
	private String login;
	private String senha;
	private String matricula;
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCpf() {
		return cpf;
	}
	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	@Override
	public String toString() {
	
		return "Funcionario [codigo=" + codigo + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco
				+ ", cidade=" + cidade + ", estado=" + estado + ", login=" + login + ", senha=" + senha + ", matricula="
				+ matricula + "]";
	}
	
	public List<Estado> listar() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
