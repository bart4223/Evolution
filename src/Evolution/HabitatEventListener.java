package Evolution;

import Evolution.Creatures.CreatureEvent;

public interface HabitatEventListener {

    void handleKillAll(HabitatEvent e);
    void handleEvolutionStart(HabitatEvent e);
    void handleEvolutionEnd(HabitatEvent e);
    void handleCreatureAdded(CreatureEvent e);
    void handleCreatureRemoved(CreatureEvent e);
    void handleCurrentEvolutionProcessChanged(HabitatEvent e);

}
