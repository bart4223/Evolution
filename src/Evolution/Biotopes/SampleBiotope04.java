package Evolution.Biotopes;

import Evolution.Creatures.*;

public class SampleBiotope04 extends CustomBiotope {

    public SampleBiotope04() {
        super();
        FName = "Sample04";
        FDescription = "Skid";
        FColonies.add(new SkidColony(6.0, 6.0));
    }

}
