package com.mike;
import  java.lang.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

/**
 * Created by Mike on 9/12/2015.
 */
        CCValidator validator = new CCValidator();

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a 16 digit credit card number to verify that it is a valid visa card:");
        String card_number = scan.nextLine();
        // check user input before calling methods
        while (card_number.length() != 16 || !card_number.matches("[0-9]+") || !card_number.startsWith("4")) {
            System.out.println("The number you entered doesn't match the visa format, please try again.");
            System.out.println("Enter a valid card number: ");
            card_number = scan.nextLine();
        }
        // call methods and prints
        boolean result = luhn_check(card_number);
        isCreditCardValid(result);
        System.out.println("card number entered: " + card_number);
    }

    static  boolean luhn_check (String card_number) {
        // initialize variable to save sum of selected digits
        int sum = 0;
        for (int i = 0; i < card_number.length(); i++){
            char temp = card_number.charAt(i);
            int num = temp - '0';  // wouldn't compile before adding "temp - '0' "; not really sure why. used example from different numerical problem found on Dream.in.code
            int product;
            if(i % 2 !=0){
                product = num;
            } else {
                product = num * 2;
            }
            if (product > 9)
                product -= 9;
            sum += product;
        }
        return  ( sum % 10 == 0);
    }

    private static void isCreditCardValid(boolean valid) {
        if(valid){
            System.out.println("This card is valid!");
        } else {
            System.out.println("This card is invalid");
        }
     }
}

