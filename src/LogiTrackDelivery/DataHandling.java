package LogiTrackDelivery;

public class DataHandling {

    void viewPackage() {
        String divide = "---------------------------------------------------------------";
        if (!DataStorage.priorityPackages.isEmpty() || !DataStorage.packages.isEmpty()) {
            while (!DataStorage.priorityPackages.isEmpty()) {
                Packages pkg = Backups.loadPriorityBackUp();
                System.out.println(divide);
                System.out.println("PackageID: " + pkg.packageID);
                System.out.println("Weight: " + pkg.weight);
                System.out.println("Zone: " + pkg.zone);
                System.out.println("Address: " + pkg.address);
                System.out.println("Priority: " + pkg.priority.getValue());
            }
            while(!DataStorage.packages.isEmpty()){
                Packages pkg = Backups.loadBackup();
                System.out.println(divide);
                System.out.println("PackageID: " + pkg.packageID);
                System.out.println("Weight: " + pkg.weight);
                System.out.println("Zone: " + pkg.zone);
                System.out.println("Address: " + pkg.address);
                System.out.println("Priority: " + pkg.priority.getValue());
            }
        }
        else if (DataStorage.packages.isEmpty() && DataStorage.priorityPackages.isEmpty()) {
            System.out.println("No Packages Found. Please Try Again");
        }
        Backups.reloadPriorityBackUp();
        Backups.reloadBackup();
    }

}
