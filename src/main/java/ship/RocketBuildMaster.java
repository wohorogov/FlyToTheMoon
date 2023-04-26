package ship;

import java.util.ArrayList;

public class RocketBuildMaster implements RocketBuilder{
    ArrayList<RocketStage> rocketStages;

    @Override
    public RocketBuilder addStage() {
        return null;
    }

    @Override
    public RocketBuilder addStage(RocketStage rocketStage) {
        rocketStages.add(rocketStage);
        return this;
    }

    @Override
    public RocketBuilder addBrakeBlock() {
        return null;
    }

    @Override
    public RocketBuilder addMoonWalker() {
        return null;
    }

    @Override
    public Rocket build() {
        return null;
    }
}
