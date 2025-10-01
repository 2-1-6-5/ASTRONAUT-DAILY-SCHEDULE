public class Director {
    
    // The Director knows common construction routines.
    public void constructSportsCar(CarBuilderInterface builder) {
        builder.setBrand("Bugatti")
               .setModel("Chiron")
               .setColor("Blue")
               .setDoors(2);
    }

    public void constructEconomyCar(CarBuilderInterface builder) {
        builder.setBrand("Toyota")
               .setModel("Yaris")
               .setColor("Red")
               .setDoors(4);
    }
}