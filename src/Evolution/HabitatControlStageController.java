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

    @FXML
    protected void handleKill(){
        Invoke("Habitat", "Kill");
    }

    @FXML
    protected void handleSample01(){
        Invoke("HabitatModule", "Sample01");
    }

    @FXML
    protected void handleSample02(){
        Invoke("HabitatModule", "Sample02");
    }

    @FXML
    protected void handleSample03(){
        Invoke("HabitatModule", "Sample03");
    }

    public HabitatControlStageController() {
        this(null);
    }

    public HabitatControlStageController(NGCustomStageItem aStageItem) {
        super(aStageItem);
    }

}
