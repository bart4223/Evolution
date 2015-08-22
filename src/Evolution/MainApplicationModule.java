package Evolution;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.UI.NGUIHelpContext;
import Uniwork.Appl.NGVisualApplicationModule;
import Uniwork.Base.NGComponent;

public class MainApplicationModule extends NGVisualApplicationModule {

    @Override
    protected void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        NGCustomStageItem item = FStageManager.addStageItem("Main", FPrimaryStage);
        item.setCaption(getDescription());
        item.setPosition(1000, 100);
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
        FToolboxManager.registerItemClass("Help", "Uniwork.UI.NGUIHelpStageItem");
    }

    public void ShowHelp() {
        FToolboxManager.ShowToolbox("Help", String.format("%s.Help", getDescription()), new NGUIHelpContext(Application.LoadResourceFileContent("help/welcome.txt")));
    }

}