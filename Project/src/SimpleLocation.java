
public class SimpleLocation {

	public double latitude, longitude;

	public SimpleLocation(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
		
	public void distance(SimpleLocation location){
		System.out.println("Latitude " + location.latitude);
		System.out.println("Longitude " + location.longitude);
		 
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

}
