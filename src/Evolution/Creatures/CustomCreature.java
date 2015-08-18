package Evolution.Creatures;

import Evolution.CustomHabitat;
import Evolution.Processes.CustomEvolutionProcess;
import Uniwork.Base.NGObject;
import javafx.scene.paint.Color;

public abstract class CustomCreature extends NGObject {

    protected CustomHabitat FHabitat;
    protected CustomEvolutionProcess FEvolutionProcess;
    protected Color FColor;

    public CustomCreature(CustomHabitat aHabitat, CustomEvolutionProcess aEvolutionProcess) {
        super();
        FHabitat = aHabitat;
        FEvolutionProcess = aEvolutionProcess;
        FColor = Color.GREEN;
    }

    public CustomHabitat getHabitat() {
        return FHabitat;
    }

    public CustomEvolutionProcess getEvolutionProcess() {
        return FEvolutionProcess;
    }

    public String getInfo() {
        return "";
    }

    public Color getColor() {
        return FColor;
    }

}
