package Evolution.Creatures;

import Evolution.CustomHabitat;
import Evolution.Processes.CustomEvolutionProcess;
import Uniwork.Base.NGObject;
import javafx.scene.paint.Color;

public abstract class CustomCreature extends NGObject {

    protected CustomHabitat FHabitat;
    protected CustomEvolutionProcess FEvolutionProcess;
    protected Color FColor;
    protected Double FAge;

    public CustomCreature(CustomHabitat aHabitat, CustomEvolutionProcess aEvolutionProcess) {
        super();
        FHabitat = aHabitat;
        FEvolutionProcess = aEvolutionProcess;
        FColor = Color.BLACK;
        FAge = 1.0;
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

    public void Mature() {
        FAge = FAge + 1.0;
    }

    public Double getAge() {
        return FAge;
    }

}
