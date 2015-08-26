package Evolution;

import Evolution.Creatures.CustomCreature;
import Evolution.Graphics.Habitat2DDisplayController;
import Evolution.Graphics.HabitatInfoDisplayController;
import Uniwork.Appl.NGCustomStageItem;
import Uniwork.Base.NGObjectRequestItem;
import Uniwork.Visuals.NGDisplayView;
import Uniwork.Visuals.NGGrid2DDisplayController;
import Uniwork.Visuals.NGStageController;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class HabitatStageController extends NGStageController {

    protected Integer FPixelSize = 10;
    protected Integer FUpdateCount = 0;

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
        dcgrid.DrawGrid = getConfigurationPropertyAsBoolean("Habitat.DrawGrid", true);
        registerDisplayController(dcgrid);
        Habitat2DDisplayController dchabitat = new Habitat2DDisplayController(Layer0, "Habitat");
        dchabitat.setPixelSize(FPixelSize);
        registerDisplayController(dchabitat, true);
        HabitatInfoDisplayController dchabitatText = new HabitatInfoDisplayController(Layer2, "Info");
        registerDisplayController(dchabitatText, true);
    }

    protected void addSimpleColony(Double aX, Double aY) {
        Integer x = (int)(aX / FPixelSize);
        Integer y = (int)(aY / FPixelSize);
        NGObjectRequestItem req = newObjectRequest("HabitatModule", "SimpleColony");
        req.addParam("aX", x.doubleValue());
        req.addParam("aY", y.doubleValue());
        Invoke(req);
    }

    protected void removeCreature(Double aX, Double aY) {
        Integer x = (int)(aX / FPixelSize);
        Integer y = (int)(aY / FPixelSize);
        NGObjectRequestItem req = newObjectRequest("Habitat", "RemoveCreature");
        req.addParam("aX", x.doubleValue());
        req.addParam("aY", y.doubleValue());
        Invoke(req);
    }

    protected void HandleMousePressed(MouseEvent e) {
        switch (e.getButton()) {
            case PRIMARY:
                if (e.isAltDown())
                    removeCreature(e.getX(), e.getY());
                else
                    addSimpleColony(e.getX(), e.getY());
                break;
        }
    }

    protected void HandleMouseDragged(MouseEvent e) {
        switch (e.getButton()) {
            case PRIMARY:
                if (e.isAltDown())
                    removeCreature(e.getX(), e.getY());
                else
                    addSimpleColony(e.getX(), e.getY());
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
        LayerTop.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent t) {
                        HandleMouseDragged(t);
                    }
                });
    }

    protected void UpdateHabitatInfo(CustomHabitat aHabitat) {
        HabitatInfoDisplayController dc = (HabitatInfoDisplayController)getDisplayController("Info");
        dc.Habitat = aHabitat;
        RenderScene(dc);
    }

    protected void UpdateHabitatCells(Habitat2D aHabitat) {
        Habitat2DDisplayController dc = (Habitat2DDisplayController)getDisplayController("Habitat");
        dc.Habitat = aHabitat;
        RenderScene(dc);
    }

    public HabitatStageController() {
        this(null);
        FOwnRenderThread = true;
    }

    public HabitatStageController(NGCustomStageItem aStageItem) {
        super(aStageItem);
    }

    public void addCreature(CustomHabitat aHabitat, CustomCreature aCreature) {
        UpdateHabitat(aHabitat);
    }

    public void removeCreature(CustomHabitat aHabitat, CustomCreature aCreature) {
        UpdateHabitat(aHabitat);
    }

    public void BeginUpdateHabitat(CustomHabitat aHabitat) {
        FUpdateCount++;
    }

    public void EndUpdateHabitat(CustomHabitat aHabitat) {
        FUpdateCount--;
        if (FUpdateCount < 0)
            FUpdateCount = 0;
        UpdateHabitat(aHabitat);
    }

    public void UpdateHabitat(CustomHabitat aHabitat) {
        if (FUpdateCount == 0) {
            if (aHabitat instanceof Habitat2D)
                UpdateHabitatCells((Habitat2D) aHabitat);
            UpdateHabitatInfo(aHabitat);
        }
    }

}
