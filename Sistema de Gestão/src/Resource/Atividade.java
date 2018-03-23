package Resource;

public class Atividade {

    private String tipo;
    private String titulo;
    private String descricao;
    private int participante;
    private String mApoio;

    public Atividade(String tipo, String titulo, String descricao,
                     int participante, String mApoio) {

        this.tipo = tipo;
        this.titulo = titulo;
        this.descricao = descricao;
        this.participante = participante;
        this.mApoio = mApoio;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public int getParticipante(){
        return this.participante;
    }

    public void setParticipante(){
        this.participante = participante;
    }

    public String getmApoio(){
        return this.mApoio;
    }

    public void setmApoio(String mApoio){
        this.mApoio = mApoio;
    }
}
