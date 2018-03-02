
import java.util.*;

public class Message {
	 
	private User sender;
	private String subject;
	private String content;
	
	public Message(User sender, String subject, String content) {
		this.sender = sender;
		this.subject = subject;
		this.content = content;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public static void sendMessage(ArrayList<User> users, ArrayList<Community> communities){
		int choice;
		String name, content, subject;
		Scanner input = new Scanner(System.in);
		
		System.out.println("1. Enviar mensagem para um usuário:");
		System.out.println("2. Enviar mensagem para uma comunidade: ");
		choice = input.nextInt();
		System.out.println("Digite o nome do usuário/Comunidade:");
		name = input.nextLine();
		
		if(choice == 1){
			if(User.checkUser(users, name)){
					
			} else
		} else{
			if(Community.checkCommunity(communities, name)){
				
			}
		}
		
		System.out.println("Digite o assunto da mensagem:");
		subject = input.nextLine();
		System.out.println("Digite a mensagem:");
		content = input.nextLine();
		
	}
}
