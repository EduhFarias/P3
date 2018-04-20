package pacote;

public class Mensagem {
	private String titulo;
	private String remetente;
	private String destinatario;
	private String texto;
	
	public Mensagem(String titulo, String remetente, String texto){
		this.setTitulo(titulo);
		this.setRemetente(remetente);
		this.setTexto(texto);
	}
	public String getTexto(){
		return texto;
	}
	public String getTitulo(){
		return titulo;
	}
	public String getRemetente(){
		return remetente;
	}
	public String getDestinatario(){
		return destinatario;
	}
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	public void setRemetente(String remetente){
		this.remetente = remetente;
	}
	public void setDestinatario(String destinatario){
		this.destinatario = destinatario;
	}
	public void setTexto(String texto){
		this.texto = texto;
	}
	
	public static void mostrar(){
		System.out.println("mensagem de "+remetente);
		System.out.println("\n"+titulo+"\n");
		System.out.println(this.getTexto());
	}
	
	public static void enviarMensagem(Usuario destinatario){
		
		System.out.println("digite o titulo da mensagem: ");
		String titul = teclado.nextLine();
		System.out.println("digite a mensagem: ");
		String mensagem = teclado.nextLine();
		
		
		destinatario.entrada.addMensagem(titul, this.getLogin(), mensagem);//problema aqui
	}
	
}
