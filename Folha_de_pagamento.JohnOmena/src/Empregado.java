import java.util.ArrayList;
import java.util.Scanner;

public class Empregado {

	private String nome;
	private String endereco;
	private String cargo;
	private int proximoPagamento;
	private int ultimoPagamento;
	private int agendaPagamento;
	private String metodoPagamento;
	private double valorTrabalhoPorHora = 0.0;
	private double valorTrabalhoMensal = 0.0;
	private double percentualVendas = 0.0;
	private double valorVendas = 0.0;
	private boolean membroSindicato = false;
	private int identificacaoEmpresa;
	private int identificacaoSindicato;
	private double taxaSindical = 0.0;
	static ArrayList<CartaoDePonto> cartoesDePonto = new ArrayList<CartaoDePonto>();
	static ArrayList<Servico> servicos = new ArrayList<Servico>();

	public void atribuirNome(String nome){
		this.nome = nome;
	}

	public void atribuirEndereco(String endereco){
		this.endereco = endereco;
	}

	public void atribuirCargo(String cargo){
		this.cargo = cargo;
	}

	public void atribuirIdentificacaoEmpresa(int identificacao){
		this.identificacaoEmpresa = identificacao;
	}

	public void atribuirIdentificacaoSindicato(int identificacaoEmpresa){
		this.identificacaoSindicato = identificacaoEmpresa + 1;
	}

	public void atribuirPercentualVendas(double percentVenda){
		this.percentualVendas = percentVenda;
	}

	public void atribuirValorDetrabHora(double valorHora) {
		this.valorTrabalhoPorHora = valorHora;
	}

	public void atribuirValorDeTrabMensal(double valorMensal) {
		this.valorTrabalhoMensal = valorMensal;
	}

	public double obterValorDeTrabHora() {
		return valorTrabalhoPorHora;
	}

	public double obterPercentualVenda() {
		return percentualVendas;
	}

	public void adicionarCartaoPonto(CartaoDePonto cartP) {
		cartoesDePonto.add(cartP);
	}

	public void atribuirValorVenda(double venda, double percentualVenda) {

		this.valorVendas += (venda * percentualVenda);

	}

	public void adicionarServico(Servico serv){
		servicos.add(serv);
	}

	public void atribuirTaxaSindical(double taxaSin){
		this.taxaSindical = taxaSin;
	}

	public void atribuirMetodoPagam(String metodo){
		this.metodoPagamento = metodo;
	}

	public void atribuirAoSindicato(boolean validacao){
		this.membroSindicato = validacao;
	}

	public void modificarDatasPagamentos(int dia) {

		this.ultimoPagamento = dia;

		this.proximoPagamento = (dia + agendaPagamento) % 28;

	}

	public double calculoDeTaxa() {

		double valorServicos = 0.0;

		for(int i = 0; i < servicos.size(); i ++){

			Servico serv = servicos.get(i);
			valorServicos += (valorTrabalhoMensal * serv.obterTaxa());

		}


		if(membroSindicato == true) {

			valorServicos += valorTrabalhoMensal * taxaSindical;

		}

		return valorServicos;

	}

	public void atribuirtAgendaPagamento(int Agenda){

		this.agendaPagamento = Agenda;

		if(Agenda == 7){

			this.ultimoPagamento = 0;
			this.proximoPagamento = 7;

		} else if(Agenda == 14){

			this.ultimoPagamento = 0;
			this.proximoPagamento = 14;

		} else {

			this.ultimoPagamento = 0;
			this.proximoPagamento = 28;

		}

	}

	public boolean validacaoPagamento(){

		int contador = 0;

		for(int i = ultimoPagamento; i <= proximoPagamento ; i ++){

			contador ++;

			if(i == 28){
				i = 0;
			}

		}

		if(contador == 	agendaPagamento){

			return true;

		} else {

			return false;

		}

	}

	public void removerCartoesPonto() {

		int quantidadesCartoes = cartoesDePonto.size();
		for(int i = 0; i < quantidadesCartoes; i ++) {
			cartoesDePonto.remove(0);
		}

	}

	public void realizarPagamento(int dia){

		double valorFinal;

		if(cargo.equals("salariado")){

			double taxa = calculoDeTaxa();

			valorFinal = valorTrabalhoMensal - taxa;

			modificarDatasPagamentos(dia);

		} else if(cargo.equals("comissionado")) {

			double taxa = calculoDeTaxa();

			valorFinal = valorTrabalhoMensal + valorVendas - taxa;
			this.valorVendas = 0.0;

			modificarDatasPagamentos(dia);

		} else {

			CartaoDePonto carTemp;
			double valorCartoesFinal = 0.0;
			double taxa = calculoDeTaxa();

			for(int i = 0; i < cartoesDePonto.size(); i ++) {

				carTemp = cartoesDePonto.get(i);
				valorCartoesFinal += carTemp.obterValorDeTrabalho();
			}

			valorFinal = valorCartoesFinal - taxa;

			removerCartoesPonto();
			modificarDatasPagamentos(dia);


		}

		System.out.printf("O valor foi pago a %s%n", nome);
		System.out.printf("A quantia foi de %.2f%n", valorFinal);
		System.out.printf("O método de pagamento foi %s%n", metodoPagamento);

	}

