package LogiTrackDelivery;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DataStorage {
    static Queue<Packages> packages = new LinkedList<>();
    static PriorityQueue<Packages> priorityPackages = new PriorityQueue<>();
    static HashMap<String,String> address = new HashMap<>();

    static void loadTestPackages(){
        Packages test1 = new Packages(Packages.Zone.NORTH, Packages.Priority.EXTREMELY_HIGH, "123, North Avenue", 15.0);
        addPriorityPackage(test1);
        Packages test2 = new Packages(Packages.Zone.NORTH, Packages.Priority.VERY_HIGH, "345, North-Side Street", 25.0);
        addPriorityPackage(test2);
        Packages test3 = new Packages(Packages.Zone.SOUTH, Packages.Priority.HIGH, "121, South Avenue", 35.0);
        addPriorityPackage(test3);
        Packages test4 = new Packages(Packages.Zone.EAST, Packages.Priority.MEDIUM, "121, East Avenue", 45.0);
        addPackage(test4);
        Packages test5 = new Packages(Packages.Zone.WEST, Packages.Priority.LOW, "121, West Boulevard", 55.0);
        addPackage(test5);
    }



    static void addPackage(Packages pkg) {
        Packages delivery = pkg;
        packages.add(delivery);

    }
    static void addPriorityPackage(Packages pkg){
        Packages delivery = pkg;
        priorityPackages.add(delivery);
    }
    void addDeliveryStatus(){
        //
    }
}
