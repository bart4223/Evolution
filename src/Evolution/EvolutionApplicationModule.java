package Evolution;

import Evolution.Biotopes.SampleBiotope01;
import Evolution.Creatures.CustomEvolutionProcess;
import Evolution.Creatures.GameOfLife2D;
import Uniwork.Appl.NGApplication;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGVisualApplicationModule;
import Uniwork.Base.NGComponent;

public class EvolutionApplicationModule extends NGVisualApplicationModule {

    protected CustomHabitat FHabitat;
    protected CustomEvolutionProcess FEvolutionProcess;

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

    protected void CreateHabitat() {
        FHabitat = new Habitat2D(this, EvolutionConsts.C_COMPONENT_HABITAT, 40, 40);
        FHabitat.setLogLevel(NGApplication.Application.getLogManager().getLogLevel());
        FEvolutionProcess = new GameOfLife2D(FHabitat);
        FHabitat.addEvolutionProcess(FEvolutionProcess);
        FComponentManager.registerComponent(FHabitat);
    }

    @Override
    protected void registerObjectRequests() {
        registerObjectRequest("Habitat", getHabitat(), "Next", "Evolution");
        registerObjectRequest("Habitat", getHabitat(), "Repro", "ToggleReproduction");
        registerObjectRequest("Habitat", getHabitat(), "Kill", "KillAll");
        registerObjectRequest("HabitatModule", this, "Sample01", "LoadSampleBiotope01");
    }

    public EvolutionApplicationModule(NGComponent aOwner, String aName, String aDescription) {
        super(aOwner, aName, aDescription);
        CreateHabitat();
        FStageManager.registerItemClass("Control", "Evolution.HabitatControlStageItem");
        FStageManager.registerItemClass("Habitat", "Evolution.HabitatStageItem");
    }

    public CustomHabitat getHabitat() {
        if (FHabitat == null)
            FHabitat = (CustomHabitat)FComponentManager.getComponent(EvolutionConsts.C_COMPONENT_HABITAT);
        return FHabitat;
    }

    public void LoadSampleBiotope01() {
        FHabitat.addBiotope(new SampleBiotope01(), FEvolutionProcess);
    }

}