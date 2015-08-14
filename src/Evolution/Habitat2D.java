package Evolution;

import Evolution.Creatures.Creature2D;
import Evolution.Creatures.CustomCreature;
import Uniwork.Base.NGComponent;
import Uniwork.Graphics.NGPoint2D;
import Uniwork.Misc.NGLogEvent;
import Uniwork.Misc.NGLogEventListener;

public class Habitat2D extends CustomHabitat implements NGLogEventListener {

    protected Integer FWidth;
    protected Integer FHeight;

    @Override
    protected void AssignToCell(CustomCreature aCreature) {
        if (aCreature instanceof Creature2D) {
            Creature2D creature = (Creature2D)aCreature;
            NGPoint2D pos = creature.getPosition();
            HabitatCell cell = FCells.get(pos.getYAsInt() + pos.getXAsInt());
            cell.setCreature(aCreature);
        }
    }

    @Override
    protected void UnassignFromCell(CustomCreature aCreature) {
        if (aCreature instanceof Creature2D) {
            Creature2D creature = (Creature2D)aCreature;
            NGPoint2D pos = creature.getPosition();
            HabitatCell cell = FCells.get(pos.getYAsInt() + pos.getXAsInt());
            cell.setCreature(null);
        }
    }

    @Override
    protected void DoInitializeCells() {
        for (int i = 0; i < FHeight * FWidth; i++) {
            FCells.add(new HabitatCell());
        }
    }

    public Habitat2D(NGComponent aOwner, String aName, Integer aWitdh, Integer aHeight) {
        super(aOwner, aName);
        FWidth = aWitdh;
        FHeight = aHeight;
    }

    public Integer getWidth() {
        return FWidth;
    }

    public Integer getHeight() {
        return FHeight;
    }

    @Override
    public void handleAddLog(NGLogEvent e) {
        System.out.println(e.LogEntry.GetFullAsString());
    }

    @Override
    public void handleClearLog() {

    }

}
