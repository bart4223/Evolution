package Evolution.Biotopes;

import Evolution.Creatures.CustomCellColony;
import Uniwork.Base.NGObject;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class CustomBiotope extends NGObject {

    protected String FName;
    protected String FDescription;
    protected CopyOnWriteArrayList<CustomCellColony> FColonies;

    public String getInfo() {
        return String.format("%s \"%s\"", FName, FDescription);
    }

    public CustomBiotope() {
        super();
        FColonies = new CopyOnWriteArrayList<CustomCellColony>();
        FName = "";
        FDescription = "";
    }

    public Iterator<CustomCellColony> getColonies() {
        return FColonies.iterator();
    }

}
