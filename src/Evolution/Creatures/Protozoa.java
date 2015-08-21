package Evolution.Creatures;

import Evolution.CustomHabitat;
import Evolution.Processes.CustomEvolutionProcess;
import Uniwork.Graphics.NGPoint2D;
import javafx.scene.paint.Color;

public class Protozoa extends CustomCreature {

    protected NGPoint2D FPosition;

    public Protozoa(CustomHabitat aHabitat, CustomEvolutionProcess aEvolutionProcess, double aX, double aY, Color aColor) {
        super(aHabitat, aEvolutionProcess);
        FPosition = new NGPoint2D(aX, aY);
        FColor = aColor;
    }

    public NGPoint2D getPosition() {
        return FPosition;
    }

    public String getInfo() {
        return String.format("Protozoa - %s",FPosition.AsString());
    }

}
