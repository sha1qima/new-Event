public class Attendee {
    
    private String name;
    private char gender;
    private String email;
    private int age;
    
    public Attendee(String name, char gender, String email, int age) {
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.age = age;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public char getGender() {
        return gender;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}