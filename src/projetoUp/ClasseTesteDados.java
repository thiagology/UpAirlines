package projetoUp;

import java.time.LocalDate;

import projetoUp.model.Endereco;
import projetoUp.model.Gerente;
import projetoUp.negocio.ControladorAeroporto;
import projetoUp.negocio.Fachada;

public class ClasseTesteDados {
	
	
	

	public static void main(String[] args) {
		// testar funcionamento
		Fachada fachada = Fachada.getInstance();
		//Novo Gerente
		Endereco endereco = new Endereco("Recife", "Pernambuco", "Brasil", 54500000);
		
		
		fachada.adicionarFuncionario("Gerente", "1234", "4321", 81823400, endereco, LocalDate.of(1992, 5, 10), 123, LocalDate.of(2019, 3, 15), "Gerente");
		
		
	}

}
