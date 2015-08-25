package Evolution.Biotopes;

import Evolution.Creatures.SimpleColony;
import Uniwork.Misc.NGRandomGenerator;

public class SampleBiotope07 extends CustomBiotope {

    public SampleBiotope07() {
        super();
        FName = "Sample07";
        FDescription = "The random biotope";
        NGRandomGenerator rd = new NGRandomGenerator();
        Integer count = rd.getInteger(200, 400);
        for (int i = 0; i < count; i++) {
            FColonies.add(new SimpleColony(rd.getInteger(0, 79).doubleValue(), rd.getInteger(0, 79).doubleValue()));
        }
    }

}
