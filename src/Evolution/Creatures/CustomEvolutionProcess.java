package Evolution.Creatures;

import Evolution.CustomHabitat;
import Uniwork.Base.NGObject;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class CustomEvolutionProcess extends NGObject {

    protected CustomHabitat FHabitat;
    protected ArrayList<CustomCreature> FCreaturesToBorn;
    protected ArrayList<CustomCreature> FCreaturesToDie;

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
        FCreaturesToBorn = new ArrayList<CustomCreature>();
        FCreaturesToDie = new ArrayList<CustomCreature>();
    }

    public CustomHabitat getHabitat() {
        return FHabitat;
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

    public Iterator<CustomCreature> getCreaturesToBorn() {
        return FCreaturesToBorn.iterator();
    }

    public Iterator<CustomCreature> getCreaturesToDie() {
        return FCreaturesToDie.iterator();
    }

}
