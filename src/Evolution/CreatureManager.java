package Evolution;

import Uniwork.Base.NGComponent;

import java.util.ArrayList;
import java.util.Iterator;

public class CreatureManager extends NGComponent {

    public ArrayList<CustomCreature> FCreatures;

    public CreatureManager(NGComponent aOwner) {
        this(aOwner, "");
    }

    public CreatureManager(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FCreatures = new ArrayList<CustomCreature>();
    }

    public void addCreature(CustomCreature aCreature) {
        FCreatures.add(aCreature);
    }

    public void removeCreature(CustomCreature aCreature) {
        FCreatures.remove(aCreature);
    }

    public Iterator<CustomCreature> getCreatures() {
        return FCreatures.iterator();
    }

}
