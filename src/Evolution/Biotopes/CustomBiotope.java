package Evolution.Biotopes;

import Evolution.Creatures.CustomCellColony;
import Uniwork.Base.NGObject;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class CustomBiotope extends NGObject {

    protected String FName;
    protected String FDescription;
    protected ArrayList<CustomCellColony> FColonies;

    public String getInfo() {
        return String.format("%s \"%s\"", FName, FDescription);
    }

    public CustomBiotope() {
        super();
        FColonies = new ArrayList<CustomCellColony>();
        FName = "";
        FDescription = "";
    }

    public Iterator<CustomCellColony> getColonies() {
        return FColonies.iterator();
    }

}
