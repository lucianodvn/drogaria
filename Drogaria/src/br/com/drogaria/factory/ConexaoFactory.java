package br.com.drogaria.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
	private static final String USUARIO = "root";
	private static final String SENHA = "moizo";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/drogaria";

	public static Connection conectar() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}

	public static void main(String[] args) {
		try {
			@SuppressWarnings("unused")
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conexão realizada com sucesso.");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Não foi possível conectar com o banco de dados.");
		}
	}
}
