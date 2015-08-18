package Evolution.Biotopes;

import Evolution.Creatures.BlinkerColony;
import Evolution.Creatures.ClockColony;
import Evolution.Creatures.ToadColony;

public class SampleBiotope02 extends CustomBiotope {

    public SampleBiotope02() {
        super();
        FName = "Sample02";
        FColonies.add(new BlinkerColony(3.0, 3.0));
        FColonies.add(new BlinkerColony(6.0, 22.0));
        FColonies.add(new ToadColony(18.0, 12.0));
        FColonies.add(new ClockColony(30.0, 7.0));
        FColonies.add(new ClockColony(20.0, 31.0));
    }

}
