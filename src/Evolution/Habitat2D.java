package Evolution;

import Uniwork.Base.NGComponent;
import Uniwork.Misc.NGLogEvent;
import Uniwork.Misc.NGLogEventListener;

public class Habitat2D extends CustomHabitat implements NGLogEventListener {

    public Habitat2D(NGComponent aOwner, String aName) {
        super(aOwner, aName);
    }

    @Override
    public void handleAddLog(NGLogEvent e) {
        System.out.println(e.LogEntry.GetFullAsString());
    }

    @Override
    public void handleClearLog() {

    }

}
