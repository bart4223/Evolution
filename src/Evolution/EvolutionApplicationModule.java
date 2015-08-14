package Evolution;

import Evolution.Creatures.Creature2D;
import Evolution.Creatures.CustomEvolutionProcess;
import Evolution.Creatures.GameOfLife2D;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGVisualApplicationModule;
import Uniwork.Base.NGComponent;

public class EvolutionApplicationModule extends NGVisualApplicationModule {

    protected CustomHabitat FHabitat;

    @Override
    protected void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        NGCustomStageItem item = FStageManager.addStageItem("Control");
        item.setCaption(String.format("%s.Control", FName));
        item.setPosition(1500, 200);
        item = FStageManager.addStageItem("Habitat");
        item.setCaption(String.format("%s.Habitat", FName));
        item.setPosition(1500, 300);
        getHabitat().addEventListener((HabitatEventListener)item);
    }

    @Override
    protected void DoAfterInitialize() {
        super.DoAfterInitialize();
        // ToDo
        CustomHabitat h = getHabitat();
        CustomEvolutionProcess ep = new GameOfLife2D(h);
        h.addEvolutionProcess(ep);
        h.addCreature(new Creature2D(h, ep, 1, 2));
        h.addCreature(new Creature2D(h, ep, 2, 1));
        h.addCreature(new Creature2D(h, ep, 2, 2));
    }

    @Override
    protected void registerObjectRequests() {
        registerObjectRequest("Habitat", getHabitat(), "Next", "Evolution");
    }

    public EvolutionApplicationModule(NGComponent aOwner, String aName, String aDescription) {
        super(aOwner, aName, aDescription);
        FComponentManager.registerComponent(new Habitat2D(this, EvolutionConsts.C_COMPONENT_HABITAT));
        FStageManager.registerItemClass("Control", "Evolution.HabitatControlStageItem");
        FStageManager.registerItemClass("Habitat", "Evolution.HabitatStageItem");
    }

    public CustomHabitat getHabitat() {
        if (FHabitat == null)
            FHabitat = (CustomHabitat)FComponentManager.getComponent(EvolutionConsts.C_COMPONENT_HABITAT);
        return FHabitat;
    }

}