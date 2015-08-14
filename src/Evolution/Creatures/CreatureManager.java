package Evolution.Creatures;

import Uniwork.Base.NGComponent;

import java.util.ArrayList;
import java.util.Iterator;

public class CreatureManager extends NGComponent {

    protected ArrayList<CustomCreature> FCreatures;
    protected ArrayList<CustomEvolutionProcess> FEvolutionProcesses;

    protected void DoEvolution(CustomEvolutionProcess aEvolutionProcess) {
        for (CustomCreature creature : FCreatures) {
            if (creature.getEvolutionProcess().equals(aEvolutionProcess)) {
                writeInfo(String.format("Evolution of creature [%s]", creature.getInfo()));
                creature.Evolution();
            }
        }
    }

    protected void InternalEvolution() {
        for (CustomEvolutionProcess eP : FEvolutionProcesses) {
            DoEvolution(eP);
        }
    }

    public CreatureManager(NGComponent aOwner) {
        this(aOwner, "");
    }

    public CreatureManager(NGComponent aOwner, String aName) {
        super(aOwner, aName);
        FCreatures = new ArrayList<CustomCreature>();
        FEvolutionProcesses = new ArrayList<CustomEvolutionProcess>();
    }

    public void addCreature(CustomCreature aCreature) {
        FCreatures.add(aCreature);
    }

    public void removeCreature(CustomCreature aCreature) {
        FCreatures.remove(aCreature);
    }

    public Iterator<CustomCreature> getCreatures() {
        return FCreatures.iterator();
    }

    public void addEvolutionProcess(CustomEvolutionProcess aEvolutionProcess) {
        FEvolutionProcesses.add(aEvolutionProcess);
    }

    public void Evolution() {
        InternalEvolution();
    }

}
