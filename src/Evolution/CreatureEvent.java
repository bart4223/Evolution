package Evolution;

public class CreatureEvent extends HabitatEvent {

    protected CustomCreature FCreature;

    public CreatureEvent(Object source, CustomCreature aCreature) {
        super(source);
        FCreature = aCreature;
    }

    public CustomCreature getCreature() {
        return FCreature;
    }

}
