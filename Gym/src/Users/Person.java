package Users;

public abstract class Person {

    protected static String name;
    protected String password;
    public String gender;
    protected String address;
    protected String phoneNumber;
    public String email;
    public int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String password, String gender, String address, String phoneNumber, String email, int age) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public abstract void displayInfo();

    public abstract void login();
    public abstract void mainMenu();
}