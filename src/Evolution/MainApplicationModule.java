package Evolution;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGVisualApplicationModule;
import Uniwork.Base.NGComponent;

public class MainApplicationModule extends NGVisualApplicationModule {

    @Override
    protected void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        NGCustomStageItem item = FStageManager.addStageItem("Main", FPrimaryStage);
        item.setCaption(FName);
        item.setPosition(1000, 100);
    }

    public MainApplicationModule(NGComponent aOwner, String aName, String aDescription) {
        super(aOwner, aName, aDescription);
        FStageManager.registerItemClass("Main", "Evolution.MainStageItem");
    }

}