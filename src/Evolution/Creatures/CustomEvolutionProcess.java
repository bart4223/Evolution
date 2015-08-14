package Evolution.Creatures;

import Evolution.CustomHabitat;
import Uniwork.Base.NGObject;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class CustomEvolutionProcess extends NGObject {

    protected CustomHabitat FHabitat;
    protected ArrayList<CustomCreature> FCreaturesBorn;
    protected ArrayList<CustomCreature> FCreaturesDie;

    protected void DoExecute(CustomCreature aCreature) {

    }

    protected void Born(CustomCreature aCreature) {
        FCreaturesBorn.add(aCreature);
    }

    protected void Die(CustomCreature aCreature) {
        for (CustomCreature creature : FCreaturesDie) {
            if (creature.equals(aCreature))
                return;
        }
        FCreaturesDie.add(aCreature);
    }

    public CustomEvolutionProcess(CustomHabitat aHabitat) {
        super();
        FHabitat = aHabitat;
        FCreaturesBorn = new ArrayList<CustomCreature>();
        FCreaturesDie = new ArrayList<CustomCreature>();
    }

    public CustomHabitat getHabitat() {
        return FHabitat;
    }

    public void Start() {
        FCreaturesBorn.clear();
        FCreaturesDie.clear();
    }

    public void Execute(CustomCreature aCreature) {
        DoExecute(aCreature);
    }

    public void End() {

    }

    public Iterator<CustomCreature> getCreaturesBorn() {
        return FCreaturesBorn.iterator();
    }

    public Iterator<CustomCreature> getCreaturesDie() {
        return FCreaturesDie.iterator();
    }

}
