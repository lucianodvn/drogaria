package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.drogaria.dao.FuncionarioDao;
import br.com.drogaria.domain.Funcionario;

import br.com.drogaria.util.jsfUtil;

@ManagedBean(name = "MBFuncionario")
@ViewScoped

public class FuncionarioBean {
	private Funcionario funcionario;
	private ArrayList<Funcionario> itens;
	private ArrayList<Funcionario> itensFiltrados;
	private ArrayList<Funcionario> comboFuncionario;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public ArrayList<Funcionario> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Funcionario> itens) {
		this.itens = itens;
	}

	public ArrayList<Funcionario> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Funcionario> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public ArrayList<Funcionario> getComboFuncionario() {
		return comboFuncionario;
	}

	public void setComboFuncionario(ArrayList<Funcionario> comboFuncionario) {
		this.comboFuncionario = comboFuncionario;
	}

	@PostConstruct

	public void prepararPesquisa() {
		try {
			FuncionarioDao dao = new FuncionarioDao();
			itens = dao.listar();
		} catch (SQLException e) {

			e.printStackTrace();
			jsfUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void carregarListagem() throws SQLException {
		try {
			FuncionarioDao dao = new FuncionarioDao();
			itens = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			jsfUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void prepararNovo() {
		funcionario = new Funcionario();

	}

	public void novoFuncionario() {
		try {
			FuncionarioDao dao = new FuncionarioDao();
			dao.salvar(funcionario);
			itens = dao.listar();

			jsfUtil.adicionarMensagemSucesso("Funcionário salvo sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			jsfUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			FuncionarioDao dao = new FuncionarioDao();
			dao.excluir(funcionario);
			itens = dao.listar();
			jsfUtil.adicionarMensagemSucesso("Funcionário removido com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
			jsfUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void prepararEditar() {
		try {
			FuncionarioDao dao = new FuncionarioDao();
			itens = dao.listar();
		} catch (SQLException e) {
			e.printStackTrace();
			jsfUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void editar() {
		try {
			FuncionarioDao dao = new FuncionarioDao();
			dao.editar(funcionario);
			itens = dao.listar();
			jsfUtil.adicionarMensagemSucesso("Funcionário alterado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
			jsfUtil.adicionarMensagemErro(e.getMessage());
		}

	}

}
