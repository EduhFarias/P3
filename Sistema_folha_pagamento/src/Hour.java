public class Hour {
    private int hrs;
    private int min;
    private int seg;

    public Hour(int hrs, int min, int seg) {
        this.hrs = hrs;
        this.min = min;
        this.seg = seg;
    }

    public String toString(int hrs, int min, int seg){
        return String.format("%d:%d:%d", hrs, min, seg);
    }
}
