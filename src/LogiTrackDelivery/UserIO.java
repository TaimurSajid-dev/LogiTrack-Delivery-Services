package LogiTrackDelivery;
import java.util.ArrayList;
import java.util.Scanner;
public class UserIO {

    // instantiates userInterface class into class UserIO
    Scanner scan = new Scanner(System.in);

    ////////////////////////////////////////////////////////////////    MENUS      ///////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////     MENUS      ///////////////////////////////////////////////////////////////

    boolean homepage(Boolean programStatus){
        Pages load = new Pages();
        String userInput = scan.nextLine();
        Boolean stopProgram = programStatus;
        if (userInput.equals("1")){
            load.viewDeliveryPage();
        }else if(userInput.equals("2")){
            load.modifyDeliveryPage();
        }else if(userInput.equals("3")){
            // stores user input from method "exitMenu()" method in Class "Pages"...
            // and feeds it to method "launchProgram()" in Class "Pages"
            stopProgram = load.exitMenu(programStatus);
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
        final String searchPackage = "3";
        final String returnHomePage = "4";
        Pages load = new Pages();
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        // method is handled within a "while true" loop in order to provide user...
        // ... with infinite chances to enter the correct response and to display...
        // ... user the acceptable input choices that are allowed
        while (displayMenu.equals(true)){
            switch (userInput){
                case sortPackage:
                    load.sortDelivery();
                    load.viewDeliveryPage();
                    displayMenu = false;
                    break;
                case viewPackage:
                    load.viewDelivery();
                    load.viewDeliveryPage();
                    displayMenu = false;
                    break;
                case searchPackage:
                    load.searchPackages();
                    load.viewDeliveryPage();
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
        final String updatePackage = "3";
        final String returnHomePage = "4";
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        // method is handled within a "while true" loop in order to provide user...
        // ... with infinite chances to enter the correct response and to display...
        // ... user the acceptable input choices that are allowed
        while (displayMenu.equals(true)){
            switch (userInput){
                case addPackage:
                    load.addPackages();
                    load.modifyDeliveryPage();
                    displayMenu = false;
                    break;
                case removePackage:
                    load.removePackages();
                    load.modifyDeliveryPage();
                    displayMenu = false;
                    break;
                case updatePackage:
                    load.updatePackage();
                    load.modifyDeliveryPage();
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

    Packages verifyPackage(){
        Pages load = new Pages();
        load.banner();
        Scanner read = new Scanner(System.in);
        System.out.println("Please Enter Package ID");
        String searchID = read.nextLine();
        Packages pkg = BinarySearch.search(searchID);
        if (pkg == null){
            load.modifyDeliveryPage();
        } else {
            return pkg;
        }
        return null;
    }

    void updatePackage(Packages updatePackage){
        Scanner scan = new Scanner(System.in);
        Pages load = new Pages();
        String userInput = scan.nextLine();
        Packages pkg = updatePackage;
        Boolean displayMenu = true;
        final String zone = "1";
        final String address = "2";
        final String priority = "3";
        final String weight = "4";
        final String status = "5";
        final String returnHomePage = "6";
        while (displayMenu.equals(true)) {
            switch (userInput) {
                case zone:
                    load.updateZone(pkg);
                    load.modifyDeliveryPage();
                    displayMenu = false;
                    break;
                case address:
                    load.updateAddress(pkg);
                    load.updatePackage();
                    displayMenu = false;
                    break;
                case priority:
                    load.updatePriority(pkg);
                    load.updatePackage();
                    displayMenu = false;
                    break;
                case weight:
                    load.updateWeight(pkg);
                    load.updatePackage();
                    displayMenu = false;
                    break;
                case status:
                    load.updateStatus(pkg);
                    load.updatePackage();
                    displayMenu = false;
                    break;
                case returnHomePage:
                    System.out.println("Returning to HomePage...");
                    displayMenu = false;
                    break;
                default:
                    System.out.println("Invalid Input Detected. Please Try Again...");
                    load.updatePackage();
                    displayMenu = false;
                    break;
            }
        }
    }

    ////////////////////////////////////////////////////////////////    MODIFICATION      ///////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////     MODIFICATION      ///////////////////////////////////////////////////////////////

    String getZoneInput(){
        Scanner read = new Scanner(System.in);
        System.out.println("Please Enter Zone (North, South, East, West)");
        return read.nextLine();
    }

    String getPriorityInput(){
        Scanner read = new Scanner(System.in);
        System.out.println("Please Enter Priority (1-5)");
        return read.nextLine();
    }

    Packages.Zone convertZone(String input) {
        if (input.equalsIgnoreCase("North")){
            return Packages.Zone.NORTH;
        }else if(input.equalsIgnoreCase("South")){
            return Packages.Zone.SOUTH;
        }else if(input.equalsIgnoreCase("East")){
            return Packages.Zone.EAST;
        }else if(input.equalsIgnoreCase("West")){
            return Packages.Zone.WEST;
        }else {
            System.out.println("Invalid Zone Detected. Please Try Again...");
            return convertZone(getZoneInput());
        }
    }

    Packages.Priority convertPriority(String input) {
        if (input.equals("1")){
            return Packages.Priority.LOW;
        }else if(input.equals("2")){
            return Packages.Priority.MEDIUM;
        }else if(input.equals("3")){
            return Packages.Priority.HIGH;
        }else if(input.equals("4")){
            return Packages.Priority.VERY_HIGH;
        } else if (input.equals("5")) {
            return Packages.Priority.EXTREMELY_HIGH;
        } else {
            System.out.println("Invalid Priority Detected. Please Try Again...");
            return convertPriority(getPriorityInput()) ;
        }
    }

    void addPackages(){
        Scanner read = new Scanner(System.in);
        Packages.Zone zone = convertZone(getZoneInput());
        Packages.Priority priority = convertPriority(getPriorityInput());
        System.out.println("Please Enter Address");
        String address = read.nextLine();
        System.out.println("Please Enter Weight");
        Double weight = read.nextDouble();
        Packages pkg = new Packages(zone,priority,address,weight);
        if (zone.equals(Packages.Zone.NORTH) || zone.equals(Packages.Zone.SOUTH) || zone.equals(Packages.Zone.EAST) || zone.equals(Packages.Zone.WEST)){
            assert priority != null;
            if (priority.getValue() >= 1 && priority.getValue() <= 5) {
                if (priority.getValue() <= 3) {
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

    void removePackages(Packages removePackage){
        ArrayList<Packages> storage = DataStorage.packagesArrayList;
        System.out.println("Original " + storage);
        for (int index = 0; index <= storage.size() - 1; index++) {
            Packages pkg = DataStorage.packagesArrayList.get(index);
            if (removePackage.equals(pkg)) {
                storage.remove(index);
            }
            System.out.println("Changed " + storage);
        }
        while(!DataStorage.packages.isEmpty()){
            DataStorage.packages.poll();
        }
        while (DataStorage.priorityPackages.isEmpty()){
            DataStorage.priorityPackages.poll();
        }
        for (int index = 0; index <= storage.size() - 1; index++){
            Packages pkg = storage.get(index);
            if(pkg.priority.getValue() <= 3){
                DataStorage.priorityPackages.offer(pkg);
            }else if (pkg.priority.getValue() >= 4 && pkg.priority.getValue() <= 5){
                DataStorage.packages.offer(pkg);
            }
        }
    }
    ////////////////////////////////////////////////////////////////    UPDATE      ///////////////////////////////////////////////////////////////

    void updateZone(Packages updatePackage){
        Packages.Zone zone = convertZone(getZoneInput());
        updatePackage.zone = zone;
        String replacement = "";
        switch (zone){
            case NORTH -> replacement = "N";
            case SOUTH -> replacement = "S";
            case EAST -> replacement = "E";
            case WEST -> replacement = "W";
        }
        updatePackage.packageID = updatePackage.packageID.substring(0,3) + replacement + updatePackage.packageID.substring(4);
    }

    void updateAddress(Packages updatePackage){
        Scanner read = new Scanner(System.in);
        System.out.println("Please Enter New Address");
        String address = read.nextLine();
        updatePackage.address = address;
    }

    void updatePriority(Packages updatePackage){
        Packages.Priority priority = convertPriority(getPriorityInput());
        updatePackage.priority = priority;
        String replacement = "";
        switch (priority){
            case LOW -> replacement = "5";
            case MEDIUM -> replacement = "4";
            case HIGH-> replacement = "3";
            case VERY_HIGH -> replacement = "2";
            case EXTREMELY_HIGH -> replacement = "1";
        }
        updatePackage.packageID = updatePackage.packageID.substring(0,4) + replacement + updatePackage.packageID.substring(6);
    }

    void updateWeight(Packages updatePackage){
        Scanner read = new Scanner(System.in);
        System.out.println("Please Enter New Weight");
        Double weight = read.nextDouble();
        updatePackage.weight = weight;
    }

    void updateStatus(Packages updatePackage){}

    ////////////////////////////////////////////////////////////////    QUERY      ///////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////     QUERY      ///////////////////////////////////////////////////////////////

    void searchPackages(String searchID){
        Packages packages = BinarySearch.search(searchID);
        if(packages == null){
            System.out.println("No Packages found please try again.");
        } else {
            System.out.println("Package ID: " +  packages.packageID);
            System.out.println("Priority: " + packages.priority);
            System.out.println("Zone: " + packages.zone);
            System.out.println("Address: " + packages.address);
            System.out.println("Weight: " + packages.weight);
        }
    }

    ////////////////////////////////////////////////////////////////    EXIT      ///////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////     EXIT      ///////////////////////////////////////////////////////////////

    // method, "exitMenu() handles the userInput required for terminating the program
    // method, "stopProgram()" in class, "userInterface" is set to Boolean...
    // ... in order to return and feed stopProgram command (stored as Boolean)
    boolean exitMenu(Boolean programStatus){
        String userInput = scan.nextLine();
        Pages load = new Pages();
        if (userInput.equals("Y") || userInput.equals("y")){
            // stopProgram() method stores a singular Boolean value of true...
            // ... which is then read, stored within variable, "stopProgram"...
            // ... and returned to the exitMenu method in Pages
            programStatus = UserInterface.stopProgram();
            return programStatus;
        }else if (userInput.equals("N") || userInput.equals("n")){
            load.homePage(programStatus);
        }else {
            System.out.println("Invalid Response Detected. Please Try Again");
            load.exitMenu(programStatus);
        }
        return programStatus;
    }
}
