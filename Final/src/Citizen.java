/**
 * Created by Brandon Braun on 5/16/2015.
 */
public class Citizen implements java.io.Serializable{
    private long id;
    private int age;
    private String state;
    private String gender;
    private int status;

    public Citizen(long id, int age, String state, String gender, int status) {
        this.id = id;
        this.age = age;
        this.state = state;
        this.gender = gender;
        this.status = status;
    }

    public void printInformation() {
        System.out.print("ID: " + getId() + ", ");
        System.out.print("Age: " + getAge() + ", ");
        System.out.print("State: " + getState() + ", ");
        System.out.print("Gender: " + getGender() + ", ");
        System.out.print("Status: " + getStatus() + "\n");
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
