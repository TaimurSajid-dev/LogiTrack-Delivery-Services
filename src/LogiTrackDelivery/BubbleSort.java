package LogiTrackDelivery;

import static LogiTrackDelivery.DataStorage.packagesArrayList;

public class BubbleSort {
    // Creates and Array and sorts all items using Bubble Sort
    static void sort() {
        packagesArrayList.clear();
        if (!DataStorage.packages.isEmpty() || !DataStorage.priorityPackages.isEmpty()) {
            while (!DataStorage.priorityPackages.isEmpty()) {
                Packages priorityPackages = Backups.loadPriorityBackUp();
                packagesArrayList.add(priorityPackages);
            }
            while (!DataStorage.packages.isEmpty()) {
                Packages packages = Backups.loadBackup();
                packagesArrayList.add(packages);
            }
            //reloads priority queue and queue after dumping packages
            // sorts arraylist using bubble-sort.
            int arrayListSize = packagesArrayList.size();
            Packages placeHolder;
            //outer loop makes sure it passes through all values present within the list
            for (int pass = 0; pass < arrayListSize - 1; pass++) {
                //inner loop compares the value found within the index and compares it to the value...
                //... found next to the index.
                for (int index = 0; index < arrayListSize - pass - 1; index++) {
                    Packages indexPackage = packagesArrayList.get(index);
                    Packages comparePackage = packagesArrayList.get((index + 1));
                    if (indexPackage.priority.getValue() > comparePackage.priority.getValue()) {
                        placeHolder = indexPackage;
                        packagesArrayList.set(index, comparePackage);
                        packagesArrayList.set((index + 1), placeHolder);
                    }
                }
            }
        } else {
            System.out.println("Insufficient Packages found in directory for Sorting. Please Try Again");
        }
    Backups.reloadBackup();
    Backups.reloadPriorityBackUp();
    }
}
