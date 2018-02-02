
public class Hour {

	private int horas;
	private int min;
	private int seg;
	
	public Hour(int horas, int min, int seg) {
		if(horas >= 0 && horas <= 24)
			this.horas = horas;
		
		if(min >= 0 && min <= 60)
			this.min = min;
		
		if(seg >= 0 && seg <= 60)
			this.seg = seg;
	}
	
	public String toString(){
		return String.format("%d:%d:%d", horas, min, seg);
	}
}
