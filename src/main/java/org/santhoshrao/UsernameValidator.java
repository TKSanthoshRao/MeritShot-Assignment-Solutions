package org.santhoshrao;
import java.util.Scanner;

public class UsernameValidator{
    public static boolean isLetter(char ch){          // checking if letter is alphabet
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static boolean isDigit(char ch){            // checking if letter is number
        return (ch >= '0' && ch <= '9');
    }

    public static boolean validate(String username){  // checking username is ok or not
        int len = username.length();
        // checking length rule
        if(len < 5){
            return false;
        }

        // checking first letter is alphabet
        if(!isLetter(username.charAt(0))){
            return false;
        }

        for(int i = 0; i < len; i++){
            char ch = username.charAt(i);
            if(!isLetter(ch) && !isDigit(ch)){
                return false;                                           // checking every letter one by one
            }
        }
        return true; //  Everything is Fine so return true
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of testcases : ");
        int n = Integer.parseInt(sc.nextLine());   // converting string to integer
        while (n-->0){
            System.out.print("Enter username: ");     // asking username from user
            String username = sc.nextLine();
            // checking username good or bad
            if (validate(username)) {
                System.out.println("Valid Username");
            } else {
                System.out.println("Invalid Username");
            }
        }
    }
}

