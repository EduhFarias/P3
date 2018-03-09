import java.util.ArrayList;
import java.util.Scanner;


public class Sistema {

	static ArrayList<Empregado> empregados = new ArrayList<Empregado>();
	static ArrayList<Venda> vendas = new ArrayList<Venda>();

	public static void main(String[] args) {

		Interface.menuPrincipal();
		Interface.limparTela();

	}

}