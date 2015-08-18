package Evolution.Biotopes;

import Evolution.Creatures.LostColony;

public class SampleBiotope05 extends CustomBiotope {

    public SampleBiotope05() {
        super();
        FName = "Sample05";
        FDescription = "The lost biotope";
        FColonies.add(new LostColony(28.0, 32.0));
    }

}
