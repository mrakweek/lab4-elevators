import java.util.Random;


class CallGenerator implements Runnable {
    private Building building;
    private Random random = new Random();

    public CallGenerator(Building building) {
        this.building = building;
    }


    @Override
    public void run() {
        while (true) {
            int targetFloor = random.nextInt(building.getTotalFloors()) + 1;
            building.getElevatorController().addRequest(targetFloor);
            System.out.println("Сигнал вызова лифта на этаж " + targetFloor);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
