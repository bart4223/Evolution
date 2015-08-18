package Evolution;

import Evolution.Creatures.CreatureEvent;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGStageManager;
import javafx.stage.Stage;

public class HabitatStageItem extends NGCustomStageItem implements HabitatEventListener {

    public HabitatStageItem(NGStageManager aStageManager, String aName, Stage aStage) {
        super(aStageManager, aName, aStage);
        FFXMLName = "HabitatStage.fxml";
        FHeight = 800;
        FWidth = 800;
    }

    @Override
    public void handleKillAll(HabitatEvent e) {
        HabitatStageController sc = (HabitatStageController)FStageController;
        sc.UpdateHabitatInfo(e.getHabitat());
    }

    @Override
    public void handleEvolutionStart(HabitatEvent e) {
        HabitatStageController sc = (HabitatStageController)FStageController;
        sc.UpdateHabitatInfo(e.getHabitat());
    }

    @Override
    public void handleEvolutionEnd(HabitatEvent e) {
        HabitatStageController sc = (HabitatStageController)FStageController;
        sc.UpdateHabitatInfo(e.getHabitat());
    }

    @Override
    public void handleCreatureAdded(CreatureEvent e) {
        HabitatStageController sc = (HabitatStageController)FStageController;
        sc.addCreature(e.getHabitat(), e.getCreature());
    }

    @Override
    public void handleCreatureRemoved(CreatureEvent e) {
        HabitatStageController sc = (HabitatStageController)FStageController;
        sc.addCreature(e.getHabitat(), e.getCreature());
    }

}
