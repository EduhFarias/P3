public class User {
    private String name;
    private String address;
    private Date birthday;
    private String status;
    private int nRefer;

    public User (String name, String address, Date birthday, String status, int nRefer){
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.status = status;
        this.nRefer = nRefer;
    }

    public void setName (String name){
        this.name = name;
    }

    public String getName (){
        return this.name;
    }

    public void setAddress (String address){
        this.address = address;
    }

    public String getAddress (){
        return this.address;
    }

    public void setBirthday (Date birthday){
        this.birthday = birthday;
    }

    public Date getBirthday (){
        return this.birthday;
    }

    public void setStatus (String status){
        this.status = status;
    }

    public String getStatus (){
        return this.status;
    }

    public void setnRefer (int nRefer){
        this.name = name;
    }

    public int getnRefer (){
        return this.nRefer;
    }
}
