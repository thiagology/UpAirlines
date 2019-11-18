package projetoUp.model;

public enum Cidades {
	RECIFE(1, "Recife"), JAOAO_PESSOA(2, "João Pessoa"), MACEIO(3, "Maceió"),
	NATAL(4, "Natal"), TERERESINA(5, "Teresina"), SAO_LUIS(6, "São Luis"),
	ARACAJU(7, "Aracaju"), FORTALEZA(8, "Fortaleza"), SALVADOR(9, "Salvador"),
	BELEM(10, "Belem"), PORTO_VELHO(11, "Porto Velho"), MANAUS(12, "Manaus"),
	MACAPA(13, "Macapa"), BOA_VISTA(14, "Boa Vista"), PALMAS(15, "Palmas"),
	GOIANIA(16, "Goiania"), CUIABA(17, "Cauiabá"), CAMPO_GRANDE(18, "Campo Grande"),
	BRASILIA(19, "Brasilia"), VITORIA(20, "Vitoria"), BELO_HORIZONTE(21, "Belo Horizonte"),
	RIO_DE_JANEIRO(22, "Rio de Janeiro"), SAO_PAULO(23, "São Paulo"), CURITIBA(24, "Curitiba"),
	FLORIANOPOLIS(25, "Florianópolis"), RIO_BRANCO(26, "Rio Branco"), RIO_GRANDE_DO_SUL(27, "Rio Grande do Sul");
	
	private int ordem;
	private String nome;
	
	Cidades(int ordem, String nome)
	{
		this.ordem = ordem;
		this.nome = nome;
	}
	
	
}
