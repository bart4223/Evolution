package Evolution;

import java.util.EventObject;

public class HabitatEvent extends EventObject {

    protected CustomHabitat FHabitat;

    public HabitatEvent(Object source) {
        super(source);
        FHabitat = (CustomHabitat)source;
    }

    public CustomHabitat getHabitat() {
        return FHabitat;
    }

}