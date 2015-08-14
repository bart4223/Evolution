package Evolution;

import Uniwork.Graphics.NGPoint2D;

public class Creature2D extends CustomCreature {

    protected NGPoint2D FPosition;

    public Creature2D(CreatureManager aCreatureManager, double aX, double aY) {
        super(aCreatureManager);
        FPosition = new NGPoint2D(aX, aY);
    }

    public NGPoint2D getPosition() {
        return FPosition;
    }

    public String getInfo() {
        return FPosition.AsString();
    }

}
