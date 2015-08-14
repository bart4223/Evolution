package Evolution;

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
    public void handleCreatureAdded(CreatureEvent e) {
        HabitatStageController sc = (HabitatStageController)FStageController;
        sc.addCreature(e.getCreature());
    }
}
