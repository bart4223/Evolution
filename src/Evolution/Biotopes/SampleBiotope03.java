package Evolution.Biotopes;

import Evolution.Creatures.*;

public class SampleBiotope03 extends CustomBiotope {

    public SampleBiotope03() {
        super();
        FName = "Sample03";
        FColonies.add(new BipoleColony(3.0, 1.0));
        FColonies.add(new TripoleColony(25.0, 5.0));
        FColonies.add(new BlinkerColony(5.0, 14.0));
        FColonies.add(new ToadColony(35.0, 20.0));
        FColonies.add(new PulsatorColony(10.0, 8.0));
        FColonies.add(new PorpoiseColony(14.0, 25.0));
    }

}
