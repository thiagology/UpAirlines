package projetoUp;


import projetoUp.model.Endereco;
import projetoUp.negocio.Fachada;

public class ClasseTesteDados {
	

	public static void main(String[] args) {
		// testar funcionamento
		Fachada fachada = Fachada.getInstance();
		//Novo Gerente
		Endereco endereco = new Endereco("Recife", "Pernambuco", "Brasil", 54500000);
		
	  System.out.println("Hello World!");
		
		
		
	}

}
