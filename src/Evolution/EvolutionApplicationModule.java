package Evolution;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGVisualApplicationModule;
import Uniwork.Base.NGComponent;

public class EvolutionApplicationModule extends NGVisualApplicationModule {

    protected Habitat FHabitat;

    @Override
    protected void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        NGCustomStageItem item = FStageManager.addStageItem("Control");
        item.setCaption(String.format("%s.Control", FName));
        item.setPosition(1500, 200);
        item = FStageManager.addStageItem("Habitat");
        item.setCaption(String.format("%s.Habitat", FName));
        item.setPosition(1500, 300);
    }

    public EvolutionApplicationModule(NGComponent aOwner, String aName, String aDescription) {
        super(aOwner, aName, aDescription);
        FComponentManager.registerComponent(new Habitat(this, EvolutionConsts.C_COMPONENT_HABITAT));
        FStageManager.registerItemClass("Control", "Evolution.HabitatControlStageItem");
        FStageManager.registerItemClass("Habitat", "Evolution.HabitatStageItem");
    }

    public Habitat getHabitat() {
        if (FHabitat == null)
            FHabitat = (Habitat)FComponentManager.getComponent(EvolutionConsts.C_COMPONENT_HABITAT);
        return FHabitat;
    }

}