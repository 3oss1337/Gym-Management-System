package Users;
import java.util.Scanner;
public abstract class Person {

    protected  String name;
    protected  String password;
    public  String gender;
    protected  String address;
    protected String phoneNumber;
    public  String email;
    public  int age;

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
    public static String check_password(){
        System.out.print("Password : (At Least 8 Digit!!)");
        Scanner scanner = new Scanner(System.in);
        String PASS=scanner.next();
        while(true){
            boolean containsOnlyLetters = PASS.matches("[a-zA-Z]+");
            boolean containsOnlyNumbers = PASS.matches("\\d+");
            if(PASS.length()>=8){
                if(!containsOnlyLetters&&!containsOnlyNumbers){
                    System.out.println(" ENTER CONFIRM PASSWORD");
                }
                else{
                    System.out.println("YOUR PASSWORD IS WEAK ENTER ANOTHER ONE");
                    PASS=scanner.next();
                    continue;
                }
                String confirm_pass = scanner.next();
                if(PASS.equals(confirm_pass)){
                    //correct password
                    System.out.println("gada3 y hmada");
                    return PASS;

                }
                else{
                    System.out.println("NOT MATCHING WITH PASSORD");
                    continue;
                }
            }
            else{
                System.out.println("YOU MUST ENTER AT LEAST 8 DIGITS");
                PASS=scanner.next();
                continue;
            }

        }
    }

    public abstract void displayInfo();

    public abstract void login();
    public abstract void menu();
}