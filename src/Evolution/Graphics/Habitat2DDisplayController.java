package Evolution.Graphics;

import Evolution.Creature2D;
import Evolution.CustomCreature;
import Evolution.Habitat2D;
import Uniwork.Graphics.NGPoint2D;
import Uniwork.Visuals.NGDisplayController;
import javafx.scene.canvas.Canvas;

import java.util.Iterator;

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
            Iterator<CustomCreature> itr = Habitat.getCreatureManager().getCreatures();
            while (itr.hasNext()) {
                Creature2D creature = (Creature2D)itr.next();
                NGPoint2D pos = creature.getPosition();
                drawPixel(pos.getXAsInt(), pos.getYAsInt(), creature.getColor());
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
