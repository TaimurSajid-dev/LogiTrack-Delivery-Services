package LogiTrackDelivery;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DataStorage {
    static Queue<Packages> packages = new LinkedList<>();
    static PriorityQueue<Packages> priorityPackages = new PriorityQueue<>();
    static HashMap<String,String> address = new HashMap<>();

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
