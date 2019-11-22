package java_jdbc.java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import dao.UserDAO;
import dao.TelefoneDAO;
import model.BeanUserFone;
import model.Telefone;
import model.User;

public class TesteConexao {
	
	@Test
	public void initBanco() {
		UserDAO usuDAO = new UserDAO();
		User user = new User("Teste3", "Emai3l@teste.com");
		try {
			usuDAO.salvar(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initListar() throws SQLException {
		UserDAO usuDAO = new UserDAO();
		List<User> list = usuDAO.listar();
		
		for (User user : list) {
			System.out.println(user);
			System.out.println("-------------------------");
		}
	}
	
	@Test
	public void initBuscar() {
		
		UserDAO dao = new UserDAO();
		
		try {
			User user = dao.buscar(2L);
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initAtualizar() {
		try {
		UserDAO dao = new UserDAO();
		User banco = dao.buscar(2L);
		banco.setNome("Mudei Hue");
		dao.atualizar(banco);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDel() {
		try {
			UserDAO dao = new UserDAO();
			dao.delete(2L);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initInsertTel() throws SQLException {
		Telefone telefone = new Telefone();
		telefone.setNumero("(44) 3355-8877");
		telefone.setTipo("Residencial");
		telefone.setUser(6L);
		
		TelefoneDAO dao = new TelefoneDAO();
		dao.salvarTelefone(telefone);
	}
	
	@Test
	public void initCarregaFone() throws SQLException {
		TelefoneDAO dao = new TelefoneDAO();
		List<BeanUserFone> listaUF = dao.listaUserFone(8L);
		
		for(BeanUserFone buf : listaUF) {
			System.out.println(buf);
			System.out.println("------------------------");
		}
		
	}
	
	@Test
	public void initDeleteFoneUser() throws SQLException {
		TelefoneDAO dao = new TelefoneDAO();
		dao.deletaFonePorUser(6L);
	}

}
