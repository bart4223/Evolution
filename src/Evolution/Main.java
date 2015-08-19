package Evolution;

import Uniwork.Appl.NGApplication;
import Uniwork.Appl.NGCustomApplicationModule;

public class Main extends NGApplication {

    @Override
    public void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        MainApplicationModule main = (MainApplicationModule)FModuleManager.addModule(MainApplicationModule.class, "Main");
        main.setPrimaryStage(FPrimaryStage);
    }

    @Override
    protected void registerObjectRequests() {
        super.registerObjectRequests();
        registerObjectRequest("Application", this, "addEvolutionModule", "addEvolutionModule");
    }

    public Main() {
        super();
        FName = "Evolution";
        FDescription = "Evolution is a project to visualize some evolution algorithm";
        FConfigurationFilename = "resources/config.ccf";
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void addEvolutionModule() {
        NGCustomApplicationModule module = addModule(EvolutionApplicationModule.class, true, String.format("%d",FModuleManager.getModuleCount()));
    }

}
