package Evolution.Biotopes;

import Evolution.Creatures.PentominoColony;

public class SampleBiotope06 extends CustomBiotope {

    public SampleBiotope06() {
        super();
        FName = "Sample06";
        FDescription = "The Pentomino colony";
        FColonies.add(new PentominoColony(38.0, 32.0));
    }

}
