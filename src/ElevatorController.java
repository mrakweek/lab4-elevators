import java.util.LinkedList;
import java.util.Queue;

class ElevatorController implements Runnable {
    private Building building;
    private Queue<Integer> requests = new LinkedList<>();
    private final Object lock = new Object();

    public ElevatorController(Building building) {
        this.building = building;
    }

    public void addRequest(int targetFloor) {
        synchronized (lock) {
            requests.add(targetFloor);
        }
    }

    public Queue<Integer> getRequests(){
        return requests;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (requests.size() > 0) {
                    System.out.println("флаг 3 ");
                    int targetFloor = requests.poll();
                    int minDistance = Integer.MAX_VALUE;
                    int selectedElevator = -1;

                    for (Elevator elevator : building.getElevators()) {
                        int distance = Math.abs(elevator.getCurrentFloor() - targetFloor);
                        if (distance < minDistance) {
                            minDistance = distance;
                            selectedElevator = elevator.getId();
                        }
                    }
                    building.moveElevator(selectedElevator, targetFloor);
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}