package Evolution.Creatures;

import Uniwork.Graphics.NGPoint2D;

import java.util.ArrayList;

public class PorpoiseColony extends CellColony2D {

    @Override
    public ArrayList<NGPoint2D> getPoints() {
        ArrayList<NGPoint2D> res = new ArrayList<NGPoint2D>();
        res.add(new NGPoint2D(FX + 2, FY));
        res.add(new NGPoint2D(FX + 3, FY));
        res.add(new NGPoint2D(FX + 5, FY));
        res.add(new NGPoint2D(FX + 6, FY));
        res.add(new NGPoint2D(FX + 3, FY + 2));
        res.add(new NGPoint2D(FX + 5, FY + 2));
        res.add(new NGPoint2D(FX + 3, FY + 3));
        res.add(new NGPoint2D(FX + 5, FY + 3));
        res.add(new NGPoint2D(FX, FY + 4));
        res.add(new NGPoint2D(FX + 1, FY + 4));
        res.add(new NGPoint2D(FX + 3, FY + 4));
        res.add(new NGPoint2D(FX + 5, FY + 4));
        res.add(new NGPoint2D(FX + 7, FY + 4));
        res.add(new NGPoint2D(FX + 8, FY + 4));
        res.add(new NGPoint2D(FX + 1, FY + 5));
        res.add(new NGPoint2D(FX + 2, FY + 5));
        res.add(new NGPoint2D(FX + 6, FY + 5));
        res.add(new NGPoint2D(FX + 7, FY + 5));
        return res;
    }

    public PorpoiseColony(Double aX, Double aY) {
        super(aX, aY);
        FName = "Porpoise";
    }

}