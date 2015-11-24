package Evolution;

import Uniwork.Appl.NGApplication;

public class Main extends NGApplication {

    protected MainApplicationModule FMainModule;

    @Override
    public void DoBeforeInitialize() {
        super.DoBeforeInitialize();
        FMainModule = (MainApplicationModule)FModuleManager.addModule(MainApplicationModule.class, "Main");
        FMainModule.setPrimaryStage(FPrimaryStage);
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
        EvolutionApplicationModule module = (EvolutionApplicationModule)addModule(EvolutionApplicationModule.class, false, String.format("%d", FModuleManager.getModuleCount()));
        module.addLogListener(FMainModule.getConsole());
        module.setDescription(String.format("%d", FModuleManager.getModuleCount() - 1));
        module.Initialize();
    }

}
