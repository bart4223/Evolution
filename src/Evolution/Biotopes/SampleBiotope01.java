package Evolution.Biotopes;

import Evolution.Creatures.BlinkerColony;
import Evolution.Creatures.ClockColony;

public class SampleBiotope01 extends CustomBiotope {

    public SampleBiotope01() {
        super();
        FName = "Sample01";
        FColonies.add(new BlinkerColony(1.0, 1.0));
        FColonies.add(new BlinkerColony(5.0, 10.0));
        FColonies.add(new BlinkerColony(20.0, 20.0));
        FColonies.add(new ClockColony(20.0, 8.0));
        FColonies.add(new ClockColony(30.0, 33.0));
    }

}
