package Evolution;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Visuals.NGStageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class HabitatControlStageController extends NGStageController {

    @FXML
    private ComboBox cbSamples;

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
    protected void handleReload() {
        if (cbSamples.getValue() != null) {
            Invoke("HabitatModule", cbSamples.getValue().toString());
        }
    }

    public void handlecbSamples(ActionEvent actionEvent) {
        if (actionEvent.getEventType().equals(ActionEvent.ACTION)) {
            if (cbSamples.getValue() != null) {
                Invoke("HabitatModule", cbSamples.getValue().toString());
            }
        }
    }
    protected void DoInitialize() {
        super.DoInitialize();
        cbSamples.getItems().add("Sample01");
        cbSamples.getItems().add("Sample02");
        cbSamples.getItems().add("Sample03");
        cbSamples.getItems().add("Sample04");
        cbSamples.getItems().add("Sample05");
        cbSamples.getItems().add("Sample06");
    }

    public HabitatControlStageController() {
        this(null);
    }

    public HabitatControlStageController(NGCustomStageItem aStageItem) {
        super(aStageItem);
    }

}
