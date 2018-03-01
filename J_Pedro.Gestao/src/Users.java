import java.util.*;

public class Users {
	Scanner input = new Scanner(System.in);
	ArrayList<String> firstName = new ArrayList<String>();
	ArrayList<String> lastName = new ArrayList<String>();
	ArrayList<String> email = new ArrayList<String>();
	ArrayList<Integer> type = new ArrayList<Integer>();
	
	ArrayList<String> senha = new ArrayList<String>();
	
	public Users(){
		firstName.add("adm");
		lastName.add("adm");
		email.add("admin@hotmail.com");
		senha.add("123");
		type.add(0);
		
	}
	
	
	
	public void Cadastro()
	{
		System.out.println("Primeiro Nome:");
		String firstName = input.next();
		System.out.println("Último Nome:");
		String lastName = input.next();
		System.out.println("Email:");
		String email = input.next();
		System.out.println("Senha:");
		String senha = input.next();
		System.out.println("Qual dessas opções você se enquadra:");
		System.out.println("[1]Professor");
		System.out.println("[2]Pesquisador");
		System.out.println("[3]Aluno Graduação");
		System.out.println("[4]Aluno Mestrado");
		System.out.println("[5]Aluno Doutorado");
		int type = input.nextInt();
		
		firstName.add(firstName);
		lastName.add(lastName);
		email.add(email);
		senha.add(senha);
		type.add(type);
		
		
		
	}
	
	public int Consulta()
	{
		System.out.println("Qual o Primeiro Nome do Usuário que você quer consultar?");
		String firstName = input.next();
		System.out.println("E o último Nome?");
		String lastName = input.next();
		int i;		
		for(i = 0; i < firstName.size();++i)
		{			
			if(firstName.get(i).intern() == firstName.intern())
			{				
				if(lastName.get(i).intern() == lastName.intern())
				{
						return i;			
				}			
			}
		}
		return -1;
	}
	
	public int Login()
	{
		System.out.println("Email:");
		String email = input.next();
		System.out.println("Senha:");
		String senha = input.next();
		int aux = verify(email,senha);
		return aux;
			
	}
	
	public int verify(String email, String senha)
	{
		int i;		
		for(i = 0; i < email.size();++i)
		{			
			if(email.get(i).intern() == email.intern())
			{				
				if(senha.get(i).intern() == senha.intern())
				{
					return i;					
				}
				break;
			}
		}
		
		return -1;
	}
	
	public int numero_usuarios()
	{
		return email.size();
	}
		


}
