package br.com.drogaria.teste;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTeste {
	@Test
	@Ignore
	public void salvar() throws SQLException {
		Produto p = new Produto();
		p.setDescricao("DIPIRONA 20 COMPRIMIDOS");
		p.setPreco(5.45D);
		p.setQuantidade(15L);

		Fabricante f = new Fabricante();
		f.setCodigo(10L);

		p.setFabricante(f);

		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p);
	}
	
	@Test
	@Ignore
	public void listar() throws SQLException{
		ProdutoDAO dao = new ProdutoDAO();
		ArrayList<Produto>  lista = dao.listar();
		
		for(Produto p:lista) {
			System.out.println("Código " + p.getCodigo());
			System.out.println("Descrição " + p.getDescricao());
			System.out.println("Quantidade " + p.getQuantidade());
			System.out.println("Preço " + p.getPreco());
			System.out.println("Código do Fabricante " + p.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante " + p.getFabricante().getDescricao());
			System.out.println("");
			
		}
		
	}

	@Test
	@Ignore
	public void excluir() throws SQLException{
		Produto p = new Produto();
		p.setCodigo(2L);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(p);	
	}
	
	@Test
	
	public void editar() throws SQLException{
		Produto p = new Produto();
		
		p.setCodigo(4L);
		p.setDescricao("XAROPE NEUSALDINA");
		p.setPreco(15.99);
		p.setQuantidade(33L);
		
		Fabricante f = new Fabricante();		
		f.setCodigo(4L);
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		
		dao.editar(p);		
		
	}

}
