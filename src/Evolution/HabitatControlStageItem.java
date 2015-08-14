package Evolution;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGStageManager;
import javafx.stage.Stage;

public class HabitatControlStageItem extends NGCustomStageItem {

    public HabitatControlStageItem(NGStageManager aStageManager, String aName, Stage aStage) {
        super(aStageManager, aName, aStage);
        FFXMLName = "HabitatControlStage.fxml";
        FWidth = 800;
        FHeight = 50;
    }

}
