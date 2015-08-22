package Evolution.Processes;

import Evolution.Creatures.CustomCreature;
import Evolution.Creatures.Protozoa;
import Evolution.CustomHabitat;
import Evolution.Habitat2D;
import Evolution.HabitatCell;
import Uniwork.Graphics.NGPoint2D;
import Uniwork.Misc.NGRandomGenerator;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ModuloTwo2D extends CustomEvolutionProcess {

    // Regeln
    // 1. Zelle ohne Lebewesen und 1,3,5,7 benachbarten Zellen mit Lebewesen dann wird in dieser Zelle ein Lebewesen geboren
    // 2. Zelle mit Lebewesen und 0,2,4,6,8 benachbarten lebenden Zellen sterben

    protected Integer FWidth;
    protected Integer FHeight;

    protected void ToBornProtozoa(double aX, double aY, Color aColor) {
        for (CustomCreature c : FCreaturesToBorn) {
            if (c instanceof Protozoa) {
                Protozoa creature = (Protozoa)c;
                NGPoint2D pos = creature.getPosition();
                if (pos.getX() == aX && pos.getY() == aY)
                    return;
            }
        }
        Protozoa protozoa = new Protozoa(FHabitat, this, aX, aY, aColor);
        ToBorn(protozoa);
    }

    protected ArrayList<CustomCreature> getNeighbors(int aX, int aY) {
        ArrayList<CustomCreature> res = new ArrayList<CustomCreature>();
        ArrayList<HabitatCell> cells = FHabitat.getCells();
        for (int offsety = -1; offsety <= 1; offsety++) {
            for (int offsetx = -1; offsetx <= 1; offsetx++) {
                if (offsetx != 0 || offsety != 0) {
                    int x = aX + offsetx;
                    int y = aY + offsety;
                    if (x >= 0 && x < FWidth && y >= 0 && y < FHeight) {
                        HabitatCell cell = cells.get(y * FWidth + x);
                        CustomCreature creature = cell.getCreature();
                        if (creature != null)
                            res.add(creature);
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
                ArrayList<CustomCreature> neighbors = getNeighbors(x, y);
                HabitatCell cell = cells.get(y * FWidth + x);
                CustomCreature creature = cell.getCreature();
                if (creature == null) {
                    //Cell without creature
                    if (neighbors.size() % 2 == 1)
                        ToBornProtozoa(x, y, neighbors.get(NGRandomGenerator.GlobalRandomGenerator.getInteger(0, neighbors.size() - 1)).getColor());
                }
                else {
                    //Cell with creature
                    if (neighbors.size() % 2 == 0) {
                        ToDie(creature);
                    }
                }
            }
        }
    }

    public ModuloTwo2D(CustomHabitat aHabitat) {
        super(aHabitat);
        FWidth = ((Habitat2D)FHabitat).getWidth();
        FHeight = ((Habitat2D)FHabitat).getHeight();
    }

    @Override
    public String getName() {
        return "Modulo Two";
    }

}
