package pacote;

import java.util.ArrayList;
import java.util.Scanner;

public class Usuario {
	private ArrayList<Usuario> amigos = new ArrayList<Usuario>();
	private String login, senha;
	private Perfil perfil;
	private Scanner teclado = new Scanner(System.in);
	private CaixaEntrada entrada;
	private ArrayList<Convite> convites = new ArrayList<Convite>();
	private ArrayList<Comunidade> comunidades = new ArrayList<Comunidade>();
	
	public Usuario(String login, String senha, Perfil perfil, CaixaEntrada mensagens){
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.entrada = mensagens;
	}
	
	public String getLogin(){
		return this.login;
		
	}
	public String getSenha(){
		return this.senha;
	}	
	
	public static void addAmigo(Usuario amigo){
		this.amigo.add(amigo);
	}
	
	public static void mostrarAmigos(){
		for(int i=0; i<this.amigo.size(); i++){
			System.out.println(this.amigo.get(i).getLogin());
		}
	}
}
