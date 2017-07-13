package Evolution.Creatures;

import Uniwork.Graphics.NGPoint2D;
import javafx.scene.paint.Color;

import java.util.concurrent.CopyOnWriteArrayList;

public class SimpleColony extends CellColony2D {

    @Override
    public CopyOnWriteArrayList<NGPoint2D> getPoints() {
        CopyOnWriteArrayList<NGPoint2D> res = new CopyOnWriteArrayList<NGPoint2D>();
        res.add(new NGPoint2D(FX, FY));
        return res;
    }

    public SimpleColony(Double aX, Double aY) {
        super(aX, aY);
        FColor = newColor(Color.GREEN);
        FName = "Simple";
    }

}
