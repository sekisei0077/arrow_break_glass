package net.acecore.arrow_break_glass;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class Arrow_break_glass extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        // location.json ファイルが存在しない場合は作成
        // 保存先のフォルダパス (適宜変更)
        String saveFolderPath = "plugins/arrow-break-glass";
        File saveFolder = new File(saveFolderPath);
        saveFolder.mkdirs();
        List<String> filenames = glasses.get_all_glasses_name();
        String filePath;
        Properties properties = new Properties();
        for (String i : filenames) {
            properties.setProperty(i, String.valueOf(true));
            filePath = saveFolderPath + "/" + i + ".csv";
            File save_file = new File(filePath);
            if(!save_file.exists()){
                try {
                    save_file.createNewFile();
                } catch (IOException e) {
                    getLogger().severe(i+".csv ファイルの作成に失敗しました: " + e.getMessage());
                }
            }
        }
        String setting_filePath = saveFolderPath + "/setting.properties";
        File setting_dataFile = new File(setting_filePath);
        if (!setting_dataFile.exists()) {
            try {
                setting_dataFile.createNewFile();
                getLogger().info("setting.properties ファイルを作成しました");
                try (OutputStream out = new FileOutputStream(setting_filePath)) {
                    properties.store(out, "settings");
                }catch (IOException e){
                    System.err.println("not created setting file");
                }
            } catch (IOException e) {
                getLogger().severe("setting.properties ファイルの作成に失敗しました: " + e.getMessage());
            }
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
