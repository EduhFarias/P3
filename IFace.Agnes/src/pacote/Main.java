package pacote;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner teclado= new Scanner(System.in);
		boolean continuar=true;
		int verificador;
		Rede rede= new Rede();
		
		while(continuar){
			System.out.println("1- logar\n2- criar conta\n3- sair");
			verificador=teclado.nextInt();
			if(verificador==2){
				rede.registrar();
			}
			else if(verificador==1){
				rede.logar();
			}
			else if(verificador==3){
				//System.out.println(rede.usuario.size());
			
				continuar=false;
				
				
			}
			
		}
		
		
		

	}

}
