package Evolution;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Visuals.NGStageController;
import javafx.fxml.FXML;

public class HabitatControlStageController extends NGStageController {

    @FXML
    protected void handleNext(){
        Invoke("Habitat", "Next");
    }

    @FXML
    protected void handleRepro(){
        Invoke("Habitat", "Repro");
    }

    public HabitatControlStageController() {
        this(null);
    }

    public HabitatControlStageController(NGCustomStageItem aStageItem) {
        super(aStageItem);
    }

}
