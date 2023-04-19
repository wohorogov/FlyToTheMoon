package ship;

import java.util.ArrayList;

public class Rocket {
    private double coordinate = 0;
    ArrayList<ship.RocketStage> rocketStages;
    public class RocketStage implements ship.RocketStage {
        private double mass;
        private double speed;
        private double acceleration;
        RocketStage(double mass, double acceleration) {
            this.mass = mass;
            this.acceleration = acceleration;
        }
        @Override
        public void launch() {

        }
    }
    public class RocketBrakeStage {

    }


}
