package net.acecore.arrow_break_glass;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class can_break_block {
    private static Map<String, String> block_map = new HashMap<>();
    public static void reset() {
        block_map.put("glass", "false");
        block_map.put("white_stained_glass", "false");
        block_map.put("orange_stained_glass", "false");
        block_map.put("magenta_stained_glass", "false");
        block_map.put("light_blue_stained_glass", "false");
        block_map.put("yellow_stained_glass", "false");
        block_map.put("lime_stained_glass", "false");
        block_map.put("pink_stained_glass", "false");
        block_map.put("gray_stained_glass", "false");
        block_map.put("light_gray_stained_glass", "false");
        block_map.put("cyan_stained_glass", "false");
        block_map.put("blue_stained_glass", "false");
        block_map.put("purple_stained_glass", "false");
        block_map.put("red_stained_glass", "false");
        block_map.put("green_stained_glass", "false");
        block_map.put("black_stained_glass", "false");
        block_map.put("tinted_glass", "false");
        block_map.put("glass_pane", "false");
        block_map.put("white_stained_glass_pane", "false");
        block_map.put("orange_stained_glass_pane", "false");
        block_map.put("magenta_stained_glass_pane", "false");
        block_map.put("light_blue_stained_glass_pane", "false");
        block_map.put("yellow_stained_glass_pane", "false");
        block_map.put("lime_stained_glass_pane", "false");
        block_map.put("pink_stained_glass_pane", "false");
        block_map.put("gray_stained_glass_pane", "false");
        block_map.put("light_gray_stained_glass_pane", "false");
        block_map.put("cyan_stained_glass_pane", "false");
        block_map.put("blue_stained_glass_pane", "false");
        block_map.put("purple_stained_glass_pane", "false");
    }
    public static boolean read(){
        String filePath = Arrow_break_glass.saveFolderPath + "/setting.properties";
        File dataFile = new File(filePath);
        if (!dataFile.exists()) {
            return false; // ファイルが存在しない場合はnullを返す
        }

        Properties properties = new Properties();
        try (FileReader reader = new FileReader(filePath)) {
            properties.load(reader);

            for (String i : glasses.get_all_glasses_name()){
                String x = properties.getProperty(i);
                block_map.put(i,x);
            }
            return true;
        } catch (NumberFormatException e) {
            System.err.println("設定の読み取りに失敗しました: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("ファイル読み込み中にエラーが発生しました: " + e.getMessage());
        }
        return false;
    }

    public static boolean check_can_break(String name){
        if (block_map.get(name) != null){
            return Boolean.parseBoolean(block_map.get(name));
        }
        return false;
    }
}
