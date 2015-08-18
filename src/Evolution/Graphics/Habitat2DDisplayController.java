package Evolution.Graphics;

import Evolution.Creatures.Protozoa;
import Evolution.Creatures.CustomCreature;
import Evolution.Habitat2D;
import Uniwork.Graphics.NGPoint2D;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;

import java.util.ArrayList;

public class Habitat2DDisplayController extends NGDisplayController {

    @Override
    protected void DoBeforeRender() {
        super.DoBeforeRender();
        FGC.clearRect(FPosition.getXAsInt() * FPixelSize, FPosition.getYAsInt() * FPixelSize, FWidth, FHeight);
    }

    @Override
    protected void DoRender() {
        super.DoRender();
        if (Habitat != null) {
            ArrayList<CustomCreature> creatures = Habitat.getCreaturesAsArray();
            for (CustomCreature creature : creatures) {
                if (creature instanceof Protozoa) {
                    NGPoint2D pos = ((Protozoa)creature).getPosition();
                    drawPixel(pos.getXAsInt(), pos.getYAsInt(), creature.getColor());
                }
            }
        }
    }

    public Habitat2DDisplayController(Canvas aCanvas) {
        this(aCanvas, "");
    }

    public Habitat2DDisplayController(Canvas aCanvas, String aName) {
        super(aCanvas, aName);
        Habitat = null;
    }

    public Habitat2D Habitat;

}
