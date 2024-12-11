package LogiTrackDelivery;


import javax.xml.crypto.Data;

public class BinarySearch {


    static Packages search(String searchID){
    //Binary Search depends on a sorted collection since it's a
    //sequential search algorithm.

        BubbleSort.sort();
        int tail = BubbleSort.packagesArrayList.size();
        int head = 0;
        while(head <= tail){
            int mid = (tail + head)/2;
            Packages midPackage = BubbleSort.packagesArrayList.get(mid);
            String midPackageID = midPackage.packageID;
            if (searchID.equals(midPackageID)){
                return midPackage;
        // compare to compares the two strings alphabetically and
        // returns an integer value either positive (if greater)
        // negative (if lesser) or 0 if equal.
        // since we are not using a
            }else if (searchID.compareTo(midPackageID) > 0 ){
                tail = mid - 1;
            } else if (searchID.compareTo(midPackageID) < 0){
                head = mid + 1;
            }
        }
        return null;
    }
}

