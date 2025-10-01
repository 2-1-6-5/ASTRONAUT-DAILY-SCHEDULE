public class TurnOnCommand implements Command {
    private Light light; // Reference to the receiver

    public TurnOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}