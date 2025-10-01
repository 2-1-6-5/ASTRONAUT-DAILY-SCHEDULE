public class TurnOffCommand implements Command {
    private Light light; // Reference to the receiver

    public TurnOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}