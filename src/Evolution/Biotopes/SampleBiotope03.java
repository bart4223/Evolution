package Evolution.Biotopes;

import Evolution.Creatures.*;

public class SampleBiotope03 extends CustomBiotope {

    public SampleBiotope03() {
        super();
        FName = "Sample03";
        FDescription = "Bipole, Tripole, Pulsator & Porpoise biotope";
        FColonies.add(new BipoleColony(6.0, 2.0));
        FColonies.add(new TripoleColony(50.0, 10.0));
        FColonies.add(new BlinkerColony(10.0, 28.0));
        FColonies.add(new ToadColony(70.0, 30.0));
        FColonies.add(new PulsatorColony(20.0, 16.0));
        FColonies.add(new PorpoiseColony(28.0, 50.0));
    }

}
