package Evolution;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Base.NGObjectRequestItem;
import Uniwork.Misc.NGStrings;
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
    protected void handleHelp(){
        Invoke("HabitatModule", "Help");
    }

    @FXML
    protected void handleReload() {
        if (cbSamples.getValue() != null)
            loadSample(cbSamples.getValue().toString());
    }

    protected void loadSample(String aSample) {
        NGObjectRequestItem req = newObjectRequest("HabitatModule", "Sample");
        req.addParam("aName", aSample);
        Invoke(req);
    }

    public void handlecbSamples(ActionEvent actionEvent) {
        if (actionEvent.getEventType().equals(ActionEvent.ACTION)) {
            if (cbSamples.getValue() != null)
                loadSample(cbSamples.getValue().toString());
        }
    }
    protected void DoInitialize() {
        super.DoInitialize();
        for (int i = 1; i <= 7; i++) {
            cbSamples.getItems().add(NGStrings.addString("Biotope", NGStrings.leftPad(String.format("%d", i), 2, "0"), ""));
        }
    }

    public HabitatControlStageController() {
        this(null);
    }

    public HabitatControlStageController(NGCustomStageItem aStageItem) {
        super(aStageItem);
    }

}
