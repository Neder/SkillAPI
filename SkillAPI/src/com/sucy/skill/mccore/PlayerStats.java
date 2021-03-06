package com.sucy.skill.mccore;

import com.rit.sucy.scoreboard.StatHolder;
import com.sucy.skill.SkillAPI;
import com.sucy.skill.language.StatNodes;
import com.sucy.skill.skills.PlayerSkills;

import java.util.HashMap;
import java.util.Map;

public class PlayerStats implements StatHolder {

    private PlayerSkills player;

    public PlayerStats(PlayerSkills player) {
        this.player = player;
    }

    /**
     * @return map of stats for the scoreboard
     */
    @Override
    public Map<String, Integer> getStats() {
        SkillAPI plugin = player.getAPI();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put(plugin.getMessage(StatNodes.HEALTH, true), (int)plugin.getServer().getPlayer(player.getName()).getHealth());
        if (plugin.isManaEnabled()) map.put(plugin.getMessage(StatNodes.MANA, true), player.getMana());
        map.put(plugin.getMessage(StatNodes.POINTS, true), player.getPoints());
        map.put(plugin.getMessage(StatNodes.LEVEL, true), player.getLevel());
        map.put(plugin.getMessage(StatNodes.EXP, true), player.getExp());
        return map;
    }
}
