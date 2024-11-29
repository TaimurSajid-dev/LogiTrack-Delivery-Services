package LogiTrackDelivery;
import java.util.Scanner;
public class UserIO {

    // instantiates userInterface class into class UserIO
    Scanner scan = new Scanner(System.in);

    boolean homepage(){
        Pages load = new Pages();
        String userInput = scan.nextLine();
        Boolean stopProgram = false;
        if (userInput.equals("1")){
            load.viewDeliveryPage();
        }else if(userInput.equals("2")){
            load.modifyDeliveryPage();
        }else if(userInput.equals("3")){
            // stores user input from method "exitMenu()" method in Class "Pages"...
            // and feeds it to method "launchProgram()" in Class "Pages"
            stopProgram = load.exitMenu();
            return stopProgram;
        }else {
            System.out.println("Invalid Input Detected. Please try again");
        }
        return stopProgram;
    }

    void viewDelivery(){

        Boolean displayMenu = true;
        final String sortPackage = "1";
        final String viewPackage = "2";
        final String returnHomePage = "3";
        Pages load = new Pages();
        dataHandling handle = new dataHandling();
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        // method is handled within a "while true" loop in order to provide user...
        // ... with infinite chances to enter the correct response and to display...
        // ... user the acceptable input choices that are allowed
        while (displayMenu.equals(true)){
            switch (userInput){
                case sortPackage:
                    System.out.println("Sorting Packages...");
                    handle.sortPackage();
                    displayMenu = false;
                    break;

                case viewPackage:
                    load.viewDelivery();
                    displayMenu = false;
                    break;

                case returnHomePage:
                    System.out.println("Returning to HomePage...");
                    displayMenu = false;
                    break;

                default:
                    System.out.println("Invalid Input Detected. Please Try Again");
                    // instantiating class privately within default...
                    // as it is not needed for other switch cases
                    load.viewDeliveryPage();
                    displayMenu = false;
                    break;
            }
        }
    }


    void modifyPackages(){
        Pages load = new Pages();
        Boolean displayMenu = true;
        final String addPackage = "1";
        final String removePackage = "2";
        final String returnHomePage = "3";
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        // method is handled within a "while true" loop in order to provide user...
        // ... with infinite chances to enter the correct response and to display...
        // ... user the acceptable input choices that are allowed
        while (displayMenu.equals(true)){
            switch (userInput){
                case addPackage:
                    load.addPackages();
                    displayMenu = false;
                    break;

                case removePackage:
                    System.out.println("Package Listing Removed Successfully...");
                    displayMenu = false;
                    break;

                case returnHomePage:
                    System.out.println("Returning to HomePage...");
                    displayMenu = false;
                    break;
                default:
                    System.out.println("Invalid Input Detected. Please Try Again");
                    // instantiating class privately within default...
                    // as it is not needed for other switch cases
                    load.modifyDeliveryPage();
                    displayMenu = false;
                    break;
            }
        }
    }

    void addPackages(){
        Scanner read = new Scanner(System.in);
        System.out.println("Please Enter Zone (North, South, East, West)");
        String zone = read.nextLine();
        System.out.println("Please Enter Priority (1-5)");
        // instead of using nextInt() method, we use nextLine() method as it
        Integer priority = Integer.parseInt(read.nextLine());
        System.out.println("Please Enter Address");
        String address = read.nextLine();
        System.out.println("Please Enter Weight");
        Double weight = read.nextDouble();



        Packages pkg = new Packages(zone,priority,address,weight);
        if (zone.equals("North") || zone.equals("South") || zone.equals("East") || zone.equals("West")){
            if (priority >= 1 && priority <= 5) {
                if (priority <= 3) {
                    DataStorage.addPriorityPackage(pkg);
                    System.out.println("Package Created to Priority Queue Successfully");
                    System.out.println("PackageID: " + pkg.packageID);
                }else {
                    DataStorage.addPackage(pkg);
                    System.out.println("Package Created to Queue Successfully");
                    System.out.println("PackageID: " + pkg.packageID);
                }
            }else {
                System.out.println("Invalid Response for Priority Detected . Please Try Again");
            }
        }else {
            System.out.println("Invalid Response for Zone Detected. Please Try Again");
        }
    }


    void removePackages(){
        //
    }

    // method, "exitMenu() handles the userInput required for terminating the program
    // method, "stopProgram()" in class, "userInterface" is set to Boolean...
    // ... in order to return and feed stopProgram command (stored as Boolean)
    boolean exitMenu(){
        String userInput = scan.nextLine();
        Pages load = new Pages();
        Boolean stopProgram = false;

        if (userInput.equals("Y") || userInput.equals("y")){
            // stopProgram() method stores a singular Boolean value of true...
            // ... which is then read, stored within variable, "stopProgram"...
            // ... and returned to the exitMenu method in Pages
            userInterface ui = new userInterface();
            stopProgram = ui.stopProgram();
            return stopProgram;
        }else if (userInput.equals("N") || userInput.equals("n")){
            load.homePage();
        }else {
            System.out.println("Invalid Response Detected. Please Try Again");
            load.exitMenu();
        }
        return stopProgram;
    }
}
