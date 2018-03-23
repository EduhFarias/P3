package Resource;

import Resource.Atividade;
import Util.Date;
import Util.Hour;

public class Recurso {

    private String ident;
    private Date dInicio;
    private Hour hInicio;
    private Date dTermino;
    private Hour htermino;
    private User user;
    private String status = "Em processo de alocação";
    private Atividade event;

    public Atividade getEvent(){
        return this.event;
    }

    public void setEvent(Atividade event){
        this.event = event;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Recurso(String ident, Date dInicio, Hour hInicio, Date dTermino,
                   Hour htermino, User user, Atividade event) {
        this.ident = ident;
        this.dInicio = dInicio;
        this.hInicio = hInicio;
        this.dTermino = dTermino;
        this.htermino = htermino;
        this.event = event;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
