package Evolution;

public interface HabitatEventListener {

    void handleCreatureAdded(CreatureEvent e);
    void handleCreatureRemoved(CreatureEvent e);

}
