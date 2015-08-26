package Evolution.Biotopes;

import Evolution.Creatures.SpaceInvaderColony;

public class SampleBiotope08 extends CustomBiotope {

    public SampleBiotope08() {
        super();
        FName = "Sample08";
        FDescription = "Space Invaders";
        FColonies.add(new SpaceInvaderColony(35.0, 36.0));
    }

}
