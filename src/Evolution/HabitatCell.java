package Evolution;

import Evolution.Creatures.CustomCreature;
import Uniwork.Base.NGObject;

public class HabitatCell extends NGObject {

    protected CustomCreature FCreature;

    public HabitatCell() {
        super();
        FCreature = null;
    }

    public void setCreature(CustomCreature aCreature) {
        FCreature = aCreature;
    }

    public CustomCreature getCreature() {
        return FCreature;
    }

}
