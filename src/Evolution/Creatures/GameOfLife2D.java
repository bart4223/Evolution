package Evolution.Creatures;

import Evolution.CustomHabitat;
import Uniwork.Graphics.NGPoint2D;

import java.util.Iterator;

public class GameOfLife2D extends CustomEvolutionProcess {

    // Regeln
    // 1. Zelle ohne Lebewesen mit genau 3 benachbarten Zellen mit Lebewesen dann wird in dieser Zelle ein Lebewesen geboren
    // 2. Zelle mit Lebewesen und weniger als 2 benachbarten lebenden Zellen sterben
    // 3. Zelle mit Lebewesen und 2 oder 3 benachbarten lebenden Zellen bleiben leben
    // 4. Zelle mit Lebewesen und mehr als 3 benachbarten lebenden Zellen sterben

    protected void Born(double aX, double aY) {
        for (CustomCreature c : FCreaturesBorn) {
            if (c instanceof Creature2D) {
                Creature2D creature = (Creature2D)c;
                NGPoint2D pos = creature.getPosition();
                if (pos.getX() == aX && pos.getY() == aY)
                    return;
            }
        }
        Born(new Creature2D(FHabitat, this, aX, aY));
    }

    @Override
    protected void DoExecute(CustomCreature aCreature) {
        super.DoExecute(aCreature);
        Iterator<CustomCreature> itr = FHabitat.getCreatures();
        while (itr.hasNext()) {
            CustomCreature c = itr.next();
            if (c instanceof Creature2D) {
                Creature2D creature = (Creature2D) c;
            }
        }
        Born(1, 1);
    }

    public GameOfLife2D(CustomHabitat aHabitat) {
        super(aHabitat);
    }

}
