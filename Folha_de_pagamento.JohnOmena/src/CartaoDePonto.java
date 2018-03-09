import java.util.Scanner;

public class CartaoDePonto {

	private int dia;
	private int mes;
	private int inicioTrabalho;
	private int fimTrabalho;
	private double valorDeTrabalho;

	public void atribuirData(int dia, int mes) {

		this.dia = dia; this.mes = mes ;

	}

	public void atribuirHorarioTrabalhado(int inicio, int fim, double valorHora) {

		this.inicioTrabalho = inicio;
		this.fimTrabalho = fim;

		int horaTotal = 0;
		for(int i = inicio; i != fim; i ++) {

			horaTotal ++;
			if(i == 24) {
				i = i % 24;
			}

		}

		if(horaTotal > 8) {
			this.valorDeTrabalho =  ((valorHora * 1.5) * (horaTotal - 8)) + (valorHora * 8);
			return;
		}

		this.valorDeTrabalho = (valorHora * horaTotal);

	}

	public double obterValorDeTrabalho() {
		return valorDeTrabalho;
	}

	public static void lancarCartaoDePonto() {

		Scanner input = new Scanner(System.in);
		CartaoDePonto cartP = new CartaoDePonto();

		System.out.printf("Digite o número de identificação do empregado:%n");
		int identificacao = input.nextInt(); input.nextLine();
		Empregado emp = Sistema.empregados.get(identificacao);

		System.out.printf("Digite o dia e o mês desse cartão de ponto:%n");

		int dia = input.nextInt(); input.nextLine();
		int mes = input.nextInt(); input.nextLine();
		cartP.atribuirData(dia, mes);

		System.out.printf("Digite o horário de início e de término do trabalho:%n");

		int inicio = input.nextInt(); input.nextLine();
		int fim = input.nextInt(); input.nextLine();

		cartP.atribuirHorarioTrabalhado(inicio, fim, emp.obterValorDeTrabHora());

		emp.adicionarCartaoPonto(cartP);

	}
}
