package Evolution.Creatures;

import Uniwork.Graphics.NGPoint2D;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class SpaceInvaderColony extends CellColony2D {

    @Override
    public ArrayList<NGPoint2D> getPoints() {
        ArrayList<NGPoint2D> res = new ArrayList<NGPoint2D>();
        res.add(new NGPoint2D(FX + 2, FY));
        res.add(new NGPoint2D(FX + 8, FY));
        res.add(new NGPoint2D(FX + 3, FY + 1));
        res.add(new NGPoint2D(FX + 7, FY + 1));
        for (int i = 2; i <= 8; i++)
            res.add(new NGPoint2D(FX + i, FY + 2));
        res.add(new NGPoint2D(FX + 1, FY + 3));
        res.add(new NGPoint2D(FX + 2, FY + 3));
        res.add(new NGPoint2D(FX + 4, FY + 3));
        res.add(new NGPoint2D(FX + 5, FY + 3));
        res.add(new NGPoint2D(FX + 6, FY + 3));
        res.add(new NGPoint2D(FX + 8, FY + 3));
        res.add(new NGPoint2D(FX + 9, FY + 3));
        for (int i = 0; i <= 10; i++)
            res.add(new NGPoint2D(FX + i, FY + 4));
        res.add(new NGPoint2D(FX, FY + 5));
        res.add(new NGPoint2D(FX + 2, FY + 5));
        res.add(new NGPoint2D(FX + 4, FY + 5));
        res.add(new NGPoint2D(FX + 5, FY + 5));
        res.add(new NGPoint2D(FX + 6, FY + 5));
        res.add(new NGPoint2D(FX + 8, FY + 5));
        res.add(new NGPoint2D(FX + 10, FY + 5));
        res.add(new NGPoint2D(FX, FY + 6));
        res.add(new NGPoint2D(FX + 2, FY + 6));
        res.add(new NGPoint2D(FX + 8, FY + 6));
        res.add(new NGPoint2D(FX + 10, FY + 6));
        res.add(new NGPoint2D(FX + 3, FY + 7));
        res.add(new NGPoint2D(FX + 4, FY + 7));
        res.add(new NGPoint2D(FX + 6, FY + 7));
        res.add(new NGPoint2D(FX + 7, FY + 7));
        return res;
    }

    public SpaceInvaderColony(Double aX, Double aY) {
        super(aX, aY);
        FColor = newColor(Color.GREEN);
        FName = "Space Invader";
    }

}
