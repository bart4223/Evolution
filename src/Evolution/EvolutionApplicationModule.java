package Evolution;

import Evolution.Biotopes.*;
import Evolution.Creatures.SimpleColony;
import Evolution.Processes.CustomEvolutionProcess;
import Evolution.Processes.GameOfLife2D;
import Evolution.Processes.ModuloTwo2D;
import Uniwork.Appl.NGApplication;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGVisualApplicationModule;
import Uniwork.Base.NGComponent;
import Uniwork.Base.NGObjectRequestMethod;
import Uniwork.Base.NGObjectRequestParameter;
import Uniwork.Misc.NGLogEventListener;
import Uniwork.UI.NGUIHelpContext;

public class EvolutionApplicationModule extends NGVisualApplicationModule {

    protected CustomHabitat FHabitat;

    @Override
    protected void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        NGCustomStageItem item = FStageManager.addStageItem("Control");
        item.setCaption(String.format("%s.Control", getDescription()));
        item.setPosition(1500, 200);
        getHabitat().addEventListener((HabitatEventListener) item);
        item = FStageManager.addStageItem("Habitat");
        item.setCaption(String.format("%s.Habitat", getDescription()));
        item.setPosition(1500, 300);
        getHabitat().addEventListener((HabitatEventListener) item);
    }

    @Override
    protected void DoAfterInitialize() {
        super.DoAfterInitialize();
        getHabitat().setCurrentEvolutionProcess("Game of Life");
    }

    protected void CreateHabitat() {
        FHabitat = new Habitat2D(this, EvolutionConsts.C_COMPONENT_HABITAT, 80, 80);
        FHabitat.setLogLevel(NGApplication.Application.getLogManager().getLogLevel());
        CustomEvolutionProcess ep = new GameOfLife2D(FHabitat);
        FHabitat.addEvolutionProcess(ep);
        FHabitat.setCurrentEvolutionProcess(ep.getName());
        ep = new ModuloTwo2D(FHabitat);
        FHabitat.addEvolutionProcess(ep);
        FComponentManager.registerComponent(FHabitat);
    }

    protected void LoadSampleBiotope(CustomBiotope aBiotope) {
        Boolean ir = FHabitat.IsInReproduction();
        FHabitat.KillAll();
        FHabitat.addBiotope(aBiotope);
        if (ir)
            FHabitat.ToggleReproduction();
    }

    @Override
    protected void registerObjectRequests() {
        super.registerObjectRequests();
        registerObjectRequest("Habitat", FHabitat, "Next", "Evolution");
        registerObjectRequest("Habitat", FHabitat, "Repro", "ToggleReproduction");
        registerObjectRequest("Habitat", FHabitat, "Kill", "KillAll");
        NGObjectRequestMethod method = registerObjectRequest("Habitat", FHabitat, "Process", "setCurrentEvolutionProcess");
        method.addParam("aName", NGObjectRequestParameter.ParamKind.String);
        method = registerObjectRequest("Habitat", FHabitat, "Tick", "setTick");
        method.addParam("aTick", NGObjectRequestParameter.ParamKind.Integer);
        method = registerObjectRequest("HabitatModule", this, "SimpleColony", "addSimpleColony");
        method.addParam("aX", NGObjectRequestParameter.ParamKind.Double);
        method.addParam("aY", NGObjectRequestParameter.ParamKind.Double);
        method = registerObjectRequest("HabitatModule", this, "Sample", "LoadSample");
        method.addParam("aName", NGObjectRequestParameter.ParamKind.String);
        registerObjectRequest("HabitatModule", this, "Help", "ShowHelp");
    }

    public EvolutionApplicationModule(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        CreateHabitat();
        FStageManager.registerItemClass("Control", "Evolution.HabitatControlStageItem");
        FStageManager.registerItemClass("Habitat", "Evolution.HabitatStageItem");
        FToolboxManager.registerItemClass("Help", "Uniwork.UI.NGUIHelpStageItem");
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

    public void addSimpleColony(Double aX, Double aY) {
        FHabitat.addCellColony(new SimpleColony(aX, aY));
    }

    public void ShowHelp() {
        FToolboxManager.ShowToolbox("Help", String.format("%s.Help", getDescription()), new NGUIHelpContext(Application.LoadResourceFileContent("help/evolution.txt")));
    }

    public void addLogListener(NGLogEventListener aLogListener) {
        FHabitat.addLogListener(aLogListener);
    }

    public void removeLogListener(NGLogEventListener aLogListener) {
        FHabitat.removeLogListener(aLogListener);
    }

}