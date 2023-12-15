package Users;

import GymDetails.Gym;

import java.util.Scanner;

public class SystemUser extends Person{
    @Override
    public void displayInfo() {

    }

    @Override
    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your UserName:");
        String userName = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        do {
            boolean flag = false;
            for (int i = 2; i < Gym.listOfSystemUsers.size(); i += 2) {
                if (Gym.listOfSystemUsers.contains(userName) && Gym.listOfSystemUsers.get(i + 1).equals(password)) {
                    System.out.println("hello " + userName);
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (flag)
                break;
            else
                System.out.println("Username or password is wrong ❌");
        } while (true);
    }
    @Override
    public void mainMenu() {

    }

    @Override
    public void register() {

    }
}
