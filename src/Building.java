class Building {
    private int totalFloors;
    private Elevator[] elevators;
    private ElevatorController elevatorController;

    public Building(int totalFloors, int numElevators) {
        this.totalFloors = totalFloors;
        elevators = new Elevator[numElevators];
        for (int i = 0; i < numElevators; i++) {
            elevators[i] = new Elevator(i + 1);
        }
        elevatorController = new ElevatorController(this);
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    public Elevator[] getElevators() {
        return elevators;
    }

    public ElevatorController getElevatorController() {
        return elevatorController;
    }

    public void moveElevator(int elevatorId, int targetFloor) {
        elevators[elevatorId].move(targetFloor);
    }
}