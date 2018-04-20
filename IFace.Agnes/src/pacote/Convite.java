package pacote;

public class Convite {
	
	private Usuario usuario;
	public Convite(Usuario usuario){
		this.usuario=usuario;
	}
	
	public void setUsuario(Usuario usuario){
		this.usuario = usuario;	
	}
	
	public Usuario getUsuario(){
		return usuario;	
	}
	
	public static void enviarConvite(Usuario eu, Usuario amigo){
		amigo.convite.add(new Convite(eu));
		
	}
	
	public static void mostrarConvites(){
		if(this.convite.size()>0){
		    for(int i=0; i<this.convite.size(); i++){
			    System.out.println("| "+i+" | voce tem uma solicitacao de amizade de "+this.convite.get(i).usuario.getLogin());
		    }
		    System.out.println("1- aceitar\n2- recusar");
		
		    int choice = teclado.nextInt();
		    System.out.println("digite o numero do convite");
		    int convite = teclado.nextInt();
		
		    switch (choice){
			    case 1:	this.addAmigo(this.convite.get(convite).usuario);
				    this.convite.get(convite).usuario.addAmigo(this);
				    System.out.println("convite aceito");
				    break;
			    case 2: this.convite.remove(convite);
                    break;
		    }
			System.out.println("feito!");
		} else System.out.println("sem solicitacoes");
	}

}
