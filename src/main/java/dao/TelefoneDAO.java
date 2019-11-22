package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao_jdbc.SingleConnection;
import model.BeanUserFone;
import model.Telefone;

public class TelefoneDAO {
	
	private Connection conn;
	
	public TelefoneDAO() {
		conn = SingleConnection.getConnection();
	}

	public void salvarTelefone(Telefone telefone) throws SQLException {
		try {
			String sql = "INSERT INTO telefoneuser (numero, tipo, userpessoa) VALUES (?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, telefone.getNumero());
			pst.setString(2, telefone.getTipo());
			pst.setLong(3, telefone.getUser());
			pst.execute();
			conn.commit();
		}catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
	}
	
	
	public List<BeanUserFone> listaUserFone (Long idUser) throws SQLException{
		List<BeanUserFone> list = new ArrayList<BeanUserFone>();

		String sql = " SELECT nome, email, numero, tipo FROM telefoneuser ";
		sql += "INNER JOIN userJava ON telefoneuser.userpessoa = userJava.id ";
		sql += "WHERE userJava.id = " + idUser;
		try {
		PreparedStatement pst = conn.prepareStatement(sql);
		ResultSet rset = pst.executeQuery();
		
		while(rset.next()) {
			BeanUserFone uf = new BeanUserFone();
			
			uf.setEmail(rset.getString("email"));
			uf.setNome(rset.getString("nome"));
			uf.setTelefone(rset.getString("numero"));
			uf.setTipo(rset.getString("tipo"));
			
			list.add(uf);
		}

		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}
		
		return list;
	}
	
	
/*
 * Este metodo deleta os usuarios = id declarado em forma cascata
 * deletando primeiro os registros filhos (telefone) e depois o registro pai (usuario)
 */
	public void deletaFonePorUser(Long idUser) throws SQLException {
		String sqlFone = "DELETE FROM telefoneuser WHERE userpessoa = " + idUser;
		String sqlUser = "DELETE FROM userJava WHERE id = " + idUser; 
		try {
			PreparedStatement pst = conn.prepareStatement(sqlFone);
			pst.executeUpdate();
			conn.commit();
			pst.getConnection().prepareStatement(sqlUser);
			conn.commit();
		} catch (SQLException e) {
			conn.rollback();
			e.printStackTrace();
		}
	}
	
	
}
