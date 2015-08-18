package Evolution.Biotopes;

import Evolution.Creatures.BlinkerColony;
import Evolution.Creatures.ClockColony;
import Evolution.Creatures.OctogoneColony;
import Evolution.Creatures.ToadColony;

public class SampleBiotope02 extends CustomBiotope {

    public SampleBiotope02() {
        super();
        FName = "Sample02";
        FDescription = "Toads & Octogone";
        FColonies.add(new BlinkerColony(6.0, 6.0));
        FColonies.add(new ClockColony(12.0, 44.0));
        FColonies.add(new ToadColony(36.0, 24.0));
        FColonies.add(new ClockColony(60.0, 14.0));
        FColonies.add(new OctogoneColony(44.0, 50.0));
    }

}
