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

public class GameOfLife2D extends CustomEvolutionProcess {

    // Regeln
    // 1. Zelle ohne Lebewesen mit genau 3 benachbarten Zellen mit Lebewesen dann wird in dieser Zelle ein Lebewesen geboren
    // 2. Zelle mit Lebewesen und weniger als 2 benachbarten lebenden Zellen sterben
    // 3. Zelle mit Lebewesen und 2 oder 3 benachbarten lebenden Zellen bleiben leben
    // 4. Zelle mit Lebewesen und mehr als 3 benachbarten lebenden Zellen sterben

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
                    if (neighbors.size() == 3)
                        ToBornProtozoa(x, y, neighbors.get(NGRandomGenerator.GlobalRandomGenerator.getInteger(0, neighbors.size() - 1)).getColor());
                }
                else {
                    //Cell with creature
                    if (neighbors.size() < 2 || neighbors.size() > 3)
                        ToDie(creature);
                    else
                        creature.Mature();
                }
            }
        }
    }

    public GameOfLife2D(CustomHabitat aHabitat) {
        super(aHabitat);
        FWidth = ((Habitat2D)FHabitat).getWidth();
        FHeight = ((Habitat2D)FHabitat).getHeight();
    }

    @Override
    public String getName() {
        return "Game of Life";
    }

}
