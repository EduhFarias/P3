package pacote;

import java.util.ArrayList;

public class CaixaEntrada {
	private ArrayList<Mensagem> mensagem = new ArrayList<Mensagem>();
	
	
	
	public statoc void mostrarCaixa(){
		if(mensagem.size()>0){
			
			for(int i=0; i<mensagem.size(); i++){
				System.out.print("| "+i+" | - ");
				System.out.println("remetente: "+mensagem.get(i).getRemetente()+"| titulo: "+mensagem.get(i).getTitulo());
			}
		}
		else{
			System.out.println("caixa de entrada vazia");
		}
	}
	
	public static void addMensagem(String titulo, String remetente,  String texto){
		
		mensagem.add(new Mensagem(titulo, remetente, texto));
	}
	public static void mostrarMensagem(int ident){
		this.mensagem.get(ident).mostrar();
	}

}
