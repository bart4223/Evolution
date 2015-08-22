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
    private ComboBox cbProcesses;

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

    protected void setProcess(String aProcess) {
        NGObjectRequestItem req = newObjectRequest("HabitatModule", "Process");
        req.addParam("aName", aProcess);
        Invoke(req);
    }

    public void handlecbSamples(ActionEvent actionEvent) {
        if (actionEvent.getEventType().equals(ActionEvent.ACTION)) {
            if (cbSamples.getValue() != null)
                loadSample(cbSamples.getValue().toString());
        }
    }

    public void handlecbProcesses(ActionEvent actionEvent) {
        if (actionEvent.getEventType().equals(ActionEvent.ACTION)) {
            if (cbProcesses.getValue() != null)
                setProcess(cbProcesses.getValue().toString());
        }
    }

    protected void DoInitialize() {
        super.DoInitialize();
        for (int i = 1; i <= 7; i++) {
            cbSamples.getItems().add(NGStrings.addString("Biotope", NGStrings.leftPad(String.format("%d", i), 2, "0"), ""));
        }
        cbProcesses.getItems().add("Game of Life");
        cbProcesses.getItems().add("Modulo Two");
    }

    public HabitatControlStageController() {
        this(null);
    }

    public HabitatControlStageController(NGCustomStageItem aStageItem) {
        super(aStageItem);
    }

    public void setCurrentEvolutionProcess(String aName) {
        cbProcesses.getSelectionModel().select(aName);
    }

}
