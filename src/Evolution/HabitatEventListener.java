package Evolution;

import Evolution.Creatures.CreatureEvent;

public interface HabitatEventListener {

    void handleCreatureAdded(CreatureEvent e);
    void handleCreatureRemoved(CreatureEvent e);

}
