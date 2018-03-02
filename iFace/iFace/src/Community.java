
import java.util.*;

public class Community {
	
	private String name;
	private String description;
	private User holder;
	private ArrayList<User> members = new ArrayList();
	
	public Community(String name, String description, User holder) {
		this.name = name;
		this.description = description;
		this.holder = holder;
	}

	
	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	

	public String getDescription() {
		return description;
	}
	

	public void setDescription(String description) {
		this.description = description;
	}
	

	public User getHolder() {
		return holder;
	}
	

	public void setHolder(User holder) {
		this.holder = holder;
	}
	
	
}
