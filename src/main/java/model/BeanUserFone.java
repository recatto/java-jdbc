package model;

public class BeanUserFone {
	
	private String nome;
	private String email;
	private String telefone;
	private String tipo;
	
	public BeanUserFone() {
		super();
	}
	

	public BeanUserFone(String nome, String email, String telefone, String tipo) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "BeanUserFone [nome=" + nome + ", email=" + email + ", telefone=" + telefone + ", tipo=" + tipo + "]";
	}

}
