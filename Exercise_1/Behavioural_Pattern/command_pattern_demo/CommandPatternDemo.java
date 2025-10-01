public class CommandPatternDemo {
    public static void main(String[] args) {
        // Receivers
        Light kitchenLight = new Light("Kitchen");
        Light livingRoomLight = new Light("Living Room");
        
        // Concrete Commands
        Command kitchenOn = new TurnOnCommand(kitchenLight);
        Command livingRoomOff = new TurnOffCommand(livingRoomLight);

        // Invoker
        RemoteControl remote = new RemoteControl();

        // 1. Use the remote for the Kitchen light
        System.out.println("--- Scenario 1: Turn Kitchen Light On ---");
        remote.setCommand(kitchenOn);
        remote.pressButton(); 

        // 2. Change the command slot for the Living Room light
        System.out.println("\n--- Scenario 2: Turn Living Room Light Off ---");
        remote.setCommand(livingRoomOff);
        remote.pressButton(); 
    }
}