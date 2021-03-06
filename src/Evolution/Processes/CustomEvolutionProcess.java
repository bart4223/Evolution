package Evolution.Processes;

import Evolution.Creatures.CustomCreature;
import Evolution.CustomHabitat;
import Uniwork.Base.NGObject;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class CustomEvolutionProcess extends NGObject {

    protected CustomHabitat FHabitat;
    protected CopyOnWriteArrayList<CustomCreature> FCreaturesToBorn;
    protected CopyOnWriteArrayList<CustomCreature> FCreaturesToDie;

    protected void DoExecute() {

    }

    protected void ToBorn(CustomCreature aCreature) {
        for (CustomCreature creature : FCreaturesToBorn) {
            if (creature.equals(aCreature))
                return;
        }
        FCreaturesToBorn.add(aCreature);
    }

    protected void ToDie(CustomCreature aCreature) {
        for (CustomCreature creature : FCreaturesToDie) {
            if (creature.equals(aCreature))
                return;
        }
        FCreaturesToDie.add(aCreature);
    }

    public CustomEvolutionProcess(CustomHabitat aHabitat) {
        super();
        FHabitat = aHabitat;
        FCreaturesToBorn = new CopyOnWriteArrayList<CustomCreature>();
        FCreaturesToDie = new CopyOnWriteArrayList<CustomCreature>();
    }

    public CustomHabitat getHabitat() {
        return FHabitat;
    }

    public String getName() {
        return "";
    }

    public void Start() {
        FCreaturesToBorn.clear();
        FCreaturesToDie.clear();
    }

    public void Execute() {
        DoExecute();
    }

    public void End() {

    }

    public String getInfo() {
        return getName();
    }

    public Iterator<CustomCreature> getCreaturesToBorn() {
        return FCreaturesToBorn.iterator();
    }

    public Iterator<CustomCreature> getCreaturesToDie() {
        return FCreaturesToDie.iterator();
    }

}