	public static void adicionarEmpregado(){

		Scanner input = new Scanner(System.in);

		// Criando nosso objeto empregado.
		Empregado empreg = new Empregado();

		// Adicionando informações básicas do empregado.
		System.out.printf("Digite o nome do empregado:%n");
		String nome = input.nextLine();
		empreg.atribuirNome(nome);

		System.out.printf("Digite o endereco:%n");
		String endereco = input.nextLine();
		empreg.atribuirEndereco(endereco);

		System.out.printf("Digite o tipo de empregado:%n");
		String cargo = input.nextLine();
		empreg.atribuirCargo(cargo);

		cargo = cargo.toLowerCase();

		if(cargo.equals("salariado")) {

			System.out.printf("Qual será o valor do salário fixo?%n");
			double valorFix = input.nextDouble(); input.nextLine();

			empreg.atribuirValorDeTrabMensal(valorFix);


		} else if(cargo.equals("comissionado")) {

			System.out.printf("Qual será o valor do salário fixo?%n");
			double valorFix = input.nextDouble(); input.nextLine();

			empreg.atribuirValorDeTrabMensal(valorFix);

			System.out.printf("Qual será o valor do percentual das vendas?%n");
			double valorPer = input.nextDouble(); input.nextLine();

			empreg.atribuirPercentualVendas(valorPer);

		} else {

			System.out.printf("Qual será o valor do trabalho hora?%n");
			double valorHora = input.nextDouble(); input.nextLine();

			empreg.atribuirValorDetrabHora(valorHora);

		}


		System.out.printf("Qual tipo de agenda de pagamento? semanalmente, mensalmente ou bi-semanalmente?%n");
		String agendPag = input.nextLine();

		agendPag = agendPag.toLowerCase();

		if(agendPag.equals("semanalmente")){

			empreg.atribuirtAgendaPagamento(7);


		} else if(agendPag.equals("mensalmente")){

			empreg.atribuirtAgendaPagamento(28);

		} else {

			empreg.atribuirtAgendaPagamento(14);;

		}


		System.out.printf("Qual o método de pagamento desse empregado?%n");
		String metodoPag = input.nextLine();

		empreg.atribuirMetodoPagam(metodoPag);


		// Gerando identificação com base na quantidade atual de empregados da empresa.
		int identificacao = Sistema.empregados.size();
		empreg.atribuirIdentificacaoEmpresa(identificacao);

		Sistema.empregados.add(identificacao, empreg);

	}

	public static void removerEmpregado() {

		// A remoção é feita com base na forma como o número do empregado foi gerado.
		Scanner input = new Scanner(System.in);
		System.out.printf("Qual o número do empregado que você deseja remover?%n");
		int numero = input.nextInt(); input.nextLine();

		Sistema.empregados.remove(numero);

	}

	public static void alterarDadosEmpregado(){

		Scanner input = new Scanner(System.in);
		int ident = Sistema.empregados.size() + 1;

		while(ident > Sistema.empregados.size()){

			System.out.printf("Digite o número de identificação do empregado:%n");
			ident = input.nextInt(); input.nextLine();

			if(ident > Sistema.empregados.size()){
				System.out.printf("Desculpe-me, mas o número de identificação não existe, aperte Enter para digitar um novo número.%n");
			}

		}

		Empregado emp = Sistema.empregados.get(ident);

		System.out.printf("Qual o novo nome?%n");
		String novoNome = input.nextLine();
		emp.atribuirNome(novoNome);

		System.out.printf("Qual o novo endereço?%n");
		String novoEndereco = input.nextLine();
		emp.atribuirEndereco(novoEndereco);

		System.out.printf("Qual o novo tipo de empregado?%n");
		String novoTipo = input.nextLine();
		emp.atribuirCargo(novoTipo);

		if(novoTipo.equals("salariado")) {

			System.out.printf("Qual será o valor do salário fixo?%n");
			double valorFix = input.nextDouble(); input.nextLine();

			emp.atribuirValorDeTrabMensal(valorFix);
			emp.atribuirPercentualVendas(0.0);
			emp.atribuirValorDetrabHora(0.0);


		} else if(novoTipo.equals("comissionado")) {

			System.out.printf("Qual será o valor do salário fixo?%n");
			double valorFix = input.nextDouble(); input.nextLine();

			emp.atribuirValorDeTrabMensal(valorFix);

			System.out.printf("Qual será o valor do percentual das vendas?%n");
			double valorPer = input.nextDouble(); input.nextLine();

			emp.atribuirPercentualVendas(valorPer);
			emp.atribuirValorDetrabHora(0.0);

		} else {

			System.out.printf("Qual será o valor do trabalho hora?%n");
			double valorHora = input.nextDouble(); input.nextLine();

			emp.atribuirValorDetrabHora(valorHora);
			emp.atribuirValorDeTrabMensal(0.0);
			emp.atribuirPercentualVendas(0.0);

		}


		System.out.printf("Qual o novo método de pagamento?%n");
		String metodoPag = input.nextLine();

		emp.atribuirMetodoPagam(metodoPag);

		System.out.printf("O empregado pertence ao sindicato? [S/N]%n");
		String flag = input.nextLine();

		flag = flag.toLowerCase();

		if(flag.equals("s")){

			emp.atribuirAoSindicato(true);
			System.out.printf("Qual o valor da nova taxa sindical?%n");
			double taxaSind = input.nextDouble(); input.nextLine();

			emp.atribuirTaxaSindical(taxaSind);

		} else {

			emp.atribuirAoSindicato(false);
			emp.atribuirTaxaSindical(0.0);
		}




	}

	public static void rodarFolhaDePagamento(){

		Scanner input = new Scanner(System.in);

		System.out.printf("Que dia é hoje?");
		int diaHoje = input.nextInt(); input.nextLine();

		for(int i = 0; i < Sistema.empregados.size(); i++){

			Empregado emp = Sistema.empregados.get(i);

			if(emp.validacaoPagamento()){

				emp.realizarPagamento(diaHoje);

			}

		}

	}
}