package Evolution.Biotopes;

import Evolution.Creatures.BlinkerColony;
import Evolution.Creatures.ClockColony;

public class SampleBiotope01 extends CustomBiotope {

    public SampleBiotope01() {
        super();
        FName = "Sample01";
        FDescription = "Clocks & Blinker biotope";
        FColonies.add(new BlinkerColony(2.0, 2.0));
        FColonies.add(new BlinkerColony(10.0, 20.0));
        FColonies.add(new BlinkerColony(40.0, 40.0));
        FColonies.add(new ClockColony(40.0, 16.0));
        FColonies.add(new ClockColony(20.0, 66.0));
    }

}
