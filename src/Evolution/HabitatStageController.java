package Evolution;

import Evolution.Creatures.CustomCreature;
import Evolution.Graphics.Habitat2DDisplayController;
import Evolution.Graphics.HabitatInfoDisplayController;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Base.NGObjectRequestItem;
import Uniwork.Visuals.NGDisplayView;
import Uniwork.Visuals.NGGrid2DDisplayController;
import Uniwork.Visuals.NGStageController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.geom.Arc2D;

public class HabitatStageController extends NGStageController {

    protected Integer FPixelSize = 10;

    @FXML
    private Canvas Layer0;

    @FXML
    private Canvas Layer1;

    @FXML
    private Canvas Layer2;

    @FXML
    private Canvas LayerTop;

    @Override
    protected void CreateDisplayController() {
        super.CreateDisplayController();
        NGDisplayView dv = new NGDisplayView(Layer0.getWidth(), Layer0.getHeight());
        NGGrid2DDisplayController dcgrid = new NGGrid2DDisplayController(Layer1, "Grid");
        dcgrid.setView(dv);
        dcgrid.GridDistance =FPixelSize;
        dcgrid.GridColor = Color.DARKGRAY;
        dcgrid.AlternateGridColor = false;
        registerDisplayController(dcgrid);
        Habitat2DDisplayController dchabitat = new Habitat2DDisplayController(Layer0, "Habitat");
        dchabitat.setPixelSize(FPixelSize);
        registerDisplayController(dchabitat, true);
        HabitatInfoDisplayController dchabitatText = new HabitatInfoDisplayController(Layer2, "Info");
        registerDisplayController(dchabitatText, true);
    }

    protected void HandleMousePressed(MouseEvent t) {
        switch (t.getButton()) {
            case PRIMARY:
                NGObjectRequestItem req = newObjectRequest("HabitatModule", "SimpleColony");
                Integer x = (int)t.getX() / FPixelSize;
                Integer y = (int)t.getY() / FPixelSize;
                req.addParam("aX", x.doubleValue());
                req.addParam("aY", y.doubleValue());
                Invoke(req);
                break;
        }
    }

    @Override
    protected void DoInitialize() {
        super.DoInitialize();
        LayerTop.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        HandleMousePressed(t);
                    }
                });
    }

    public HabitatStageController() {
        this(null);
        FOwnRenderThread = true;
    }

    public HabitatStageController(NGCustomStageItem aStageItem) {
        super(aStageItem);
    }

    public void addCreature(CustomHabitat aHabitat, CustomCreature aCreature) {
        if (aHabitat instanceof Habitat2D) {
            Habitat2DDisplayController dc = (Habitat2DDisplayController)getDisplayController("Habitat");
            dc.Habitat = (Habitat2D)aHabitat;
            RenderScene(dc);
        }
        UpdateHabitatInfo(aHabitat);
    }

    public void removeCreature(CustomHabitat aHabitat, CustomCreature aCreature) {
        if (aHabitat instanceof Habitat2D) {
            Habitat2DDisplayController dc = (Habitat2DDisplayController)getDisplayController("Habitat");
            dc.Habitat = (Habitat2D)aHabitat;
            RenderScene(dc);
        }
        UpdateHabitatInfo(aHabitat);
    }

    public void UpdateHabitatInfo(CustomHabitat aHabitat) {
        HabitatInfoDisplayController dc = (HabitatInfoDisplayController)getDisplayController("Info");
        dc.Habitat = aHabitat;
        RenderScene(dc);
    }

}
