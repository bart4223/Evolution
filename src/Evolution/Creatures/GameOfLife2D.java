package Evolution.Creatures;

import Evolution.CustomHabitat;
import Evolution.Habitat2D;
import Evolution.HabitatCell;
import Uniwork.Graphics.NGPoint2D;

import java.util.ArrayList;

public class GameOfLife2D extends CustomEvolutionProcess {

    // Regeln
    // 1. Zelle ohne Lebewesen mit genau 3 benachbarten Zellen mit Lebewesen dann wird in dieser Zelle ein Lebewesen geboren
    // 2. Zelle mit Lebewesen und weniger als 2 benachbarten lebenden Zellen sterben
    // 3. Zelle mit Lebewesen und 2 oder 3 benachbarten lebenden Zellen bleiben leben
    // 4. Zelle mit Lebewesen und mehr als 3 benachbarten lebenden Zellen sterben

    protected Integer FWidth;
    protected Integer FHeight;

    protected void ToBornProtozoa(double aX, double aY) {
        for (CustomCreature c : FCreaturesToBorn) {
            if (c instanceof Protozoa) {
                Protozoa creature = (Protozoa)c;
                NGPoint2D pos = creature.getPosition();
                if (pos.getX() == aX && pos.getY() == aY)
                    return;
            }
        }
        ToBorn(new Protozoa(FHabitat, this, aX, aY));
    }

    protected Integer getNeighborCount(int aX, int aY) {
        Integer res = 0;
        ArrayList<HabitatCell> cells = FHabitat.getCells();
        for (int offsety = -1; offsety <= 1; offsety++) {
            for (int offsetx = -1; offsetx <= 1; offsetx++) {
                if (offsetx != 0 || offsety != 0) {
                    int x = aX + offsetx;
                    int y = aY + offsety;
                    if (x >= 0 && x < FWidth && y >= 0 && y < FHeight) {
                        HabitatCell cell = cells.get(y * FWidth + x);
                        if (cell.getCreature() != null)
                            res++;
                    }
                }
            }
        }
        return res;
    }

    @Override
    protected void DoExecute() {
        ArrayList<HabitatCell> cells = FHabitat.getCells();
        for (int y = 0; y < FHeight; y++) {
            for (int x = 0; x < FWidth; x++) {
                int neighborCount = getNeighborCount(x, y);
                if (neighborCount > 0) {
                    //System.out.println(String.format("%d[%d,%d]", neighborCount, x, y));
                }
                HabitatCell cell = cells.get(y * FWidth + x);
                CustomCreature creature = cell.getCreature();
                if (creature == null) {
                    //Cell without creature
                    if (neighborCount == 3)
                        ToBornProtozoa(x, y);
                }
                else {
                    //Cell with creature
                    if (neighborCount < 2 || neighborCount > 3) {
                        ToDie(creature);
                    }
                }
            }
        }
    }

    public GameOfLife2D(CustomHabitat aHabitat) {
        super(aHabitat);
        FWidth = ((Habitat2D)FHabitat).getWidth();
        FHeight = ((Habitat2D)FHabitat).getHeight();
        FName = "Game of Life";
    }

}
