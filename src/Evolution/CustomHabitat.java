package Evolution;

import Evolution.Creatures.*;
import Uniwork.Base.NGComponent;
import Uniwork.Graphics.NGPoint2D;
import Uniwork.Misc.*;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class CustomHabitat extends NGComponent implements NGLogEventListener, NGTickListener {

    protected ArrayList<HabitatEventListener> FEventListeners;
    protected ArrayList<CustomEvolutionProcess> FEvolutionProcesses;
    protected ArrayList<CustomCreature> FCreatures;
    protected ArrayList<HabitatCell> FCells;
    protected Integer FGenerationCount;
    protected NGTickGenerator FTick;

    protected void InternalEvolution() {
        for (CustomEvolutionProcess ep : FEvolutionProcesses) {
            DoEvolutionStart(ep);
            try {
                DoEvolution(ep);
            }
            finally {
                DoEvolutionEnd(ep);
            }
        }
    }

    protected void DoEvolutionStart(CustomEvolutionProcess aEvolutionProcess) {
        raiseEvolutionStartEvent();
        aEvolutionProcess.Start();
    }

    protected void DoEvolutionEnd(CustomEvolutionProcess aEvolutionProcess) {
        aEvolutionProcess.End();
        FGenerationCount++;
        raiseEvolutionEndEvent();
    }

    protected void DoEvolution(CustomEvolutionProcess aEvolutionProcess) {
        aEvolutionProcess.Execute();
        Iterator<CustomCreature> itr = aEvolutionProcess.getCreaturesToBorn();
        while (itr.hasNext()) {
            addCreature(itr.next());
        }
        itr = aEvolutionProcess.getCreaturesToDie();
        while (itr.hasNext()) {
            removeCreature(itr.next());
        }
    }

    protected synchronized void raiseEvolutionStartEvent() {
        HabitatEvent event = new HabitatEvent(this);
        for (HabitatEventListener listener : FEventListeners) {
            listener.handleEvolutionStart(event);
        }
    }

    protected synchronized void raiseEvolutionEndEvent() {
        HabitatEvent event = new HabitatEvent(this);
        for (HabitatEventListener listener : FEventListeners) {
            listener.handleEvolutionEnd(event);
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
        FTick.Initialize();
        InitializeCells();
    }

    @Override
    protected void DoFinalize() {
        FTick.Finalize();
        super.DoFinalize();
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
        FCreatures.remove(aCreature);
        if (FCells.size() > 0)
            UnassignFromCell(aCreature);
    }

    public CustomHabitat(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FLogManager = new NGLogManager();
        FLogManager.addEventListener(this);
        FTick = new NGTickGenerator(10);
        FTick.NewItem("Main", 20);
        FTick.addListener("Main", this);
        FEventListeners = new ArrayList<HabitatEventListener>();
        FCells = new ArrayList<HabitatCell>();
        FCreatures = new ArrayList<CustomCreature>();
        FEvolutionProcesses = new ArrayList<CustomEvolutionProcess>();
        Reset();
    }

    public void Reset() {
        FGenerationCount = 0;
        removeCreatures();
    }

    public void removeCreatures() {
        for (CustomCreature creature : FCreatures) {
            removeCreature(creature);
        }
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
        writeInfo(10, String.format("Creature born [%s]", aCreature.getInfo()));
    }

    public void removeCreature(CustomCreature aCreature) {
        InternalremoveCreature(aCreature);
        raiseCreatureRemovedEvent(aCreature);
        writeInfo(10, String.format("Creature died [%s]", aCreature.getInfo()));
    }

    public void Evolution() {
        InternalEvolution();
    }

    public Iterator<CustomCreature> getCreatures() {
        return FCreatures.iterator();
    }

    public synchronized ArrayList<CustomCreature> getCreaturesAsArray() {
        ArrayList<CustomCreature> res = (ArrayList<CustomCreature>)FCreatures.clone();
        return res;
    }

    public ArrayList<HabitatCell> getCells() {
        return FCells;
    }

    public Integer getCreatuesCount() {
        return FCreatures.size();
    }

    public Integer getGenerationCount() {
        return FGenerationCount;
    }

    @Override
    public void handleAddLog(NGLogEvent e) {

    }

    @Override
    public void handleClearLog() {

    }

    @Override
    public void handleTick(NGTickEvent e) {
        if (e.Name.equals("Main")) {
            Evolution();
        }
    }

    public void ToggleReproduction() {
        FTick.SetItemEnabled("Main", !FTick.GetItemEnabled("Main"));
    }

    public void addCellColony(CustomCellColony aCellColony, CustomEvolutionProcess aEvolutionProcess) {

    }

}
