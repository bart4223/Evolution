package Evolution;

import Uniwork.Base.NGObject;

public abstract class CustomCreature extends NGObject {

    protected CreatureManager FCreatureManager;

    public CustomCreature(CreatureManager aCreatureManager) {
        super();
        FCreatureManager = aCreatureManager;
    }

    public CreatureManager getCreatureManager() {
        return FCreatureManager;
    }

    public String getInfo() {
        return "";
    }

}
