package Evolution.Creatures;

import Uniwork.Graphics.NGPoint2D;
import javafx.scene.paint.Color;

import java.util.concurrent.CopyOnWriteArrayList;

public class PulsatorColony extends CellColony2D {

    @Override
    public CopyOnWriteArrayList<NGPoint2D> getPoints() {
        CopyOnWriteArrayList<NGPoint2D> res = new CopyOnWriteArrayList<NGPoint2D>();
        res.add(new NGPoint2D(FX + 2, FY));
        res.add(new NGPoint2D(FX + 3, FY));
        res.add(new NGPoint2D(FX + 4, FY));
        res.add(new NGPoint2D(FX + 5, FY));
        res.add(new NGPoint2D(FX + 6, FY));
        res.add(new NGPoint2D(FX + 7, FY));
        res.add(new NGPoint2D(FX + 1, FY + 1));
        res.add(new NGPoint2D(FX + 8, FY + 1));
        res.add(new NGPoint2D(FX, FY + 2));
        res.add(new NGPoint2D(FX + 9, FY + 2));
        res.add(new NGPoint2D(FX + 1, FY + 3));
        res.add(new NGPoint2D(FX + 8, FY + 3));
        res.add(new NGPoint2D(FX + 2, FY + 4));
        res.add(new NGPoint2D(FX + 3, FY + 4));
        res.add(new NGPoint2D(FX + 4, FY + 4));
        res.add(new NGPoint2D(FX + 5, FY + 4));
        res.add(new NGPoint2D(FX + 6, FY + 4));
        res.add(new NGPoint2D(FX + 7, FY + 4));
        return res;
    }

    public PulsatorColony(Double aX, Double aY) {
        super(aX, aY);
        FColor = newColor(Color.GREEN);
        FName = "Pulsator";
    }

}
