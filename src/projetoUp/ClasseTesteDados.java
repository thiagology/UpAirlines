package projetoUp;

import java.time.LocalDate;

import projetoUp.model.Endereco;
import projetoUp.model.Gerente;
import projetoUp.negocio.Fachada;

public class ClasseTesteDados {

	public static void main(String[] args) {
		// testar funcionamento
		Fachada fachada = Fachada.getInstance();
		
		//Novo Gerente
		Endereco endereco = new Endereco("Recife", "Pernambuco", "Brasil", 54500000);
		Gerente g = new Gerente("gerente@gmail.com", "0000", "Gerente",
								"09855022231", "8777444", 86525252, endereco,								
								LocalDate.of(1992, 5, 10), 2233, LocalDate.of(2019, 3, 15), "Gerente");	
		
		//fachada.adicionarFuncionario(g);
		
		
	}

}
