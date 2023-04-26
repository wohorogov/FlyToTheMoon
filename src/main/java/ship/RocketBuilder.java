package ship;

public interface RocketBuilder {
    RocketBuilder addStage();

    RocketBuilder addStage(RocketStage rocketStage);

    RocketBuilder addBrakeBlock();
    RocketBuilder addMoonWalker();
    Rocket build();
}
