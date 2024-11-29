package LogiTrackDelivery;

import java.util.Scanner;

public class Pages {


    // banner() allows for easy deployment of the LogiTrack Banner to pages that require it and eliminates redundant code.
    void banner(){
        System.out.println("------------------------- LogiTrack Delivery Services -------------------------");
        System.out.println("Please Select one from the following options:");
    }

    // homePage() creates the homepage for
    boolean homePage() {
        // instantiate class in method to avoid StackOverflowError
        UserIO handleIO = new UserIO();
        banner();
        System.out.println("1. Sort/View Delivery Lists");
        System.out.println("2. Add/Remove Packages");
        System.out.println("3. Exit Program");

        // Variable "stopProgram" reads and stores the returned boolean value
        // ... from the method, "homePage()" found within the class, "Pages"....
        // ... ultimately returning it to method, "launchProgram()" in class, "userInterface"
        Boolean stopProgram = handleIO.homepage();
        return stopProgram;
    }

    void viewDeliveryPage() {
        // instantiating class in method to avoid StackOverflowError
        UserIO handle = new UserIO();
        banner();
        System.out.println("1. Sort Package List");
        System.out.println("2. View Package List");
        System.out.println("3. Return to Home Screen");
        handle.viewDelivery();
    }

    void sortDelivery(){
        dataHandling handle = new dataHandling();
        handle.sortPackage();

    }

    void viewDelivery(){
        dataHandling handle = new dataHandling();
        handle.viewPackage();
    }

    void modifyDeliveryPage(){
        // instantiating class in method to avoid StackOverflowError
        UserIO handle = new UserIO();
        banner();
        System.out.println("1. Add New Package");
        System.out.println("2. Remove Package");
        System.out.println("3. Return to Home Screen");
        handle.modifyPackages();
    }

    void addPackages(){
        UserIO handle = new UserIO();
        handle.addPackages();
    }

    void removePackages(){
        //
    }



    // generates the exit menu for terminating the program.
    boolean exitMenu() {
        //instantiating class in method to avoid StackOverflowError
        UserIO handle = new UserIO();
        System.out.println("Would you like to exit the program? (Y/N)");

        // stopProgram reads and stores the boolean value returned...
        // ... from the method, "exitMenu()" in Class "userInterface"...
        // ... which is then ultimately returned to homePage() method in class UserIO
        Boolean stopProgram = handle.exitMenu();
        if (stopProgram.equals(true)){
            System.out.println("Thank you for Using LogiTrack Delivery Services");
        }
    return stopProgram;
    }
}
