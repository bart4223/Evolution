package Evolution.Creatures;

import Uniwork.Graphics.NGPoint2D;

import java.util.ArrayList;

public class BipoleColony extends CellColony2D {

    @Override
    public ArrayList<NGPoint2D> getPoints() {
        ArrayList<NGPoint2D> res = new ArrayList<NGPoint2D>();
        res.add(new NGPoint2D(FX, FY));
        res.add(new NGPoint2D(FX + 1, FY));
        res.add(new NGPoint2D(FX, FY + 1));
        res.add(new NGPoint2D(FX + 3, FY + 2));
        res.add(new NGPoint2D(FX + 2, FY + 3));
        res.add(new NGPoint2D(FX + 3, FY + 3));
        return res;
    }

    public BipoleColony(Double aX, Double aY) {
        super(aX, aY);
        FName = "Bipole";
    }

}
