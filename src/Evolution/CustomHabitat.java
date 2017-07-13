package Evolution;

import Evolution.Biotopes.CustomBiotope;
import Evolution.Creatures.*;
import Evolution.Processes.CustomEvolutionProcess;
import Uniwork.Base.NGComponent;
import Uniwork.Misc.*;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class CustomHabitat extends NGComponent implements NGTickListener {

    protected CopyOnWriteArrayList<HabitatEventListener> FEventListeners;
    protected CopyOnWriteArrayList<CustomEvolutionProcess> FEvolutionProcesses;
    protected CopyOnWriteArrayList<CustomCreature> FCreatures;
    protected CopyOnWriteArrayList<HabitatCell> FCells;
    protected Integer FGenerationCount;
    protected Integer FMaxCreatureCount;
    protected Double FMaxCreatureAge;
    protected NGTickGenerator FTick;
    protected CustomEvolutionProcess FCurrentEvolutionProcess;

    protected void InternalEvolution() {
        for (CustomEvolutionProcess ep : FEvolutionProcesses) {
            if (FCurrentEvolutionProcess == null || FCurrentEvolutionProcess.equals(ep)) {
                DoEvolutionStart(ep);
                try {
                    DoEvolution(ep);
                }
                finally {
                    DoEvolutionEnd(ep);
                }
            }
        }
    }

    protected void DoEvolutionStart(CustomEvolutionProcess aEvolutionProcess) {
        raiseEvolutionStartEvent();
        aEvolutionProcess.Start();
    }

    protected void UpdateMaxCreatureCount() {
        if (FCreatures.size() > FMaxCreatureCount)
            FMaxCreatureCount = FCreatures.size();
    }

    protected void UpdateGenerationCount() {
        FGenerationCount++;
    }

    protected void UpdateMaxCreatureAge() {
        Double maxAge = 0.0;
        for (CustomCreature creature : FCreatures) {
            if (maxAge < creature.getAge())
                maxAge = creature.getAge();
        }
        FMaxCreatureAge = maxAge;
    }

    protected void DoEvolutionEnd(CustomEvolutionProcess aEvolutionProcess) {
        aEvolutionProcess.End();
        UpdateGenerationCount();
        UpdateMaxCreatureCount();
        UpdateMaxCreatureAge();
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

    protected synchronized void raiseKillAllEvent() {
        HabitatEvent event = new HabitatEvent(this);
        for (HabitatEventListener listener : FEventListeners) {
            listener.handleKillAll(event);
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

    protected synchronized void raiseCurrentEvolutionProcessChangedEvent() {
        HabitatEvent event = new HabitatEvent(this);
        for (HabitatEventListener listener : FEventListeners) {
            listener.handleCurrentEvolutionProcessChanged(event);
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

    protected CustomEvolutionProcess getEvolutionProcess(String aName) {
        for (CustomEvolutionProcess ep : FEvolutionProcesses) {
            if (ep.getName().equals(aName))
                return ep;
        }
        return null;
    }

    protected void removeAllCreatures() {
        while (FCreatures.size() > 0) {
            removeCreature(FCreatures.get(0));
        }
    }

    protected void MainTickOff() {
        FTick.SetItemEnabled("Main", false);
    }

    protected void MainTickOn() {
        FTick.SetItemEnabled("Main", true);
    }

    public CustomHabitat(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FLogManager = new NGLogManager();
        FTick = new NGTickGenerator(10);
        FTick.NewItem("Main", 10);
        FTick.addListener("Main", this);
        FEventListeners = new CopyOnWriteArrayList<HabitatEventListener>();
        FCells = new CopyOnWriteArrayList<HabitatCell>();
        FCreatures = new CopyOnWriteArrayList<CustomCreature>();
        FEvolutionProcesses = new CopyOnWriteArrayList<CustomEvolutionProcess>();
        FGenerationCount = 0;
        FMaxCreatureCount = 0;
        FMaxCreatureAge = 0.0;
        FCurrentEvolutionProcess = null;
    }

    public synchronized void KillAll() {
        MainTickOff();
        FGenerationCount = 0;
        FMaxCreatureCount = 0;
        FMaxCreatureAge = 0.0;
        removeAllCreatures();
        raiseKillAllEvent();
    }

    public void addEventListener(HabitatEventListener aListener)  {
        FEventListeners.add(aListener);
    }

    public void removeEventListener(HabitatEventListener aListener) {
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

    public synchronized void Evolution() {
        if (FCreatures.size() > 0)
            InternalEvolution();
    }

    public Iterator<CustomCreature> getCreatures() {
        return FCreatures.iterator();
    }

    public synchronized CopyOnWriteArrayList<CustomCreature> getCreaturesAsArray() {
        CopyOnWriteArrayList<CustomCreature> res = (CopyOnWriteArrayList<CustomCreature>)FCreatures.clone();
        return res;
    }

    public CopyOnWriteArrayList<HabitatCell> getCells() {
        return FCells;
    }

    public Integer getCreatuesCount() {
        return FCreatures.size();
    }

    public Integer getMaxCreatuesCount() {
        return FMaxCreatureCount;
    }

    public Integer getGenerationCount() {
        return FGenerationCount;
    }

    public Double getMaxCreatureAge() {
        return FMaxCreatureAge;
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

    public Boolean IsInReproduction() {
        return FTick.GetItemEnabled("Main");
    }

    public void addCellColony(CustomCellColony aCellColony) {
        writeInfo(5, String.format("Cell colony \"%s\" with evolution process \"%s\" added", aCellColony.getInfo(), FCurrentEvolutionProcess.getInfo()));
    }

    public void addBiotope(CustomBiotope aBiotope) {
        writeInfo(5, String.format("Add biotope %s with evolution process \"%s\"", aBiotope.getInfo(), FCurrentEvolutionProcess.getInfo()));
        Iterator<CustomCellColony> itr = aBiotope.getColonies();
        while (itr.hasNext()) {
            addCellColony(itr.next());
        }
    }

    public void setLogLevel(Integer aLogLevel) {
        FLogManager.setLogLevel(aLogLevel);
    }

    public Boolean InReproduction() {
        return FTick.GetItemEnabled("Main");
    }

    public CustomEvolutionProcess getCurrentEvolutionProcess() {
        return FCurrentEvolutionProcess;
    }

    public void setCurrentEvolutionProcess(String aName) {
        FCurrentEvolutionProcess = getEvolutionProcess(aName);
        raiseCurrentEvolutionProcessChangedEvent();
    }

    public void setTick(Integer aTick) {
        Boolean on = FTick.GetItemEnabled("Main");
        if (on)
            MainTickOff();
        try {
            FTick.SetItemInterval("Main", aTick);
        }
        finally {
            if (on)
                MainTickOn();
        }
    }

    public void addLogListener(NGLogEventListener aLogListener) {
        FLogManager.addEventListener(aLogListener);
    }

    public void removeLogListener(NGLogEventListener aLogListener) {
        FLogManager.removeEventListener(aLogListener);
    }

}
