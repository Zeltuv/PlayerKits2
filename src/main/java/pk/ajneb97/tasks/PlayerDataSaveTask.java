package pk.ajneb97.tasks;

import pk.ajneb97.PlayerKits2;

public class PlayerDataSaveTask {

    private PlayerKits2 plugin;
    private boolean end;

    public PlayerDataSaveTask(PlayerKits2 plugin) {
        this.plugin = plugin;
        this.end = false;
    }

    public void end() {
        end = true;
    }

    public void start(int seconds) {
        long ticks = seconds * 20L;

        PlayerKits2.getScheduler().runTimerAsync((wrappedTask) -> {
            if (end) {
                wrappedTask.cancel();
            } else {
                execute();
            }
        }, 1L, ticks);
    }

    public void execute() {
        plugin.getConfigsManager().getPlayersConfigManager().saveConfigs();
    }
}
