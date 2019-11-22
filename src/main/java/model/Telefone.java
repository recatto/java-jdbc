package model;

public class Telefone {

	private Long id;
	private String numero;
	private String tipo;
	private Long user;
	
	public Telefone() {
		
	}
	

	public Telefone(String numero, String tipo, Long user) {
		super();
		this.numero = numero;
		this.tipo = tipo;
		this.user = user;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Telefone [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", user=" + user + "]";
	}
	
	
}
