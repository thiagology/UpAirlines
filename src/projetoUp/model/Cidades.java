package projetoUp.model;

public enum Cidades {
	ARACAJU(0, "Aracaju"), BELEM(1, "Belem"), BELO_HORIZONTE(2, "Belo Horizonte"), BOA_VISTA(3, "Boa Vista"), 
	BRASILIA(4, "Brasilia"), CAMPO_GRANDE(5, "Campo Grande"), CUIABA(6, "Cauiabá"), 
	CURITIBA(7, "Curitiba"), FLORIANOPOLIS(8, "Florianópolis"), FORTALEZA(9, "Fortaleza"), GOIANIA(10, "Goiania"),
	JAOAO_PESSOA(11, "João Pessoa"), MACAPA(12, "Macapa"), MACEIO(13, "Maceió"), MANAUS(14, "Manaus"),
	NATAL(15, "Natal"), PALMAS(16, "Palmas"), PORTO_ALEGRE(17, "Porto Alegre"),
	PORTO_VELHO(18, "Porto Velho"), RECIFE(19, "Recife"), RIO_BRANCO(20, "Rio Branco"), RIO_DE_JANEIRO(21, "Rio de Janeiro"),
	SAO_LUIS(22, "São Luis"), SAO_PAULO(23, "São Paulo"), SALVADOR(24, "Salvador"), 
	TERERESINA(25, "Teresina"), VITORIA(26, "Vitoria");
	
	private int ordem;
	private String nome;
	
	Cidades(int ordem, String nome)
	{
		this.ordem = ordem;
		this.nome = nome;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public int getOrdem()
	{
		return this.ordem;
	}
	
}
