/*
 * Rough Mobs Revamped for Minecraft Forge 1.14.4
 * 
 * This is a complete revamp of Lellson's Rough Mobs 2
 * 
 * Author: p1ut0nium_94
 * Website: https://www.curseforge.com/minecraft/mc-mods/rough-mobs-revamped
 * Source: https://github.com/p1ut0nium-git/Rough-Mobs-Revamped/tree/1.14.4
 * 
 */
package com.p1ut0nium.roughmobsrevamped.compat;

import java.util.HashMap;

import com.p1ut0nium.roughmobsrevamped.config.RoughConfig;
import com.p1ut0nium.roughmobsrevamped.reference.Constants;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;

public abstract class GameStagesCompat {
	
	private GameStagesCompat() {}
	
	private static boolean registered;

	private static Boolean useEquipmentStage;
	private static Boolean useAllStages;
	private static Boolean useBossStage;
	private static Boolean useEnchantStage;
	private static Boolean useAbilitiesStage;

	private static HashMap<String, Boolean> playerStages = new HashMap<>();
	public static HashMap<PlayerEntity, HashMap<String, Boolean>> players = new HashMap<>();

	public static void register() {
		if (registered)
			return;
		registered = true;
		preInit();
	}
	
	public static void preInit() {
	
		useAllStages = RoughConfig.useAllStages;

		// If useAllStages is true, then all other stages should also be set to true
		if (useAllStages) {
			useEquipmentStage = useBossStage = useAbilitiesStage = useEnchantStage = true;
		}
		else {
			useEquipmentStage = RoughConfig.useEquipmentStage;
			useBossStage = RoughConfig.useBossStage;
			useAbilitiesStage = RoughConfig.useAbilitiesStage;
			useEnchantStage = RoughConfig.useEnchantStage;
		}
	}
	
	public static void syncPlayerGameStages(ServerPlayerEntity player) {
		
	}
	
	public static Boolean useEquipmentStage() {
    return false;
	}

	public static Boolean useAllStages() {
		return false;
	}

	public static Boolean useBossStage() {
		return false;
	}

	public static Boolean useEnchantStage() {
		return false;
	}

	public static Boolean useAbilitiesStage() {
		return false;
	}
}
