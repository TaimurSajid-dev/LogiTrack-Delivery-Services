package LogiTrackDelivery;

import java.util.Random;

public class PackageIDs {
    static String generatePackageID(Packages.Zone zone, Packages.Priority priority) {

        //need to implement uniqueness checker
        // IDEA: compare PackageID with those in Queue and rerun generator
        // if ID match with one already input
        String packageID;
        packageID = "PKG";
        if (zone.equals(Packages.Zone.NORTH)) {
            packageID = packageID + "N";
        } else if (zone.equals(Packages.Zone.SOUTH)) {
            packageID = packageID + "S";
        } else if (zone.equals(Packages.Zone.EAST)) {
            packageID = packageID + "E";
        } else if (zone.equals(Packages.Zone.WEST)) {
            packageID = packageID + "W";
        }
        packageID = packageID + priority.getValue();
        Random randomize = new Random();
        Integer randomNumber = randomize.nextInt(900) + 100;
        String number = randomNumber.toString();
        packageID = packageID + number;
        Boolean checkUnique = checkUniqueID(packageID);
        if (checkUnique == true) {
            return packageID;
        }else {
            generatePackageID(zone, priority);
        }
        return packageID;
    }

    static Boolean checkUniqueID(String packageID) {
        String checkID = packageID;
        Integer passesTotal = DataStorage.packagesArrayList.size() - 1;
        Integer pass;
        Boolean isUnique = true;
        for (pass = 0; pass <= passesTotal; pass++){
            Packages pkg = DataStorage.packagesArrayList.get(pass);
            String packagesID = pkg.packageID;
            if (checkID.equals(packagesID)) {
                isUnique = false;
            }
        }
        return isUnique;
    }
}
