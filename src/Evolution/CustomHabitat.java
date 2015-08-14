package Evolution;

import Evolution.Creatures.CreatureEvent;
import Evolution.Creatures.CustomCreature;
import Evolution.Creatures.CustomEvolutionProcess;
import Uniwork.Base.NGComponent;
import Uniwork.Misc.NGLogEvent;
import Uniwork.Misc.NGLogEventListener;
import Uniwork.Misc.NGLogManager;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class CustomHabitat extends NGComponent implements NGLogEventListener {

    protected ArrayList<HabitatEventListener> FEventListeners;
    protected ArrayList<CustomEvolutionProcess> FEvolutionProcesses;
    protected ArrayList<CustomCreature> FCreatures;
    protected ArrayList<HabitatCell> FCells;

    protected void InternalEvolution() {
        for (CustomEvolutionProcess ep : FEvolutionProcesses) {
            ep.Start();
            try {
                DoEvolution(ep);
            }
            finally {
                ep.End();
            }
        }
    }

    protected void DoEvolution(CustomEvolutionProcess aEvolutionProcess) {
        aEvolutionProcess.Execute();
        Iterator<CustomCreature> itr = aEvolutionProcess.getCreaturesBorn();
        while (itr.hasNext()) {
            addCreature(itr.next());
        }
        itr = aEvolutionProcess.getCreaturesDie();
        while (itr.hasNext()) {
            removeCreature(itr.next());
        }
    }

    protected synchronized void raiseCreatureAddedEvent(CustomCreature aCreature) {
        CreatureEvent event = new CreatureEvent(this, aCreature);
        for (HabitatEventListener listener : FEventListeners) {
            listener.handleCreatureAdded(event);
        }
    }

    protected synchronized void raiseCreatureRemovedEvent(CustomCreature aCreature) {
        CreatureEvent event = new CreatureEvent(this, aCreature);
        for (HabitatEventListener listener : FEventListeners) {
            listener.handleCreatureRemoved(event);
        }
    }

    protected void DoInitializeCells() {

    }

    protected void InitializeCells() {
        FCells.clear();
        DoInitializeCells();
        writeInfo(String.format("%d cells allocated", FCells.size()));
    }

    @Override
    protected void DoInitialize() {
        super.DoInitialize();
        InitializeCells();
    }

    protected void AssignToCell(CustomCreature aCreature) {

    }

    protected void InternaladdCreature(CustomCreature aCreature) {
        FCreatures.add(aCreature);
        if (FCells.size() > 0)
            AssignToCell(aCreature);
    }

    protected void UnassignFromCell(CustomCreature aCreature) {

    }

    protected void InternalremoveCreature(CustomCreature aCreature) {
        FCreatures.add(aCreature);
        if (FCells.size() > 0)
            UnassignFromCell(aCreature);
    }

    public CustomHabitat(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FLogManager = new NGLogManager();
        FLogManager.addEventListener(this);
        FEventListeners = new ArrayList<HabitatEventListener>();
        FCells = new ArrayList<HabitatCell>();
        FCreatures = new ArrayList<CustomCreature>();
        FEvolutionProcesses = new ArrayList<CustomEvolutionProcess>();
    }

    public void addEventListener(HabitatEventListener aListener)  {
        FEventListeners.add(aListener);
    }

    public void removeEventListener(HabitatEventListener aListener)   {
        FEventListeners.remove(aListener);
    }

    public void addEvolutionProcess(CustomEvolutionProcess aEvolutionProcess) {
        FEvolutionProcesses.add(aEvolutionProcess);
    }

    public void addCreature(CustomCreature aCreature) {
        InternaladdCreature(aCreature);
        raiseCreatureAddedEvent(aCreature);
        writeInfo(String.format("Creature born [%s]", aCreature.getInfo()));
    }

    public void removeCreature(CustomCreature aCreature) {
        FCreatures.remove(aCreature);
        raiseCreatureRemovedEvent(aCreature);
        writeInfo(String.format("Creature died [%s]", aCreature.getInfo()));
    }

    public void Evolution() {
        InternalEvolution();
    }

    public Iterator<CustomCreature> getCreatures() {
        return FCreatures.iterator();
    }

    public ArrayList<HabitatCell> getCells() {
        return FCells;
    }

    @Override
    public void handleAddLog(NGLogEvent e) {

    }

    @Override
    public void handleClearLog() {

    }

}
