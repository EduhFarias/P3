package User;

import Util.Date;

public class Aluno {

	private String name;
	private String pos;
	private Date birthday;
	private int numbMatr;
	private String address;
	

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Aluno(String name, String pos, int age, Date birthday, int numbMatr, String address) {
		this.name = name;
		this.pos = pos;
		this.birthday = birthday;
		this.numbMatr = numbMatr;
		this.address = address;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPos() {
		return pos;
	}


	public void setPos(String pos) {
		this.pos = pos;
	}

	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public int getNumbMatr() {
		return numbMatr;
	}


	public void setNumbMatr(int numbMatr) {
		this.numbMatr = numbMatr;
	}

}
