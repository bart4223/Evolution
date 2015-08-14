package Evolution.Creatures;

import Uniwork.Base.NGObject;
import javafx.scene.paint.Color;

public abstract class CustomCreature extends NGObject {

    protected CreatureManager FCreatureManager;
    protected CustomEvolutionProcess FEvolutionProcess;
    protected Color FColor;

    public CustomCreature(CreatureManager aCreatureManager, CustomEvolutionProcess aEvolutionProcess) {
        super();
        FCreatureManager = aCreatureManager;
        FEvolutionProcess = aEvolutionProcess;
        FColor = Color.BLUE;
    }

    public CreatureManager getCreatureManager() {
        return FCreatureManager;
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

    public void Evolution() {
        FEvolutionProcess.Execute(this);
    }

}
