public class Hour {

    private int horas;
    private int min;

    public Hour(int horas, int min) {
        if(horas >= 0 && horas <= 24)
            this.horas = horas;

        if(min >= 0 && min <= 60)
            this.min = min;
    }

    public String toString(){
        return String.format("%d:%d", horas, min);
    }
}
