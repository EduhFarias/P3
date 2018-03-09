import java.util.Scanner;


public class Interface {

	public enum Choice{

	    ADD(1), REMOVE(2), LAUNCH_POINT(3), LAUNCH_SALE(4), LAUNCH_SERV(5),
	    CHANGE_DATA(6), PAY(7), UNDO_REDO(8), CHANGE_AGENDA(9),
	    CUSTOMIZE_AGENDA(10), EXIT(11);


	    private final int choice;

	    private Choice(int choice){
	      this.choice = choice;
	    }

	    public int getChoice(){
	      return choice;
	    }

	  }

	public static void menuPrincipal() {

		Scanner input = new Scanner(System.in);

		System.out.printf("%n~~~~~~~~~~~~~~~~~~~~%n");
		System.out.println("#  Menu Principal  #");
		System.out.println("~~~~~~~~~~~~~~~~~~~~");
		System.out.println("1. Adicionar um empregado");
		System.out.println("2. Remover um empregado");
		System.out.println("3. Lançar cartão de ponto");
		System.out.println("4. Lançar venda");
		System.out.println("5. Lançar serviço");
		System.out.println("6. Alterar dados de um empregado");
		System.out.println("7. Rodar Folha de pagamento");
		System.out.println("8. Desfazer - Refazer");
		System.out.println("9. Mudar agenda de pagamento");
		System.out.println("10. Personalizar agenda de pagamento");
		System.out.println("11. Sair");
		System.out.println("Escolha umas das opções [1 até 11]: ");


		int opcao = input.nextInt(); input.nextLine();
		direcionamentoMenu(opcao);

	}

	public static void limparTela() {

		for(int i = 0; i < 20; i ++) {
			System.out.println();
		}

	}

	public static void direcionamentoMenu(int opcao) {


		switch(opcao) {

			case Choice.ADD.getChoice():
				limparTela();
				Empregado.adicionarEmpregado();
				continuarOuSair();
				break;

			case Choice.REMOVE.getChoice():
				limparTela();
				Empregado.removerEmpregado();
				continuarOuSair();
				break;
			case Choice.LAUNCH_POINT.getChoice():
				limparTela();
				CartaoDePonto.lancarCartaoDePonto();
				continuarOuSair();
				break;
			case Choice.LAUNCH_SALE.getChoice():
				limparTela();
				Venda.lancarVenda();
				continuarOuSair();
				break;
			case Choice.LAUNCH_SERV.getChoice():
				limparTela();
				Servico.lancarTaxaServico();
				continuarOuSair();
				break;
			case Choice.CHANGE_DATA.getChoice():
				limparTela();
				Empregado.alterarDadosEmpregado();
				continuarOuSair();
				break;
			case Choice.PAY.getChoice():
				limparTela();
				Empregado.rodarFolhaDePagamento();
				continuarOuSair();
			case Choice.UNDO_REDO.getChoice():
				limparTela();
				terminando();
				continuarOuSair();
			case Choice.CHANGE_DATA.getChoice():
				limparTela();
				Agenda.mudarAgendaDePagamento();
				continuarOuSair();
			case Choice.CUSTOMIZE_AGENDA.getChoice():
				limparTela();
				Agenda.personalizarAgendaDePagamento();
				continuarOuSair();
			case Choice.EXIT.getChoice():
				System.exit(0);
				break;
			default:
		}

	}

	public static void continuarOuSair() {

		Scanner input = new Scanner(System.in);
		System.out.printf("%nVocê desejar realizar outra aplicação? [S/N]%n");
		String opcao = input.nextLine();
		opcao = opcao.toUpperCase();

		if(opcao.equals("S")) {

			limparTela();
			menuPrincipal();

		} else {

			System.exit(0);

		}

	}

	public static void terminando(){

		System.out.println(".-----.                   _                       .-.               ");
		System.out.println("`-. .-'                  :_;                      : :               ");
		System.out.println("  : : .--. .--. ,-.,-.,-..-.,-.,-. .--.  ,-.,-. .-' : .--.          ");
		System.out.println("  : :' '_.': ..': ,. ,. :: :: ,. :' .; ; : ,. :' .; :' .; : _  _  _ ");
		System.out.println("  :_;`.__.':_;  :_;:_;:_;:_;:_;:_;`.__,_;:_;:_;`.__.'`.__.':_;:_;:_;");

	}
}