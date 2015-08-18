package Evolution.Creatures;

import Uniwork.Graphics.NGPoint2D;

import java.util.ArrayList;

public class BlinkerColony extends CellColony2D {

    @Override
    public ArrayList<NGPoint2D> getPoints() {
        ArrayList<NGPoint2D> res = new ArrayList<NGPoint2D>();
        res.add(new NGPoint2D(FX + 1, FY));
        res.add(new NGPoint2D(FX + 1, FY + 1));
        res.add(new NGPoint2D(FX + 1, FY + 2));
        return res;
    }

    public BlinkerColony(Double aX, Double aY) {
        super(aX, aY);
        FName = "Blinker";
    }

}
