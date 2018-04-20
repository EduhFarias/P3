package pacote;
import java.util.Scanner;
import java.util.ArrayList;

public class Rede {
	Scanner teclado = new Scanner(System.in);
	private ArrayList<Usuario> usuario = new ArrayList<Usuario>();
	private String login, senha;	//as vezes usados como copo vazio
	private ArrayList<Comunidade> comunidade = new ArrayList<Comunidade>();
	
	public static void registrar(){
		System.out.println("menu de registro:");
		System.out.println("login: ");		login=teclado.next();
		System.out.println("senha: ");		senha=teclado.next();
		
		
		usuario.add(new Usuario(login, senha));
		System.out.println("registrado com login "+login+" e senha "+senha);
				
	}

	public static void logar(){
		System.out.println("menu de login:");
		System.out.println("login: "); login=teclado.next();
		System.out.println("senha: "); senha=teclado.next();
		for(int i=0; i<usuario.size(); i++){
			if(usuario.get(i).getLogin().equals(login) && usuario.get(i).getSenha().equals(senha)){
				interagir(usuario.get(i));
				//break;
				return;
			}
		}
		System.out.println("login ou senhas incorretos"); return;
		
	}
	
	public static void interagir(Usuario usuario){
		int choice, ident;
		System.out.println("vode está logado!");
		while (choice !=0 ){
		System.out.println("\n0- sair\n1- mostrar perfil\n2- editar perfil\n3- adicionar amigo\n4- lista de amigos\n5- enviar mensagem\n6- ver caixa de entrada\n7- ler mensagem\n8- ver solicitacoes de amizade");
		System.out.println("9- remover conta\n10- criar comunidade\n11- mostrar minhas comunidades\n12- interagir com minhas comunidades");
		v=teclado.nextInt();
		
		switch (choice){
			case 0: break;
			case 1: usuario.mostrarPerfil();
					break;
			case 2: usuario.editarPerfil();
					break;	
			case 3: System.out.println("digite o login do usuario que quer enviar um comvite de amizade: ");
				login = teclado.next();
				for(int i=0; i<this.usuario.size(); i++){
					if(this.usuario.get(i).getLogin().equals(login)){
						//implementar convite
						
						usuario.enviarConvite(usuario, this.usuario.get(i));
						//usuario.addAmigo(this.usuario.get(i));
						System.out.println("convite enviado para "+login);
						break;
					}
				}
				
				break;
			case 4: usuario.mostrarAmigos();
				break;
			case 5: System.out.println("digite o destinatario: (login)");
				login = teclado.next();
				for(int i=0; i<this.usuario.size(); i++){
					if(this.usuario.get(i).getLogin().equals(login)){
						usuario.enviarMensagem(this.usuario.get(i));
						System.out.println("mensagem enviada");
						break;
					}
				}
				break;
			case 6: usuario.entrada.mostrarCaixa();
				break;
			case 7: System.out.println("digite o numero da mensagem: ");
				ident = teclado.nextInt();
				usuario.entrada.mensagem.get(ident).mostrar();
				break;
			case 8: usuario.mostrarConvites();
				break;
			case 9: this.usuario.remove(usuario);
				break;
			case 10:this.criarComunidade(usuario);//problema?
				break;
			case 11:usuario.mostrarComunidades();
				break;
			case 12:System.out.println("digite o numero da comunidade que quer interagir: ");
				ident = teclado.nextInt();
				usuario.interagirComunidade(ident);
			}
		}
	}
}
