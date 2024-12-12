package LogiTrackDelivery;




public class BinarySearch {


    static Packages search(String searchID){
    //Binary Search depends on a sorted collection since it's a
    //sequential search algorithm.

        BubbleSort.sort();
        int tail = DataStorage.packagesArrayList.size();
        int head = 0;
        Packages foundPackage = null;
        while(head <= tail){
            int mid = (tail + head)/2;
            Packages midPackage = DataStorage.packagesArrayList.get(mid);
            String midPackageID = midPackage.packageID;
            Boolean match = searchID.equals(midPackageID);
            if (match == true){
                foundPackage = midPackage;
                Backups.reloadPriorityBackUp();
                Backups.reloadBackup();
                return foundPackage;
        // compare to compares the two strings alphabetically and
        // returns an integer value either positive (if greater)
        // negative (if lesser) or 0 if equal.
            }else if (searchID.compareTo(midPackageID) > 0 ){
                tail = mid - 1;
            } else if (searchID.compareTo(midPackageID) < 0){
                head = mid + 1;
            }
        }
        Backups.reloadPriorityBackUp();
        Backups.reloadBackup();
        return null;
    }
}

