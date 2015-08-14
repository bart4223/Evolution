package Evolution.Creatures;

import Evolution.CustomHabitat;
import Uniwork.Graphics.NGPoint2D;

public class Creature2D extends CustomCreature {

    protected NGPoint2D FPosition;

    public Creature2D(CustomHabitat aHabitat, CustomEvolutionProcess aEvolutionProcess, double aX, double aY) {
        super(aHabitat, aEvolutionProcess);
        FPosition = new NGPoint2D(aX, aY);
    }

    public NGPoint2D getPosition() {
        return FPosition;
    }

    public String getInfo() {
        return FPosition.AsString();
    }

}
