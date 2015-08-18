package Evolution;

import Evolution.Creatures.BlinkerColony;
import Evolution.Creatures.ClockColony;
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
        h.addCellColony(new BlinkerColony(1.0, 1.0), ep);
        h.addCellColony(new BlinkerColony(5.0, 10.0), ep);
        h.addCellColony(new BlinkerColony(20.0, 20.0), ep);
        h.addCellColony(new ClockColony(20.0, 8.0), ep);
        h.addCellColony(new ClockColony(30.0, 33.0), ep);
    }

    @Override
    protected void registerObjectRequests() {
        registerObjectRequest("Habitat", getHabitat(), "Next", "Evolution");
        registerObjectRequest("Habitat", getHabitat(), "Repro", "ToggleReproduction");
        registerObjectRequest("Habitat", getHabitat(), "Kill", "KillAll");
    }

    public EvolutionApplicationModule(NGComponent aOwner, String aName, String aDescription) {
        super(aOwner, aName, aDescription);
        // ToDo
        FComponentManager.registerComponent(new Habitat2D(this, EvolutionConsts.C_COMPONENT_HABITAT, 40, 40));
        FStageManager.registerItemClass("Control", "Evolution.HabitatControlStageItem");
        FStageManager.registerItemClass("Habitat", "Evolution.HabitatStageItem");
    }

    public CustomHabitat getHabitat() {
        if (FHabitat == null)
            FHabitat = (CustomHabitat)FComponentManager.getComponent(EvolutionConsts.C_COMPONENT_HABITAT);
        return FHabitat;
    }

}