package pacote;

public class Perfil {
	private String sexo;
	private int idade, numeroAmigos;
	private String descricao, nome;
	
	private Perfil(){
		sexo = "nao informado";
		idade = 0;
		descricao = "nao informado";
		nome = "nao informado";
		numeroAmigos = 0;
	}
	private void setName(String nome){
		this.nome = nome;
	}
	private void setIdade(int idade){
		this.idade = idade;
	}
	private void setDescricao(String descricao){
		this.descricao = descricao;
	}
	private void setSexo(String sexo){
		this.sexo = sexo;
	}
	
	public static void mostrarPerfil(){
		System.out.println("Nome: "+perfil.nome);
		System.out.println("Idade: "+perfil.idade);
		System.out.println("Sexo: "+perfil.sexo);
		System.out.println("Minha descrição: "+perfil.descricao);
	}
	
	public static void editarPerfil(){
		System.out.println("O que deseja editar?");
		System.out.println("0- voltar\n1 - nome\n2 - idade\n3 - sexo\n4 - descrição");
		int choice = teclado.nextInt();
		
		switch (choice){
		case 0: return;
		case 1: System.out.println("Digite seu novo nome:");
				String nome = teclado.nextLine();
				setName(name);
				break;
		case 2: System.out.println("Digite sua nova idade: ");
				int idade = teclado.nextInt();
				setIdade(idade);
				break;
		case 3: System.out.println("Informe seu sexo: ");
				String sexo = teclado.nextLine();
				setSexo(sexo);
				break;
		case 4: System.out.println("Fale sobre você: ");
				String biografia = teclado.next();
				setDescricao(biografia);
				break;
		}
		return;
	}
}
