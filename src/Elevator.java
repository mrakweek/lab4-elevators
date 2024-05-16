class Elevator {
    private int id;
    private int currentFloor;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 1;
    }

    public void move(int targetFloor) {
        System.out.println("Лифт " + id + " движется с этажа " + currentFloor + " на этаж " + targetFloor);
        currentFloor = targetFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getId() {
        return id;
    }
}