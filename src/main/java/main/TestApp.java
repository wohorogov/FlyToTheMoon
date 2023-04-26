package main;

import fly.Flying;
import ship.Rocket;
import ship.RocketStage;

import java.util.ArrayList;

public class TestApp {
    public void action() {
        Rocket rocket = new Rocket();
        Rocket.RocketStage rocketStage1 = rocket.new RocketStage(30_000, 430_000, 120, 2.8, 3600);
        Rocket.RocketStage rocketStage2 = rocket.new RocketStage(11_000, 167_000, 211, 3, 800);
        Rocket.RocketStage rocketStage3 = rocket.new RocketStage(43_000, 43_000, 240, 3.25, 180);

        Rocket.RocketBrakeStage rocketBrakeStage = rocket.new RocketBrakeStage(600, 300, 3, 30);
        Flying flying = new Flying();
        flying.startFly(rocket);
    }
}
