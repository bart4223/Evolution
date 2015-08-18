package Evolution.Creatures;

import Uniwork.Graphics.NGPoint2D;

import java.util.ArrayList;

public class CellColony2D extends CustomCellColony {

    protected Double FX;
    protected Double FY;

    public ArrayList<NGPoint2D> getPoints() {
        return null;
    }

    public CellColony2D(Double aX, Double aY) {
        super();
        FX = aX;
        FY = aY;
    }

    @Override
    public String getInfo() {
        return String.format("%s [%.0f/%.0f]", super.getInfo(), FX, FY);
    }

}
