package br.com.drogaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.drogaria.domain.Funcionario;

import br.com.drogaria.factory.ConexaoFactory;

public class FuncionarioDao {
	public void salvar(Funcionario func) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO funcionario ");
		sql.append("(NomeFunc, CPFFunc, EnderecoFunc, CidadeFunc, EstadoFunc, LoginFunc, SenhaFunc, Matricula) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?) ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		comando.setString(1, func.getNome());
		comando.setLong(2, func.getCpf());
		comando.setString(3, func.getEndereco());
		comando.setString(4, func.getCidade());
		comando.setString(5, func.getEstado());
		comando.setString(6, func.getLogin());
		comando.setString(7, func.getSenha());
		comando.setString(8, func.getMatricula());

		comando.executeUpdate();
	}
	
	
	public ArrayList<Funcionario> listar() throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT func.idfuncionario, func.NomeFunc, func.CPFFunc, func.EnderecoFunc, func.CidadeFunc, "
				+ "func.EstadoFunc, func.LoginFunc, func.SenhaFunc, func.Matricula ");
		sql.append("FROM funcionario func ");
		//sql.append("INNER JOIN fabricante f ON f.codigo = p.fabricante_codigo ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		ResultSet resultado = comando.executeQuery();

		ArrayList<Funcionario> itens = new ArrayList<Funcionario>();

		while (resultado.next()) {
			Funcionario func = new Funcionario();
			func.setCodigo(resultado.getLong("func.idfuncionario"));
			func.setNome(resultado.getString("func.NomeFunc"));
			func.setCpf(resultado.getLong("func.CPFFunc"));
			func.setEndereco(resultado.getString("func.EnderecoFunc"));
			func.setCidade(resultado.getString("func.CidadeFunc"));
			func.setEstado(resultado.getString("func.EstadoFunc"));
			func.setLogin(resultado.getString("func.LoginFunc"));
			func.setSenha(resultado.getString("func.SenhaFunc"));
			func.setMatricula(resultado.getString("func.Matricula"));

			itens.add(func);
			
		}
		
		return itens;
	}

	
	public void excluir(Funcionario func) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM funcionario ");
		sql.append("WHERE idfuncionario = ? ");

		Connection conexao = ConexaoFactory.conectar();

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		comando.setLong(1, func.getCodigo());

		comando.executeUpdate();

	}
	
	public void editar(Funcionario func) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE funcionario ");
		sql.append("SET NomeFunc = ?, CPFFunc = ?, EnderecoFunc = ?, CidadeFunc = ?, EstadoFunc = ?, LoginFunc = ?, SenhaFunc = ?, Matricula = ? ");
		sql.append("WHERE idfuncionario = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		
		comando.setString(1, func.getNome());
		comando.setLong(2, func.getCpf());
		comando.setString(3, func.getEndereco());
		comando.setString(4, func.getCidade());
		comando.setString(5, func.getEstado());
		comando.setString(6, func.getLogin());
		comando.setString(7, func.getSenha());
		comando.setString(8, func.getMatricula());
		comando.setLong(9, func.getCodigo());
		
		comando.executeUpdate();
		
	}

}
