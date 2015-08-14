package Evolution;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Appl.NGStageManager;
import javafx.stage.Stage;

public class HabitatStageItem extends NGCustomStageItem {

    public HabitatStageItem(NGStageManager aStageManager, String aName, Stage aStage) {
        super(aStageManager, aName, aStage);
        FFXMLName = "HabitatStage.fxml";
        FHeight = 800;
        FWidth = 800;
    }

}
