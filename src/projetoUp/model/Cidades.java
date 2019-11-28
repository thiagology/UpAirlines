package projetoUp.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Cidades {
    ARACAJU(0, ""
            + "Aracaju"), BELEM(1, "Bel�m"), BELO_HORIZONTE(2, "Belo Horizonte"), BOA_VISTA(3, "Boa Vista"),
    BRASILIA(4, "Bras�lia"), CAMPO_GRANDE(5, "Campo Grande"), CUIABA(6, "Cauiab�"),
    CURITIBA(7, "Curitiba"), FLORIANOPOLIS(8, "Florian�polis"), FORTALEZA(9, "Fortaleza"), GOIANIA(10, "Goi�nia"),
    JOAO_PESSOA(11, "Jo�o Pessoa"), MACAPA(12, "Macap�"), MACEIO(13, "Macei�"), MANAUS(14, "Manaus"),
    NATAL(15, "Natal"), PALMAS(16, "Palmas"), PORTO_ALEGRE(17, "Porto Alegre"),
    PORTO_VELHO(18, "Porto Velho"), RECIFE(19, "Recife"), RIO_BRANCO(20, "Rio Branco"), RIO_DE_JANEIRO(21, "Rio de Janeiro"),
    SAO_LUIS(22, "S�o Lu�s"), SAO_PAULO(23, "S�o Paulo"), SALVADOR(24, "Salvador"),
    TERERESINA(25, "Teresina"), VITORIA(26, "Vit�ria");

    private int ordem;
    private String nome;
    

    Cidades(int ordem, String nome) {
        this.ordem = ordem;
        this.nome = nome;
    }


    public String getNome() {
        return this.nome;
    }

    public int getOrdem() {
        return this.ordem;
    }
    
    public static List<Cidades> listaCidades(){
    	List<Cidades> cidades = new ArrayList<Cidades>();
    	cidades.addAll(Arrays.asList(Cidades.values()));
    	return cidades;
    }

}
