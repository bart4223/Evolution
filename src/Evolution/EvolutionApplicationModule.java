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

    protected void LoadSampleBiotope(CustomBiotope aBiotope) {
        Boolean ir = FHabitat.IsInReproduction();
        FHabitat.KillAll();
        FHabitat.addBiotope(aBiotope, FEvolutionProcess);
        if (ir)
            FHabitat.ToggleReproduction();
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
        LoadSampleBiotope(new SampleBiotope01());
    }

    public void LoadSampleBiotope02() {
        LoadSampleBiotope(new SampleBiotope02());
    }

    public void LoadSampleBiotope03() {
        LoadSampleBiotope(new SampleBiotope03());
    }

    public void LoadSampleBiotope04() {
        LoadSampleBiotope(new SampleBiotope04());
    }

    public void LoadSampleBiotope05() {
        LoadSampleBiotope(new SampleBiotope05());
    }

    public void LoadSampleBiotope06() {
        LoadSampleBiotope(new SampleBiotope06());
    }

    public void LoadSampleBiotope07() {
        LoadSampleBiotope(new SampleBiotope07());
    }

}