package LogiTrackDelivery;
import static LogiTrackDelivery.DataStorage.packagesArrayList;

public class DataHandling {

    void viewPackage() {
        packagesArrayList.clear();
        String divide = " ------ ";
        if (!DataStorage.priorityPackages.isEmpty() || !DataStorage.packages.isEmpty()) {
            while (!DataStorage.packages.isEmpty()){
                Packages pkg = Backups.loadBackup();
                packagesArrayList.add(pkg);
            }
            while (!DataStorage.priorityPackages.isEmpty()){
                Packages pkg = Backups.loadPriorityBackUp();
                packagesArrayList.add(pkg);
            }
            System.out.println("PackageID----Priority----Zone-------------Address------------Weight");
            for (int i = 0 ; i <= packagesArrayList.size() - 1 ; i++){
                Packages pkg = packagesArrayList.get(i);
                System.out.println(pkg.packageID + divide + pkg.priority.getValue() + divide + pkg.zone + divide + pkg.address + divide + pkg.weight);
            }
        } else if (DataStorage.packages.isEmpty() && DataStorage.priorityPackages.isEmpty()) {
            System.out.println("No Packages Found. Please Try Again");
        }
        Backups.reloadPriorityBackUp();
        Backups.reloadBackup();
    }
}
