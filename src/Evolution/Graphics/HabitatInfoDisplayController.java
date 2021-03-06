package Evolution.Graphics;

import Evolution.CustomHabitat;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HabitatInfoDisplayController extends NGDisplayController {

    @Override
    protected void DoBeforeRender() {
        super.DoBeforeRender();
        FGC.clearRect(FPosition.getXAsInt() * FPixelSize, FPosition.getYAsInt() * FPixelSize, FWidth, FHeight);
    }

    @Override
    protected void DoRender() {
        super.DoRender();
        if (Habitat != null) {
            FGC.clearRect(0, 0, FCanvas.getWidth(), FCanvas.getHeight());
            FGC.setStroke(Color.BLACK);
            FGC.setFont(new Font("Arial", 12));
            FGC.strokeText(String.format("Creatures %d", Habitat.getCreatuesCount()), 650, 730);
            FGC.strokeText(String.format("Max Creatures %d", Habitat.getMaxCreatuesCount()), 650, 750);
            FGC.strokeText(String.format("Generations %d", Habitat.getGenerationCount()), 650, 770);
            FGC.strokeText(String.format("Max Creature Age %.0f", Habitat.getMaxCreatureAge()), 650, 790);
        }
    }

    public HabitatInfoDisplayController(Canvas aCanvas) {
        this(aCanvas, "");
    }

    public HabitatInfoDisplayController(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
        Habitat = null;
    }

    public CustomHabitat Habitat;

}
