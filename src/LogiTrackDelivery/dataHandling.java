package LogiTrackDelivery;

import java.util.ArrayList;
import java.util.Random;

public class dataHandling {

    static String generatePackageID(String zone, Integer priority){

        //creates Package ID

        //need to implement uniqueness checker
        // IDEA: compare PackageID with those in Queue and rerun generator
        // if ID match with one already input.

        String packageID;
        packageID = "PKG";
        if (zone.equals("North")){
            packageID = packageID + "N";
        }else if(zone.equals("South")){
            packageID = packageID + "S";
        }else if (zone.equals("East")) {
            packageID = packageID + "E";
        }else if (zone.equals("West")){
            packageID = packageID + "W";
        }

        switch (priority){
            case 1:
                packageID = packageID + "1";
                break;
            case 2:
                packageID = packageID + "2";
                break;
            case 3:
                packageID = packageID + "3";
                break;
            case 4:
                packageID = packageID + "4";
                break;
            case 5:
                packageID = packageID + "5";
                break;
        }


        Random randomize = new Random();
        Integer randomNumber = randomize.nextInt(1000);
        String number = randomNumber.toString();
        packageID = packageID + number;
        return packageID;
    }

    void viewPackage(){
        if (!DataStorage.priorityPackages.isEmpty() || !DataStorage.packages.isEmpty()) {
            while (!DataStorage.priorityPackages.isEmpty()) {
                Packages pkg = DataStorage.priorityPackages.poll();
                System.out.println("PackageID: " + pkg.packageID);
                System.out.println("Weight: " + pkg.weight);
                System.out.println("Zone"  + pkg.zone);
                System.out.println("Address: " + pkg.address);
                System.out.println("Priority: " + pkg.priority + " (High)");
            }
            while (!DataStorage.packages.isEmpty()) {
                Packages pkg = DataStorage.packages.poll();
                System.out.println("PackageID: " + pkg.packageID);
                System.out.println("Weight: " + pkg.weight);
                System.out.println("Zone"  + pkg.zone);
                System.out.println("Address: " + pkg.address);
                System.out.println("Priority: " + pkg.priority);
            }
        }else if(DataStorage.packages.isEmpty() && DataStorage.priorityPackages.isEmpty()){
            System.out.println("No Packages Found. Please Try Again");
        }
    }

    // Creates and Array and sorts all items using Bubble Sort
    void sortPackage(){
        ArrayList<Packages>  packagesArrayList = new ArrayList<>();
        if (!DataStorage.packages.isEmpty() || !DataStorage.priorityPackages.isEmpty()) {
            while (!DataStorage.priorityPackages.isEmpty()) {
                Packages priorityPackages = Backups.loadPriorityBackUp();
                packagesArrayList.add(priorityPackages);
                }
            while (!DataStorage.packages.isEmpty()){
                Packages packages = Backups.loadBackup();
                packagesArrayList.add(packages);
            }
            //reloads priority queue and queue after dumping packages
            // sorts arraylist using bubble-sort.
            int arrayListSize = packagesArrayList.size();
            Packages placeHolder;

            for (int i = 0; i < arrayListSize - 1 ; i++) {
                for (int j = 0; j < arrayListSize - i - 1; j++) {
                    Packages indexPackage = packagesArrayList.get(j);
                    Packages comparePackage = packagesArrayList.get((j + 1));
                    if (indexPackage.priority > comparePackage.priority) {
                        placeHolder = indexPackage;
                        packagesArrayList.set(j, comparePackage);
                        packagesArrayList.set((j + 1), placeHolder);
                    }
                }
            }
            // Printing sorted List
            int i = 0;
            System.out.println("--Package ID--  --Priority--  --Zone--  --Weight--  ----Address----");
            while(i < arrayListSize){
                Packages packages = packagesArrayList.get(i);
                System.out.println(packages.packageID + "\t" + packages.priority + "\t" + packages.zone + "\t" + packages.weight + "\t" + packages.address);
                i++;
            }
        }else {
            System.out.println("Insufficient Packages found in directory for Sorting. Please Try Again");
        }

    Backups.reloadPriorityBackUp();
    Backups.reloadBackup();
    }


    void reloadQueue(){
        //
    }
    void reloadPriorityQueue(){
        //
    }
}
