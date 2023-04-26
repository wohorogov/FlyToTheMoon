package fly;

import ship.Rocket;

public class Flying {
    private static final double EARTH_MASS =  5.9722 * 10e24;
    private static final double MOON_MASS =  EARTH_MASS * 0.0123;
    private static final double EARTH_RADIUS = 6371.3;
    private static final double MOON_RADIUS = EARTH_RADIUS * 0.273;
    private static final double GRAVITIONAL_CONSTANT =  6.67430 * Math.pow(10, -11);
    private static final double FINAL_COORDINATE = 350_000;
    public void startFly(Rocket rocket) {
        boolean stop = false;
        Rocket.RocketStage rocketStage = rocket.getNextRocketStage();
        while (!stop) {
            double allMass = rocket.getAllMass();
            double coordinate = rocket.getCoordinate();
            double forceOfGravitationEarth = getEarthGravitation(allMass, coordinate);
            double forceOfGravitationMoon = getEarthGravitation(allMass, coordinate);
            double reactivePower = getReactivePower(rocketStage);
            double boostNow = (forceOfGravitationMoon - forceOfGravitationEarth + reactivePower) / allMass;
             
        }
    }
    public double getEarthGravitation(double mass, double distance) {
        return GRAVITIONAL_CONSTANT * EARTH_MASS * mass / Math.pow(distance, 2);
    }

    public double getMoonGravitation(double mass, double distance) {
        return GRAVITIONAL_CONSTANT * MOON_MASS * mass / Math.pow(distance, 2);
    }

    public double getReactivePower(Rocket.RocketStage rocketStage) {
        return rocketStage.getSpeedGas() * rocketStage.getFuelCombutionSpeed();
    }
}
