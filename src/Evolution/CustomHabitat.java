package Evolution;

import Uniwork.Base.NGComponent;
import Uniwork.Misc.NGLogEvent;
import Uniwork.Misc.NGLogEventListener;
import Uniwork.Misc.NGLogManager;

import java.util.ArrayList;

public abstract class CustomHabitat extends NGComponent implements NGLogEventListener {

    protected CreatureManager FCreatureManager;

    protected ArrayList<HabitatEventListener> FEventListeners;

    protected void addCreature(CustomCreature aCreature) {
        FCreatureManager.addCreature(aCreature);
        raiseCreatureAddedEvent(aCreature);
        writeInfo(String.format("Creature added [%s]", aCreature.getInfo()));
    }

    protected synchronized void raiseCreatureAddedEvent(CustomCreature aCreature) {
        CreatureEvent event = new CreatureEvent(this, aCreature);
        for (HabitatEventListener listener : FEventListeners) {
            listener.handleCreatureAdded(event);
        }
    }

    public CustomHabitat(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FCreatureManager = new CreatureManager(this);
        FLogManager = new NGLogManager();
        FLogManager.addEventListener(this);
        FEventListeners = new ArrayList<HabitatEventListener>();
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

    @Override
    public void handleAddLog(NGLogEvent e) {

    }

    @Override
    public void handleClearLog() {

    }

}
