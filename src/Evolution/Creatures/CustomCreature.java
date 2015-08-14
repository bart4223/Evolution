package Evolution.Creatures;

import Evolution.Creatures.CreatureManager;
import Uniwork.Base.NGObject;
import javafx.scene.paint.Color;

public abstract class CustomCreature extends NGObject {

    protected CreatureManager FCreatureManager;
    protected Color FColor;

    public CustomCreature(CreatureManager aCreatureManager) {
        super();
        FCreatureManager = aCreatureManager;
        FColor = Color.BLUE;
    }

    public CreatureManager getCreatureManager() {
        return FCreatureManager;
    }

    public String getInfo() {
        return "";
    }

    public Color getColor() {
        return FColor;
    }

}
