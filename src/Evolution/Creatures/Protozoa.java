package Evolution.Creatures;

import Evolution.CustomHabitat;
import Uniwork.Graphics.NGPoint2D;

public class Protozoa extends CustomCreature {

    protected NGPoint2D FPosition;

    public Protozoa(CustomHabitat aHabitat, CustomEvolutionProcess aEvolutionProcess, double aX, double aY) {
        super(aHabitat, aEvolutionProcess);
        FPosition = new NGPoint2D(aX, aY);
    }

    public NGPoint2D getPosition() {
        return FPosition;
    }

    public String getInfo() {
        return String.format("Protozoa - %s",FPosition.AsString());
    }

}
