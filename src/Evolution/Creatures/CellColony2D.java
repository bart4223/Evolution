package Evolution.Creatures;

import Uniwork.Graphics.NGPoint2D;
import Uniwork.Misc.NGRandomGenerator;
import javafx.scene.paint.Color;

import java.util.concurrent.CopyOnWriteArrayList;

public class CellColony2D extends CustomCellColony {

    protected Double FX;
    protected Double FY;
    protected Color FColor;

    protected Color newColor(Color aBaseColor) {
        Color res = aBaseColor;
        Integer rnd = NGRandomGenerator.GlobalRandomGenerator.getInteger(0, 2);
        if (rnd == 0)
            res = aBaseColor.darker();
        else if (rnd == 2)
            res = aBaseColor.brighter();
        return res;
    }

    public CopyOnWriteArrayList<NGPoint2D> getPoints() {
        return null;
    }

    public CellColony2D(Double aX, Double aY) {
        super();
        FX = aX;
        FY = aY;
        FColor = newColor(Color.BLACK);
    }

    @Override
    public String getInfo() {
        return String.format("%s [%.0f/%.0f]", super.getInfo(), FX, FY);
    }

    public Color getColor() {
        return FColor;
    }

}
