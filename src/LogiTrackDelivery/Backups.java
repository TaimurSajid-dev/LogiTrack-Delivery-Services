package LogiTrackDelivery;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Backups {
    static Queue<Packages> packageBackUp = new LinkedList<>();
    static PriorityQueue<Packages> priorityBackUp = new PriorityQueue<>();
    static ArrayList<Packages> deepCopy = new ArrayList<>();

    //Creating a getter method for safe
    static Packages loadBackup() {
        Packages packages = DataStorage.packages.poll();
        packageBackUp.add(packages);
        deepCopy.add(packages);
        return packages;
    }

    static Packages loadPriorityBackUp() {
        Packages packages = DataStorage.priorityPackages.poll();
        priorityBackUp.add(packages);
        deepCopy.add(packages);
        return packages;
    }

    public static void reloadBackup() {
        while(!packageBackUp.isEmpty()){
            DataStorage.packages.add(packageBackUp.poll());
        }
    }

    public static void reloadPriorityBackUp() {
        while (!priorityBackUp.isEmpty()){
            DataStorage.priorityPackages.offer(priorityBackUp.poll());
        }
    }
}
