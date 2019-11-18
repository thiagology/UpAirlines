package projetoUp.model;

public enum Cidades {
	ARACAJU(1, "Aracaju"), BELEM(2, "Belem"), BELO_HORIZONTE(3, "Belo Horizonte"), BOA_VISTA(4, "Boa Vista"), 
	BRASILIA(5, "Brasilia"), CAMPO_GRANDE(6, "Campo Grande"), CUIABA(7, "Cauiab�"), 
	CURITIBA(8, "Curitiba"), FLORIANOPOLIS(9, "Florian�polis"), FORTALEZA(10, "Fortaleza"), GOIANIA(11, "Goiania"),
	JAOAO_PESSOA(12, "Jo�o Pessoa"), MACAPA(13, "Macapa"), MACEIO(14, "Macei�"), MANAUS(15, "Manaus"),
	NATAL(16, "Natal"), PALMAS(17, "Palmas"), PORTO_ALEGRE(18, "Porto Alegre"),
	PORTO_VELHO(19, "Porto Velho"), RECIFE(20, "Recife"), RIO_BRANCO(21, "Rio Branco"), RIO_DE_JANEIRO(22, "Rio de Janeiro"),
	SAO_LUIS(23, "S�o Luis"), SAO_PAULO(24, "S�o Paulo"), SALVADOR(25, "Salvador"), 
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
