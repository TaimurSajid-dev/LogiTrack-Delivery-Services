package LogiTrackDelivery;


// userInterface is used to load the userInterface.
public class userInterface {


    //
    Pages load = new Pages();

    void launchProgram() {
        Boolean stopProgram = false;
        while (stopProgram.equals(false)) {
            stopProgram = load.homePage();
        }
    }

    // terminates the program
    boolean stopProgram() {
        return true;
    }
}