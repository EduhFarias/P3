
public class Recurso {
	
	private String ident;
	private Date dInicio;
	private Hour hInicio;
	private Date dTermino;
	private Hour htermino;
	private String user;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Recurso(String ident, Date dInicio, Hour hInicio, Date dTermino,
			Hour htermino, String user) {
		this.ident = ident;
		this.dInicio = dInicio;
		this.hInicio = hInicio;
		this.dTermino = dTermino;
		this.htermino = htermino;
		
		if(user != "Professor" || user != "Pesquisador" || user != "Administrador")
			System.out.println("Usuario não permitido");
		else 
			this.user = user;
		
		status = "Em processo de alocação";
	}

	public String getIdent() {
		return ident;
	}

	public void setIdent(String ident) {
		this.ident = ident;
	}

	public Date getdInicio() {
		return dInicio;
	}

	public void setdInicio(Date dInicio) {
		this.dInicio = dInicio;
	}

	public Hour gethInicio() {
		return hInicio;
	}

	public void sethInicio(Hour hInicio) {
		this.hInicio = hInicio;
	}

	public Date getdTermino() {
		return dTermino;
	}

	public void setdTermino(Date dTermino) {
		this.dTermino = dTermino;
	}

	public Hour getHtermino() {
		return htermino;
	}

	public void setHtermino(Hour htermino) {
		this.htermino = htermino;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	

}
