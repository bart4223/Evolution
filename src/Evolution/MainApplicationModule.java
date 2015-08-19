package Evolution;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGVisualApplicationModule;
import Uniwork.Base.NGComponent;

public class MainApplicationModule extends NGVisualApplicationModule {

    @Override
    protected void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        NGCustomStageItem item = FStageManager.addStageItem("Main", FPrimaryStage);
        item.setCaption(FDescription);
        item.setPosition(1000, 100);
    }

    public MainApplicationModule(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FDescription = "Main";
        FStageManager.registerItemClass("Main", "Evolution.MainStageItem");
    }

}