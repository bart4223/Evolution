package Evolution.Biotopes;

import Evolution.Creatures.LostColony;

public class SampleBiotope05 extends CustomBiotope {

    public SampleBiotope05() {
        super();
        FName = "Sample05";
        FDescription = "The lost biotopes";
        FColonies.add(new LostColony(38.0, 20.0));
        FColonies.add(new LostColony(38.0, 50.0));
    }

}
