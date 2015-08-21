package Evolution.Creatures;

import Uniwork.Graphics.NGPoint2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class TripoleColony extends CellColony2D {

    @Override
    public ArrayList<NGPoint2D> getPoints() {
        ArrayList<NGPoint2D> res = new ArrayList<NGPoint2D>();
        res.add(new NGPoint2D(FX, FY));
        res.add(new NGPoint2D(FX + 1, FY));
        res.add(new NGPoint2D(FX, FY + 1));
        res.add(new NGPoint2D(FX + 2, FY + 1));
        res.add(new NGPoint2D(FX + 2, FY + 3));
        res.add(new NGPoint2D(FX + 4, FY + 3));
        res.add(new NGPoint2D(FX + 3, FY + 4));
        res.add(new NGPoint2D(FX + 4, FY + 4));
        return res;
    }

    public TripoleColony(Double aX, Double aY) {
        super(aX, aY);
        FColor = newColor(Color.GREEN);
        FName = "Tripole";
    }

}
