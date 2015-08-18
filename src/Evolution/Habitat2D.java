package Evolution;

import Evolution.Creatures.*;
import Uniwork.Base.NGComponent;
import Uniwork.Graphics.NGPoint2D;
import Uniwork.Misc.NGLogEvent;
import Uniwork.Misc.NGLogEventListener;

public class Habitat2D extends CustomHabitat implements NGLogEventListener {

    protected Integer FWidth;
    protected Integer FHeight;

    @Override
    protected void AssignToCell(CustomCreature aCreature) {
        if (aCreature instanceof Protozoa) {
            Protozoa creature = (Protozoa)aCreature;
            NGPoint2D pos = creature.getPosition();
            HabitatCell cell = FCells.get(pos.getYAsInt() * FWidth + pos.getXAsInt());
            cell.setCreature(aCreature);
        }
    }

    @Override
    protected void UnassignFromCell(CustomCreature aCreature) {
        if (aCreature instanceof Protozoa) {
            Protozoa creature = (Protozoa)aCreature;
            NGPoint2D pos = creature.getPosition();
            HabitatCell cell = FCells.get(pos.getYAsInt() * FWidth + pos.getXAsInt());
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
    public void addCellColony(CustomCellColony aCellColony, CustomEvolutionProcess aEvolutionProcess) {
        super.addCellColony(aCellColony, aEvolutionProcess);
        if (aCellColony instanceof CellColony2D) {
            for (NGPoint2D pos : ((CellColony2D)aCellColony).getPoints()) {
                addCreature(new Protozoa(this, aEvolutionProcess, pos.getXAsInt(), pos.getYAsInt()));
            }
        }
    }

    @Override
    public void handleAddLog(NGLogEvent e) {
        System.out.println(e.LogEntry.GetFullAsString());
    }

    @Override
    public void handleClearLog() {

    }

}
