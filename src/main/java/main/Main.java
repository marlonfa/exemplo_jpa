package main;

import controller.JPAController;
import model.Funcionario;

public class Main {

	public static void main(String[] args) {
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome("Miguel");
		funcionario.setCpf("00000000000");
		
		JPAController controller = new JPAController();
		controller.save(funcionario);
		
		Funcionario result = controller.findById(1L);
		System.out.println(result);
		
		result.setNome("Mateus");
		controller.update(result);
		result = controller.findById(1L);
		System.out.println(result);
		
		
	}
}
