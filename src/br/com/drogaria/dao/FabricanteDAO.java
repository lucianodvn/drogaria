package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.factory.ConexaoFactory;

public class FabricanteDAO {
	public void salvar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO fabricante ");
		sql.append("(descricao) ");
		sql.append("VALUES (?)");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());

		comando.executeUpdate();

	}

	public void excluir(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());

		comando.executeUpdate();

	}

	public void editar(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE fabricante ");
		sql.append("SET descricao = ? ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, f.getDescricao());
		comando.setLong(2, f.getCodigo());

		comando.executeUpdate();

	}

	public Fabricante buscarPorCodigo(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE codigo = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, f.getCodigo());

		ResultSet resultado = comando.executeQuery();

		Fabricante retorno = null;

		if (resultado.next()) {
			retorno = new Fabricante();
			retorno.setCodigo(resultado.getLong("codigo"));
			retorno.setDescricao(resultado.getString("descricao"));
		}

		return retorno;

	}

	public ArrayList<Fabricante> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("ORDER BY descricao ASC");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

		while (resultado.next()) {
			Fabricante f = new Fabricante();
			f.setCodigo(resultado.getLong("codigo"));
			f.setDescricao(resultado.getString("descricao"));

			lista.add(f);
		}

		return lista;
	}

	public ArrayList<Fabricante> buscarPorDescricao(Fabricante f) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT codigo, descricao ");
		sql.append("FROM fabricante ");
		sql.append("WHERE descricao LIKE ? ");
		sql.append("ORDER BY descricao ASC ");

		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setString(1, "%" + f.getDescricao() + "%");

		ResultSet resultado = comando.executeQuery();

		ArrayList<Fabricante> lista = new ArrayList<Fabricante>();

		while (resultado.next()) {
			Fabricante item = new Fabricante();
			item.setCodigo(resultado.getLong("codigo"));
			item.setDescricao(resultado.getString("descricao"));

			lista.add(item);
		}

		return lista;

	}
	
	public static void main(String[] args) {

		/*
		 * Fabricante f1 = new Fabricante(); f1.setDescricao("DESCRICAO 2");
		 * 
		 * Fabricante f2 = new Fabricante(); f2.setDescricao("DESCRICAO 3");
		 * 
		 * FabricanteDAO fdao = new FabricanteDAO();
		 * 
		 * try { fdao.salvar(f1); fdao.salvar(f2);
		 * System.out.println("Dados salvos no banco com sucesso!"); } catch
		 * (SQLException e) { System.out.println("Dados n�o foram salvos!");
		 * e.printStackTrace();
		 * 
		 * }
		 * 
		 * 
		 * Fabricante f1 = new Fabricante(); f1.setCodigo(2L);
		 * 
		 * FabricanteDAO fdao = new FabricanteDAO();
		 * 
		 * try { fdao.excluir(f1); System.out.println("Dados exclu�dos com sucesso!"); }
		 * catch (Exception e) { System.out.println("Dados n�o foram exclu�dos!");
		 * e.printStackTrace(); }
		 * 
		 * Fabricante f1 = new Fabricante(); f1.setCodigo(1L);
		 * f1.setDescricao("DESCRICAO 5");
		 * 
		 * FabricanteDAO fdao = new FabricanteDAO();
		 * 
		 * try { fdao.editar(f1); System.out.println("Alterado com sucesso!"); } catch
		 * (SQLException e) { System.out.println("N�o foi poss�vel alterar!");
		 * e.printStackTrace(); }
		 * 
		 * 
		 * Fabricante f1 = new Fabricante(); f1.setCodigo(1L);
		 * 
		 * Fabricante f2 = new Fabricante(); f2.setCodigo(3L);
		 * 
		 * FabricanteDAO fdao = new FabricanteDAO(); try { Fabricante f3 =
		 * fdao.buscarPorCodigo(f1); Fabricante f4 = fdao.buscarPorCodigo(f2);
		 * 
		 * System.out.println("Resultado 1: " + f3); System.out.println("Resultado 2: "
		 * + f4);
		 * 
		 * } catch (SQLException e) {
		 * System.out.println("Erro ao consultar fabricante!"); e.printStackTrace(); }
		 * 
		 * 
		 * FabricanteDAO fdao = new FabricanteDAO(); try { ArrayList<Fabricante> lista =
		 * fdao.listar();
		 * 
		 * for(Fabricante f: lista) { System.out.println("Resultado: " + f); }
		 * 
		 * } catch (SQLException e) { System.out.println("Erro ao listar fabricantes!");
		 * e.printStackTrace(); }
		 * 
		*/
		Fabricante f1 = new Fabricante();
		f1.setDescricao("3");

		FabricanteDAO fdao = new FabricanteDAO();
		try {
			ArrayList<Fabricante> lista = fdao.buscarPorDescricao(f1);

			for (Fabricante f : lista) {
				System.out.println("Resultado: " + f);
			}

		} catch (SQLException e) {
			System.out.println("Erro ao listar fabricante!");
			e.printStackTrace();
		}
	} 
}
