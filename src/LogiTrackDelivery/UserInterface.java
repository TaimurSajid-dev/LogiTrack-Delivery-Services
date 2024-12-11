package LogiTrackDelivery;


// userInterface is used to load the userInterface.
public class UserInterface {



    Pages load = new Pages();

    void launchProgram() {
        Boolean stopProgram = false;
        DataStorage.loadTestPackages();
        while (stopProgram.equals(false)) {
            stopProgram = load.homePage(stopProgram);
        }
    }

    // stopProgram changes it's value when homepage interacts with it returns a boolean value that then changes the value of stopProgram
    // if the new changed value is false program stops



    // terminates the program
    static boolean stopProgram() {
        return true;
    }
}