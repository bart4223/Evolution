package Evolution;

import Evolution.Biotopes.*;
import Evolution.Processes.CustomEvolutionProcess;
import Evolution.Processes.GameOfLife2D;
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
        FHabitat = new Habitat2D(this, EvolutionConsts.C_COMPONENT_HABITAT, 80, 80);
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
        registerObjectRequest("HabitatModule", this, "Sample02", "LoadSampleBiotope02");
        registerObjectRequest("HabitatModule", this, "Sample03", "LoadSampleBiotope03");
        registerObjectRequest("HabitatModule", this, "Sample04", "LoadSampleBiotope04");
        registerObjectRequest("HabitatModule", this, "Sample05", "LoadSampleBiotope05");
        registerObjectRequest("HabitatModule", this, "Sample06", "LoadSampleBiotope06");
        registerObjectRequest("HabitatModule", this, "Sample07", "LoadSampleBiotope07");
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
        FHabitat.KillAll();
        FHabitat.addBiotope(new SampleBiotope01(), FEvolutionProcess);
    }

    public void LoadSampleBiotope02() {
        FHabitat.KillAll();
        FHabitat.addBiotope(new SampleBiotope02(), FEvolutionProcess);
    }

    public void LoadSampleBiotope03() {
        FHabitat.KillAll();
        FHabitat.addBiotope(new SampleBiotope03(), FEvolutionProcess);
    }

    public void LoadSampleBiotope04() {
        FHabitat.KillAll();
        FHabitat.addBiotope(new SampleBiotope04(), FEvolutionProcess);
    }

    public void LoadSampleBiotope05() {
        FHabitat.KillAll();
        FHabitat.addBiotope(new SampleBiotope05(), FEvolutionProcess);
    }

    public void LoadSampleBiotope06() {
        FHabitat.KillAll();
        FHabitat.addBiotope(new SampleBiotope06(), FEvolutionProcess);
    }

    public void LoadSampleBiotope07() {
        FHabitat.KillAll();
        FHabitat.addBiotope(new SampleBiotope07(), FEvolutionProcess);
    }

}