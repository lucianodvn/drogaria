package br.com.drogaria.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.util.jsfUtil;

/*Chamar fabricante.xhtml select no banco*/

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricante;
	private ArrayList<Fabricante> itens;
	private ArrayList<Fabricante> itensFiltrados;
	

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public ArrayList<Fabricante> getItens() {
		return itens;
	}

	public void setItens(ArrayList<Fabricante> itens) {
		this.itens = itens;
	}


	public ArrayList<Fabricante> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<Fabricante> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct

	public void prepararPesquisa() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			itens = dao.listar();
		} catch (SQLException e) {

			e.printStackTrace();
			jsfUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void prepararNovo() {
		fabricante = new Fabricante();

	}

	public void novoFabricante() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);
			itens = dao.listar();

			jsfUtil.adicionarMensagemSucesso("Fabricante salvo sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			jsfUtil.adicionarMensagemErro(e.getMessage());
		}
	}

	public void excluir() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.excluir(fabricante);
			itens = dao.listar();
			jsfUtil.adicionarMensagemSucesso("Fabricante removido com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
			jsfUtil.adicionarMensagemErro(e.getMessage());
		}

	}

	public void editar() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.editar(fabricante);
			itens = dao.listar();
			jsfUtil.adicionarMensagemSucesso("Fabricante alterado com sucesso!");

		} catch (SQLException e) {
			e.printStackTrace();
			jsfUtil.adicionarMensagemErro(e.getMessage());
		}

	}

}
