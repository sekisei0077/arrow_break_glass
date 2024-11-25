package net.acecore.arrow_break_glass;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.Objects;

public class main implements Listener {
    @EventHandler
    public void onProjectileHitEvent(ProjectileHitEvent event){
        if(Objects.equals(String.valueOf(event.getEntityType()), "ARROW")){
            Block test = event.getHitBlock();
            if(can_break_block.check_can_break(glasses.translate_from_type_name(String.valueOf(test.getType())))){
                test.breakNaturally();
                event.getEntity().remove();
                /*
                Bukkit.broadcastMessage(String.valueOf(event.getEntityType()));
                Bukkit.broadcastMessage(String.valueOf(test));
                Bukkit.broadcastMessage(glasses.translate_from_type_name(String.valueOf(test.getType())));
                */
                //TODO:ブロックの位置をファイルに保存
            }
        }
    }

    //TODO:コマンドから受ける再設置プログラムの作成
}
