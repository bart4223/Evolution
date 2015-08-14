package Evolution;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Visuals.NGStageController;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;

public class EvolutionStageController extends NGStageController {

    @FXML
    private Canvas Layer0;

    public EvolutionStageController() {
        this(null);
    }

    public EvolutionStageController(NGCustomStageItem aStageItem) {
        super(aStageItem);
    }
}
