package Evolution;

import Evolution.Creatures.CreatureEvent;
import Evolution.Creatures.CreatureManager;
import Evolution.Creatures.CustomCreature;
import Evolution.Creatures.CustomEvolutionProcess;
import Uniwork.Base.NGComponent;
import Uniwork.Misc.NGLogEvent;
import Uniwork.Misc.NGLogEventListener;
import Uniwork.Misc.NGLogManager;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class CustomHabitat extends NGComponent implements NGLogEventListener {

    protected CreatureManager FCreatureManager;

    protected ArrayList<HabitatEventListener> FEventListeners;
    protected ArrayList<CustomEvolutionProcess> FEvolutionProcesses;

    protected void addCreature(CustomCreature aCreature) {
        FCreatureManager.addCreature(aCreature);
        raiseCreatureAddedEvent(aCreature);
        writeInfo(String.format("Creature born [%s]", aCreature.getInfo()));
    }

    protected void removeCreature(CustomCreature aCreature) {
        FCreatureManager.removeCreature(aCreature);
        raiseCreatureRemovedEvent(aCreature);
        writeInfo(String.format("Creature died [%s]", aCreature.getInfo()));
    }

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
        FCreatureManager.Evolution(aEvolutionProcess);
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

    public CustomHabitat(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FLogManager = new NGLogManager();
        FLogManager.addEventListener(this);
        FEventListeners = new ArrayList<HabitatEventListener>();
        FCreatureManager = new CreatureManager(this);
        FCreatureManager.setLogManager(FLogManager);
        FEvolutionProcesses = new ArrayList<CustomEvolutionProcess>();
    }

    public CreatureManager getCreatureManager() {
        return FCreatureManager;
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

    public void Evolution() {
        InternalEvolution();
    }

    @Override
    public void handleAddLog(NGLogEvent e) {

    }

    @Override
    public void handleClearLog() {

    }

}
