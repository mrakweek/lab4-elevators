public class Main {
    public static void main(String[] args) {
        int numElevators = 2;
        int totalFloors = 10;


        Building building = new Building(totalFloors, numElevators);

        CallGenerator callGenerator = new CallGenerator(building);
        Thread generatorThread = new Thread(callGenerator);
        generatorThread.start();

        ElevatorController controller = new ElevatorController(building);
        Thread controllerThread = new Thread(controller);
        controllerThread.start();
    }
}