import java.util.Scanner;

public class Doomsday {
    public static void main(String[] args) {
        System.out.println("Welcome to the Doomsday Calculator!");
        System.out.print("What year are you looking for?   ");
        Scanner input = new Scanner(System.in);
        //Declares the String array for weekday names
        String[] weekdays = {
            "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"
        };
        //Declares the int array for the doomsday of every month
        int[] doomsdays = {
            3, 28, 7, 4, 9, 6, 11, 8, 5, 10, 7, 12
        };
        int year = input.nextInt();
        System.out.print("What month? (1-12)?   ");
        int month = input.nextInt();
        System.out.print("What day?   ");
        int day = input.nextInt();
        int anchor = 3;
        int divide = (year - 1900) / 12;
        int mod = ((year - 1900) % 12);
        int moddivide = mod / 4;
        int doomsday = (divide + mod + moddivide + anchor) % 7;
        //Adds 1 to the doomsdays of January and February if it is a leap year
        if (year % 4 == 0 && year != 1900) {
            doomsdays[0] = doomsdays[0] + 1;
            doomsdays[1] = doomsdays[1] + 1;
        }
        int diff = day - doomsdays[month - 1] + doomsday + 35;
        String weekday = weekdays[diff % 7];
        //Concatenates date into mm/dd/yyyy format
        String date = month + "/" + day + "/" + year;
        System.out.println("\n" + date + " was on a " + weekday + ".");
    }
}