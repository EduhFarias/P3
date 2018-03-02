
import java.util.*;

public class User {

	private String name;
	private Register algo;
	private ArrayList<User> friends = new ArrayList();
	
	public User(String name, Register algo) {
		this.name = name;
		this.algo = algo;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Register getAlgo() {
		return algo;
	}
	
	public void setAlgo(Register algo) {
		this.algo = algo;
	}
	
	public User addUser(){
		
		Scanner input = new Scanner(System.in);
		String name, login, password, email;
		
		System.out.println("Digite o nome do novo usuário:");
		name = input.nextLine();
		System.out.println("Digite um login:");
		login = input.nextLine();
		//Fazer uma função pra checar se esse login já existe
		System.out.println("Digite uma senha:");
		password = input.nextLine();
		System.out.println("Digite um email:");
		email = input.nextLine();
		
		Register algo = new Register(login, password, email);
		
		User newUser = new User(name, algo);
		
		System.out.println("Usuário cadastrado com sucesso!");
		
		return newUser;
	}
	
	public static boolean checkUser(ArrayList<User> users, String name){
		for(User current : users){
			if(current.getName().equals(name))
				return true;
		}
		return false;
	}
	
	public static void removeUser(ArrayList<User> users){
		
		Scanner input = new Scanner(System.in);
		String password;
		//Dar um jeito de saber que está logado e remover pedindo somente a senha como confirmação
		System.out.println("Por favor, confirme a sua senha:");
		password = input.nextLine();
		
		for(User current : users){
			if(current.getAlgo().getPassword().equals(name)){
				users.remove(current);
				System.out.println("Usuário removido com sucesso!");
				break;
			}
		}
		
	}

	public static void addFriend(ArrayList<User> users, ArrayList<User> friends){
		Scanner input = new Scanner(System.in);
		String name;
		boolean exist = false;
		
		
		System.out.println("Digite o nome do usuário que deseja adicionar a lista de amigos:");
		name = input.nextLine();
		
		for(User current : users){
			if(current.getName().equals(name)){
				
				exist = true;
				break;
			}
		}
		
		if(!exist){
			
		}
	}

}