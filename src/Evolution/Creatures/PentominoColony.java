package Evolution.Creatures;

import Uniwork.Graphics.NGPoint2D;
import javafx.scene.paint.Color;

import java.util.concurrent.CopyOnWriteArrayList;

public class PentominoColony extends CellColony2D {

    @Override
    public CopyOnWriteArrayList<NGPoint2D> getPoints() {
        CopyOnWriteArrayList<NGPoint2D> res = new CopyOnWriteArrayList<NGPoint2D>();
        res.add(new NGPoint2D(FX + 1, FY));
        res.add(new NGPoint2D(FX + 2, FY));
        res.add(new NGPoint2D(FX, FY + 1));
        res.add(new NGPoint2D(FX + 1, FY + 1));
        res.add(new NGPoint2D(FX + 1, FY + 2));
        return res;
    }

    public PentominoColony(Double aX, Double aY) {
        super(aX, aY);
        FColor = newColor(Color.GREEN);
        FName = "Pentomino";
    }

}
