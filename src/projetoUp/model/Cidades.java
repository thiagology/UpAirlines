package projetoUp.model;

public enum Cidades {
	RECIFE(1), JAOAO_PESSOA(2), MACEIO(3), NATAL(4), TERERESINA(5), SAO_LUIS(6),
	ARACAJU(7), FORTALEZA(8), SALVADOR(9), BELEM(10), PORTO_VELHO(11), MANAUS(12),
	MACAPA(13), BOA_VISTA(14), PALMAS(15), GOIANIA(16), CUIABA(17), CAMPO_GRANDE(18),
	BRASILIA(19), VITORIA(20), BELO_HORIZONTE(21), RIO_DE_JANEIRO(22), SAO_PAULO(23), 
	CURITIBA(24), FLORIANOPOLIS(25), RIO_BRANCO(26), RIO_GRANDE_DO_SUL(27);
	
	private int ordem;
	
	Cidades(int ordem)
	{
		this.ordem = ordem;
	}
	
	
}
