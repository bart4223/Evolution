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
            FGC.strokeText(String.format("Creatures %d", Habitat.getCreatuesCount()), 670, 750);
            FGC.strokeText(String.format("Max Creatures %d", Habitat.getMaxCreatuesCount()), 670, 770);
            FGC.strokeText(String.format("Generations %d", Habitat.getGenerationCount()), 670, 790);
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
