package Evolution;

import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Visuals.NGDisplayView;
import Uniwork.Visuals.NGGrid2DDisplayController;
import Uniwork.Visuals.NGStageController;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class HabitatStageController extends NGStageController {

    @FXML
    private Canvas Layer0;

    @FXML
    private Canvas Layer1;

    @Override
    protected void CreateDisplayController() {
        super.CreateDisplayController();
        NGDisplayView dv = new NGDisplayView(Layer0.getWidth(), Layer0.getHeight());
        NGGrid2DDisplayController dcgrid = new NGGrid2DDisplayController(Layer0, "Grid");
        dcgrid.setView(dv);
        dcgrid.GridDistance = 20;
        dcgrid.GridColor = Color.DARKGRAY;
        dcgrid.AlternateGridColor = false;
        registerDisplayController(dcgrid);
    }

    public HabitatStageController() {
        this(null);
    }

    public HabitatStageController(NGCustomStageItem aStageItem) {
        super(aStageItem);
    }

    public void addCreature(CustomCreature aCreature) {
        // ToDo
        System.out.println(aCreature.getInfo());
    }

}
