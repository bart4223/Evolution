package Evolution;

import Evolution.Biotopes.*;
import Evolution.Processes.CustomEvolutionProcess;
import Evolution.Processes.GameOfLife2D;
import Uniwork.Appl.NGApplication;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGVisualApplicationModule;
import Uniwork.Base.NGComponent;
import Uniwork.Base.NGObjectRequestMethod;
import Uniwork.Base.NGObjectRequestParameter;

public class EvolutionApplicationModule extends NGVisualApplicationModule {

    protected CustomHabitat FHabitat;
    protected CustomEvolutionProcess FEvolutionProcess;

    @Override
    protected void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        NGCustomStageItem item = FStageManager.addStageItem("Control");
        item.setCaption(String.format("%s.Control", getDescription()));
        item.setPosition(1500, 200);
        item = FStageManager.addStageItem("Habitat");
        item.setCaption(String.format("%s.Habitat", getDescription()));
        item.setPosition(1500, 300);
        getHabitat().addEventListener((HabitatEventListener) item);
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
        NGObjectRequestMethod method = registerObjectRequest("HabitatModule", this, "Sample", "LoadSample");
        method.addParam("aName", NGObjectRequestParameter.ParamKind.String);
    }

    public EvolutionApplicationModule(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        CreateHabitat();
        FStageManager.registerItemClass("Control", "Evolution.HabitatControlStageItem");
        FStageManager.registerItemClass("Habitat", "Evolution.HabitatStageItem");
    }

    public CustomHabitat getHabitat() {
        if (FHabitat == null)
            FHabitat = (CustomHabitat)FComponentManager.getComponent(EvolutionConsts.C_COMPONENT_HABITAT);
        return FHabitat;
    }

    public void LoadSample(String aName) {
        CustomBiotope biotope = (CustomBiotope)createObjectByName(this, String.format("Evolution.Biotopes.Sample%s", aName));
        LoadSampleBiotope(biotope);
    }

}