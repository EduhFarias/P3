package pacote;

import java.util.ArrayList;

public class Comunidade {
	private Usuario dono;
	private ArrayList<Usuario> membros = new ArrayList<Usuario>();
	private String descricao, nome;
	
	public Comunidade(Usuario dono, String nome, String descricao){
		this.setNome(nome);
		this.setDescricao(descricao);
		this.membros.add(dono);
		this.dono=dono;
	}
	
	public void setDono(Usuario dono){
		this.dono = dono;
	}
	public Usuario getDono(){
		return dono;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	public String getDescricao(){
		return descricao;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setMembros(ArrayList<Usuario> membros){
		this.membros = membros;
	}
	public ArrayList<Usuario> getMembros(){
		return membros;
	}
	
	public static void mostrarMembros(){
		for(int i=0; i<this.membros.size(); i++){
			System.out.println("| "+i+" |"+this.membros.get(i).getLogin());
		}
	}
	
	public static void addMembro(Usuario usuario, String login){//usuario que adiciona e login do adicionado
		if(this.dono.equals(usuario)){
			System.out.println("pode");
		} else System.out.println("nao pode");
	}
	
	public static void mostrarComunidades(){
		for(int i=0; i<this.comunidade.size(); i++){
			System.out.println("| "+i+" |"+this.comunidade.get(i).getNome());
		}
	}
	
	public static void criarComunidade(Usuario dono){
		teclado.nextLine();
		System.out.println("Digite o nome da comunidade: ");
		String nome = teclado.nextLine();
		
		System.out.println("Digite a descricao da comunidade: ");
		String descricao = teclado.nextLine();
		this.comunidade.add(new Comunidade(dono, nome, descricao));
		dono.comunidade.add(new Comunidade(dono, nome, descricao));
	}
	
	public static void interagirComunidade(int a){
		do{
		    System.out.println("Comunidade "+this.comunidade.get(a).getNome());
		    System.out.println("O que deseja fazer? ");
		    System.out.println("0- sair\n1- mostrar membros\n2- convidar");
		    int choice = teclado.nextInt();
		    switch (choice){
		    case 0:	break;
		    case 1:	this.comunidade.get(a).mostrarMembros();
				    break;
				
		    case 2: String login;//do adicionado
				System.out.println("digite o login do adicionado: ");
				login = teclado.next();
				this.comunidade.get(a).addMembro(this, login);
				break;
		    }
		}while(choice != 0);
	}

}
