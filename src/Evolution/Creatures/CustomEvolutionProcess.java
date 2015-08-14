package Evolution.Creatures;

import Uniwork.Base.NGObject;

public abstract class CustomEvolutionProcess extends NGObject {

    protected CreatureManager FCreatureManager;

    protected void DoExecute(CustomCreature aCreature) {

    }

    public CustomEvolutionProcess(CreatureManager aCreatureManager) {
        super();
        FCreatureManager = aCreatureManager;
    }

    public CreatureManager getCreatureManager() {
        return FCreatureManager;
    }

    public void Execute(CustomCreature aCreature) {
        DoExecute(aCreature);
    }

}
