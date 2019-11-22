package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao_jdbc.SingleConnection;
import model.User;

public class UserDAO {

	private Connection conn;

	public UserDAO() {
		conn = SingleConnection.getConnection();
	}

	public void salvar(User user) throws SQLException {
		try {
			String sql = "INSERT INTO userJava (nome, email) VALUES (?,?)";
			PreparedStatement insert = conn.prepareStatement(sql);
			insert.setString(1, user.getNome());
			insert.setString(2, user.getEmail());
			insert.execute();
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
	}
	

	public List<User> listar() throws SQLException {
		List<User> list = new ArrayList<User>();

		String sql = "SELECT * FROM userJava";

		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet resultado = pst.executeQuery();

		while (resultado.next()) {
			User user = new User(resultado.getLong("id"), resultado.getString("nome"), resultado.getString("email"));
			list.add(user);
		}

		return list;

	}

	public User buscar(Long id) throws SQLException {
		User buscado = new User();

		String sql = "SELECT * FROM userJava WHERE id = " + id;

		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet resultado = pst.executeQuery();

		while (resultado.next()) {
			buscado.setId(resultado.getLong("id"));
			buscado.setNome(resultado.getString("nome"));
			buscado.setEmail(resultado.getString("email"));
		}

		return buscado;

	}

	public void atualizar(User user) throws SQLException {
		try {
			String sql = "UPDATE userJava SET nome = ? WHERE id = " + user.getId();
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, user.getNome());
			pst.execute();
			conn.commit();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}

	}
	
	public void delete (Long id) throws SQLException {
		try {
			String sql = "DELETE FROM userJava WHERE id = " + id;
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.execute();
			conn.commit();
		}catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
		
	}
	
}
