package com.company.week2.day2;

import com.company.Timer;

import java.util.Scanner;

import static com.company.ToolBox.getOmniTool;

public class SearchUsers {

    static boolean hasVariable = true;
    Timer timer = new Timer();

    public void initUsers() {

        User[] users = new User[3];

        User u1 = new User();
        u1.name = "Kalle";
        u1.city = "Stockholm";
        u1.country = "Sweden";
        u1.age = 25;
        users[0] = u1;

        User u2 = new User();
        u2.name = "Joel";
        u2.city = "Malmö";
        u2.country = "Sweden";
        u2.age = 55;
        users[1] = u2;

        User u3 = new User();
        u3.name = "Adam";
        u3.city = "Helsingborg";
        u3.country = "Sweden";
        u3.age = 45;
        users[2] = u3;

        SearchUsers searchUsers = new SearchUsers();
        int maxAge = searchUsers.getMaxAgedUser(users);
        System.out.println("max age = " + maxAge);

        User result = searchUsers.getUserByName(users, new Scanner(System.in).nextLine());

        if (result != null) {
            System.out.println("Found " + result.name + " from " + result.city);
        } else {
            System.out.println("User not found!");
        }


    }

    private int getMaxAgedUser(User[] users) {
        int[] result = new int[users.length];
        for (int i = 0; i < users.length; i++) {
            result[i] = users[i].age;
        }
        return new ArrayHelper().maxNumber(result);
    }

    private User getUserByName(User[] users, String name) {
        User result = null;
        for (User u : users) {
            if (u.name.equalsIgnoreCase(name.trim())) result = u;
        }
        if (result == null) return null;
        else return result;
    }

}
class User{
    String name, city, country;
    int age;

    User(){
        name    = "";
        city    = "";
        country = "";
        age     = 0;
    }

    public User(String name, String city, String country, int age){
        this.name    = name;
        this.city    = city;
        this.country = country;
        this.age     = age;
    }

    public User(String name, String city){
        this.name = name;
        this.city = city;

    }
}