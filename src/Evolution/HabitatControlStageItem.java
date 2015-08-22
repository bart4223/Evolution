package Evolution;

import Evolution.Creatures.CreatureEvent;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGStageManager;
import javafx.stage.Stage;

public class HabitatControlStageItem extends NGCustomStageItem implements HabitatEventListener {

    public HabitatControlStageItem(NGStageManager aStageManager, String aName, Stage aStage) {
        super(aStageManager, aName, aStage);
        FFXMLName = "HabitatControlStage.fxml";
        FWidth = 800;
        FHeight = 50;
    }

    @Override
    public void handleKillAll(HabitatEvent e) {

    }

    @Override
    public void handleEvolutionStart(HabitatEvent e) {

    }

    @Override
    public void handleEvolutionEnd(HabitatEvent e) {

    }

    @Override
    public void handleCreatureAdded(CreatureEvent e) {

    }

    @Override
    public void handleCreatureRemoved(CreatureEvent e) {

    }

    @Override
    public void handleCurrentEvolutionProcessChanged(HabitatEvent e) {
        HabitatControlStageController sc = (HabitatControlStageController)FStageController;
        sc.setCurrentEvolutionProcess(e.getHabitat().getCurrentEvolutionProcess().getName());
    }

}
