package projetoUp.model;

public enum Pilotos {
	SANTOS("Santos Dumont"),
	AMElLIA("Amelia Earhart"),
	CHARLES("Charles Muntz");
	
	private String nome;

	private Pilotos(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	
}
