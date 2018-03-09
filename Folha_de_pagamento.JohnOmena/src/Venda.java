import java.util.Scanner;

public class Venda {

	private String produto;
	private double valor;
	private int numeroEmpregado;



	public void atribuirNomeProduto(String nomeProduto) {
		this.produto = nomeProduto;
	}

	public void atribuirVendaEmpregado(int numeroEmpregado) {
		this.numeroEmpregado = numeroEmpregado;
	}

	public void atribuirValorVenda(double valorVenda) {
		this.valor = valorVenda;
	}

	public static void lancarVenda() {

		Scanner input = new Scanner(System.in);
		Venda vend = new Venda();

		System.out.printf("Qual o produto comprado?%n");
		String nomeProduto = input.nextLine();
		vend.atribuirNomeProduto(nomeProduto);

		System.out.printf("Qual o valor do produto?%n");
		double valorProduto = input.nextDouble(); input.nextLine();
		vend.atribuirValorVenda(valorProduto);

		System.out.printf("Qual é o número identificador do empregado?%n");
		int numeroIden = input.nextInt(); input.nextLine();
		vend.atribuirVendaEmpregado(numeroIden);

		Empregado emp = Sistema.empregados.get(numeroIden);
		emp.atribuirValorVenda(valorProduto, emp.obterPercentualVenda());

		Sistema.vendas.add(vend);

	}

}