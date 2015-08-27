package Evolution;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGVisualApplicationModule;
import Uniwork.Base.NGComponent;
import Uniwork.UI.NGUIHelpToolboxContext;

public class MainApplicationModule extends NGVisualApplicationModule {

    protected NGCustomStageItem FConsole;

    @Override
    protected void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        NGCustomStageItem item = FStageManager.addStageItem("Main", FPrimaryStage);
        item.setCaption(getDescription());
        item.setPosition(1000, 100);
        FConsole = FStageManager.addStageItem("Console");
        FConsole.setCaption(String.format("%s.Console",getDescription()));
        FConsole.setPosition(750, 1150);
        FConsole.setContext(Application.getLogManager());
        Application.getLogManager().addEventListener(FConsole);
    }

    @Override
    protected void registerObjectRequests() {
        super.registerObjectRequests();
        registerObjectRequest("Main", this, "Help", "ShowHelp");
    }

    public MainApplicationModule(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FDescription = "Main";
        FStageManager.registerItemClass("Main", "Evolution.MainStageItem");
        FStageManager.registerItemClass("Console", "Uniwork.UI.NGUIConsoleStageItem");
        FToolboxManager.registerItemClass("Help", "Uniwork.UI.NGUIHelpToolboxItem");
    }

    public void ShowHelp() {
        FToolboxManager.ShowToolbox("Help", String.format("%s.Help", getDescription()), new NGUIHelpToolboxContext(Application.LoadResourceFileContent("help/welcome.txt")));
    }

    public NGCustomStageItem getConsole() {
        return FConsole;
    }

}