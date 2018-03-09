import java.util.Scanner;


public class Agenda {
	public static void mudarAgendaDePagamento(){

		Scanner input = new Scanner(System.in);

		System.out.printf("Qual o número de identificação do empregado?");
		int ident = input.nextInt(); input.nextLine();

		Empregado emp = Sistema.empregados.get(ident);

		System.out.printf("Qual tipo de agenda de pagamento? semanalmente, mensalmente ou bi-semanalmente?%n");
		String agendPag = input.nextLine();

		agendPag = agendPag.toLowerCase();

		if(agendPag.equals("semanalmente")){

			emp.atribuirtAgendaPagamento(7);

		} else if(agendPag.equals("mensalmente")){

			emp.atribuirtAgendaPagamento(30);

		} else {

			emp.atribuirtAgendaPagamento(14);;

		}

	}

	public static void personalizarAgendaDePagamento(){

		Scanner input = new Scanner(System.in);

		System.out.printf("Qual o número de identificação do empregado?");
		int ident = input.nextInt(); input.nextLine();

		Empregado emp = Sistema.empregados.get(ident);

		System.out.printf("De quanto em quanto tempo você deseja receber?");
		int periodoPagamento = input.nextInt(); input.nextLine();

		emp.atribuirtAgendaPagamento(periodoPagamento);



	}

}
