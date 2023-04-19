package ship;

public interface RocketBuilder {
    RocketBuilder addStage()
    RocketBuilder addBrakeBlock();
    RocketBuilder addMoonWalker();
    Rocket build();
}
