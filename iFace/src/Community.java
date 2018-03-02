
import java.util.*;

public class Community {
	
	private String name;
	private String description;
	private User holder;
	private ArrayList<User> members = new ArrayList();
	
	public Community(String name, String description, User holder) {
		this.name = name;
		this.description = description;
		this.holder = holder;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getHolder() {
		return holder;
	}
	
	public void setHolder(User holder) {

		this.holder = holder;
	}
	
	public ArrayList<User> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}

	public static void createCommunity(ArrayList<Community> communities){
		
		Scanner input = new Scanner(System.in);
		String name, description;
		
		System.out.println("Digite o nome da nova comunidade:");
		name = input.nextLine();
		//Checar se não há nenhuma outra comunidade com o mesmo nome
		System.out.println("Dê uma descrição para a comunidade:");
		description = input.nextLine();
		
		User current = null;
		Community newCommunity = new Community(name, description, current);
		
		communities.add(newCommunity);
		
		System.out.println("Comunidade criada com sucesso!");
	}
	
	public static void addMember(ArrayList<Community> communities){
		
		Scanner input = new Scanner(System.in);
		String name;
		boolean exist = false;
		User atual = null;
		
		System.out.println("Digite o nome da comunidade que deseja participar:");
		name = input.nextLine();
		
		for(Community current : communities){
			if(current.getName().equals(name)){
				current.getMembers().add(atual);
				exist = true;
				break;
			}
		}
		
		if(!exist){
			int choice;
			
			System.out.println("Comunidade não encontrada.");
			System.out.println("1. Deseja criar uma nova comunidade ?");
			System.out.println("2. Deseja verificar as comunidades existentes ?");
			choice = input.nextInt();
			
			if(choice == 1){
				createCommunity(communities);
			} else if(choice == 2){
				printCommunity(communities);
			}
		}
	}
	
	public static boolean checkCommunity(ArrayList<Community> communities, String name){
		for(Community current : communities){
			if(current.getName().equals(name))
				return  true;
		}
		
		return false;
	}
	
	public static void printCommunity(ArrayList<Community> communities){
		for(Community current : communities){
			System.out.println(current.getName());
		}
	}


}
