package LogiTrackDelivery;

import java.util.Scanner;

public class Pages {


    // banner() allows for easy deployment of the LogiTrack Banner to pages that require it and eliminates redundant code.
    void banner(){
        System.out.println("------------------------- LogiTrack Delivery Services -------------------------");
        System.out.println("Please Select one from the following options:");
    }

    ////////////////////////////////////////////////////////////////    MENU      ///////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////     MENU      ///////////////////////////////////////////////////////////////

    // homePage() creates the homepage for
    boolean homePage(Boolean programStatus) {
        // instantiate class in method to avoid StackOverflowError
        UserIO handleIO = new UserIO();
        banner();
        System.out.println("1. Query");
        System.out.println("2. Modification");
        System.out.println("3. Exit Program");
        // Variable "stopProgram" reads and stores the returned boolean value
        // ... from the method, "homePage()" found within the class, "Pages"....
        // ... ultimately returning it to method, "launchProgram()" in class, "userInterface"
        boolean stopProgram = handleIO.homepage(programStatus);
        return stopProgram;
    }

    void viewDeliveryPage() {
        // instantiating class in method to avoid StackOverflowError
        UserIO handle = new UserIO();
        banner();
        System.out.println("1. Sort Package List");
        System.out.println("2. View Package List");
        System.out.println("3. Search Package by ID");
        System.out.println("4. Return to Home Screen");
        handle.viewDelivery();
    }

    void modifyDeliveryPage(){
        // instantiating class in method to avoid StackOverflowError
        UserIO handle = new UserIO();
        banner();
        System.out.println("1. Add New Package");
        System.out.println("2. Remove Package");
        System.out.println("3. Update Package Information");
        System.out.println("4. Return to Home Screen");
        handle.modifyPackages();
    }

    void updatePackage() {
        UserIO handle = new UserIO();
        Packages pkg = handle.verifyPackage();
        if ( pkg == null){
            System.out.println("This package doesn't exist...");
        }else {
            banner();
            System.out.println("1. Update Zone");
            System.out.println("2. Update Address");
            System.out.println("3. Update Priority");
            System.out.println("4. Update Weight");
            System.out.println("5. Update Status");
            System.out.println("6. Return to Menu");
            handle.updatePackage(pkg);
        }
    }

    ////////////////////////////////////////////////////////////////    QUERY      ///////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////     QUERY      ///////////////////////////////////////////////////////////////


    void sortDelivery(){
        String divide =  " ------ ";
        viewDelivery();
        BubbleSort.sort();
        int listSize = DataStorage.packagesArrayList.size();
        System.out.println("PackageID----Priority----Zone-------------Address------------Weight");
        for (int i = 0; i <= listSize - 1; i++){
            Packages pkg = DataStorage.packagesArrayList.get(i);
            System.out.println(pkg.packageID + divide + pkg.priority.getValue() + divide + pkg.zone + divide + pkg.address + divide + pkg.weight);
        }
    Backups.reloadPriorityBackUp();
    Backups.reloadBackup();
    }

    void viewDelivery(){
        DataHandling handle = new DataHandling();
        handle.viewPackage();
    }

    void searchPackages(){
        banner();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter PackageID of Package: ");
        String searchID = scan.nextLine();
        UserIO handle = new UserIO();
        handle.searchPackages(searchID);
    }

    ////////////////////////////////////////////////////////////////    MODIFICATION      ///////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////     MODIFICATION      ///////////////////////////////////////////////////////////////

    void addPackages(){
        UserIO handle = new UserIO();
        handle.addPackages();
    }

    void removePackages() {
        UserIO handle = new UserIO();
        Packages pkg = handle.verifyPackage();
        if (pkg != null) {
            handle.removePackages(pkg);
        } else {
            System.out.println("This package doesn't exist");
        }
    }


    void updateZone(Packages updatePackage){
        banner();
        UserIO handle = new UserIO();
        handle.updateZone(updatePackage);
    }

    void updateAddress(Packages updatePackage){
        banner();
        UserIO handle = new UserIO();
        handle.updateAddress(updatePackage);

    }

    void updatePriority(Packages updatePackage){
        banner();
        UserIO handle = new UserIO();
        handle.updatePriority(updatePackage);
    }

    void updateWeight(Packages updatePackage){
        banner();
        UserIO handle = new UserIO();
        handle.updateWeight(updatePackage);
    }

    void updateStatus(Packages updatePackage){
        banner();
        UserIO handle = new UserIO();
        handle.updateStatus(updatePackage);
    }

    ////////////////////////////////////////////////////////////////    EXIT      ///////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////     EXIT      ///////////////////////////////////////////////////////////////

    // generates the exit menu for terminating the program.
    boolean exitMenu(Boolean programStatus) {
        //instantiating class in method to avoid StackOverflowError
        UserIO handle = new UserIO();
        System.out.println("Would you like to exit the program? (Y/N)");
        // stopProgram reads and stores the boolean value returned...
        // ... from the method, "exitMenu()" in Class "userInterface"...
        // ... which is then ultimately returned to homePage() method in class UserIO
        Boolean stopProgram = handle.exitMenu(programStatus);
        if (stopProgram.equals(true)){
            System.out.println("Thank you for Using LogiTrack Delivery Services");
        }
    return stopProgram;
    }
}
