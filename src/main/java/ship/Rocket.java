package ship;

import java.util.ArrayList;

public class Rocket {

    private double coordinate = 0;
    private double speed;
    private double totalMass;
    ArrayList<RocketStage> rocketStages;
    RocketBrakeStage brake;

    public Rocket(ArrayList<RocketStage> rocketStages, RocketBrakeStage rocketBrakeStage) {
        this.rocketStages = rocketStages;
        this.brake = rocketBrakeStage;
    }

    public Rocket() {
        super();
    }

    public Rocket(ArrayList<RocketStage> rocketStages) {
        this.rocketStages = rocketStages;
    }

    public class RocketStage implements ship.RocketStage {
        private static int seq = 1;
        private double num;
        private double mass;
        private double fuelMass;
        private double speedGas;
        private int workTime;
        private double fuelConsumptionSpeed;

        public double getSpeedGas() {
            return speedGas;
        }

        public double getFuelConsumptionSpeed() {
            return fuelConsumptionSpeed;
        }

        public RocketStage(double mass, double fuelMass, int workTime, double speedGas, double fuelConsumptionSpeed) {
            this.num = seq++;
            this.mass = mass;
            this.speedGas = speedGas;
            this.fuelMass = fuelMass;
            this.workTime = workTime;
            this.fuelConsumptionSpeed = fuelConsumptionSpeed;
            //Добавление в массив текущей ступени
            rocketStages.add(this);
        }
        public double getAllMass() {
            return this.mass + this.fuelMass;
        }
        public void minusTime(double minusTime) {
            this.workTime -= minusTime;
        }
        public int getRemainingTime() {
            return workTime;
        }
        @Override
        public void launch() {
            System.out.println("Ступень #" + this.num + " запущена");
        }
    }
    public class RocketBrakeStage implements ship.RocketStage {
        private double mass;
        private double fuelMass;
        private double speedGas;
        private double fuelConsumptionSpeed;

        public RocketBrakeStage(double mass, double fuelMass, double speedGas, double fuelConsumptionSpeed) {
            this.mass = mass;
            this.fuelMass = fuelMass;
            this.speedGas = speedGas;
            this.fuelConsumptionSpeed = fuelConsumptionSpeed;

            brake = this;
        }

        public double getAllMass() {
            return this.mass + this.fuelMass;
        }
        @Override
        public void launch() {
            System.out.println("Тормозной блок запущен");
        }
    }

    public double getAllMass() {
        double sum = 0;
        for (RocketStage rocketStage : this.rocketStages) {
            sum += rocketStage.getAllMass();
        }
        sum += this.brake.getAllMass();

        return sum;
    }

    public RocketStage getNextRocketStage() {
        if (!this.rocketStages.isEmpty()) {
            return this.rocketStages.get(0);
        }
        else return null;
    }

    public double getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(double coordinate) {
        this.coordinate = coordinate;
    }
    public void deleteRocketStage() {
        rocketStages.remove(0);
    }
}
