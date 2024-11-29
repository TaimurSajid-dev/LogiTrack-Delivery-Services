package LogiTrackDelivery;
import java.util.*;
// Priority Queue requires its objects to be comparable...
// using implements Comparable<object> and @Override to make...
// the priority attribute a comparable value within the package...
// object, we are priming our packages to be stored within...
// a priority queue
public class Packages implements Comparable<Packages> {

    String zone;
    Integer priority;
    String address;
    Double weight;
    String packageID;

    // constructor to create new instances of Packages that
    // returns the string Package ID to be stored
    public Packages(String zone, Integer priority, String address, Double weight){
        this.zone = zone;
        this.priority = priority;
        this.address = address;
        this.weight = weight;
        this.packageID = dataHandling.generatePackageID(zone, priority);
        }



    public int compareTo(Packages other){
        return Integer.compare(this.priority,other.priority);
    }
}