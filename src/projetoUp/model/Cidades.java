package projetoUp.model;

public enum Cidades {
	ARACAJU(1, "Aracaju"), BELEM(2, "Belem"), BELO_HORIZONTE(3, "Belo Horizonte"), BOA_VISTA(4, "Boa Vista"), 
	BRASILIA(5, "Brasilia"), CAMPO_GRANDE(6, "Campo Grande"), CUIABA(7, "Cauiabá"), 
	CURITIBA(8, "Curitiba"), FLORIANOPOLIS(9, "Florianópolis"), FORTALEZA(10, "Fortaleza"), GOIANIA(11, "Goiania"),
	JAOAO_PESSOA(12, "João Pessoa"), MACAPA(13, "Macapa"), MACEIO(14, "Maceió"), MANAUS(15, "Manaus"),
	NATAL(16, "Natal"), PALMAS(17, "Palmas"), PORTO_ALEGRE(18, "Porto Alegre"),
	PORTO_VELHO(19, "Porto Velho"), RECIFE(20, "Recife"), RIO_BRANCO(21, "Rio Branco"), RIO_DE_JANEIRO(22, "Rio de Janeiro"),
	SAO_LUIS(23, "São Luis"), SAO_PAULO(24, "São Paulo"), SALVADOR(25, "Salvador"), 
	TERERESINA(26, "Teresina"), VITORIA(27, "Vitoria");
	
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
