import java.util.Scanner;

public class Servico {

	private String nomeServico;
	private double taxa;

	public void atribuirNomeServico(String NomeServ){
		this.nomeServico = NomeServ;
	}

	public void atribuirTaxa(double Taxa){
		this.taxa = Taxa;
	}

	public String nomeServico(){
		return nomeServico;
	}

	public double obterTaxa(){
		return taxa;
	}

	public static void lancarTaxaServico() {

		Scanner input = new Scanner(System.in);
		Servico serv = new Servico();

		System.out.printf("Qual serviço você deseja adicionar?%n");
		String servico = input.nextLine();

		serv.atribuirNomeServico(servico);

		System.out.printf("Qual a taxa desse serviço?%n");
		double taxa = input.nextDouble(); input.nextLine();

		serv.atribuirTaxa(taxa);

		System.out.printf("Qual o empregado associado a esse serviço?%n");
		int ident = input.nextInt(); input.nextLine();
		Empregado emp = Sistema.empregados.get(ident);

		emp.adicionarServico(serv);


	}

}