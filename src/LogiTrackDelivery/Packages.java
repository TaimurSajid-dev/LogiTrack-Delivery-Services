package LogiTrackDelivery;

// Priority Queue requires its objects to be comparable...
// using implements Comparable<object> and @Override to make...
// the priority attribute a comparable value within the package...
// object, we are priming our packages to be stored within...
// a priority queue
public class Packages implements Comparable<Packages> {

    public enum Zone {
        NORTH,
        SOUTH,
        EAST,
        WEST;
    }

    public enum Priority {
        LOW(1),
        MEDIUM(2),
        HIGH(3),
        VERY_HIGH(4),
        EXTREMELY_HIGH(5);


        private final Integer value;

        Priority (Integer value){
            this.value = value;
        }
        public Integer getValue(){
            return value;
        }
    }

    Zone zone;
    Priority priority;
    String address;
    Double weight;
    String packageID;

    // constructor to create new instances of Packages that
    // returns the string Package ID to be stored
    public Packages(Zone zone, Priority priority, String address, Double weight){
        this.zone = zone;
        this.priority = priority;
        this.address = address;
        this.weight = weight;
        this.packageID = PackageIDs.generatePackageID(zone, priority);
        }

    public int compareTo(Packages other) {
        return Integer.compare(this.priority.getValue(),other.priority.getValue());
    }
}