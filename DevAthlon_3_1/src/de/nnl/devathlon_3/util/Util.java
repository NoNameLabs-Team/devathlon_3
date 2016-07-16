package de.nnl.devathlon_3.util;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;


public class Util {

	public static Random RANDOM;
	public static Logger LOGGER;
	
	static {
		RANDOM = new Random();
		LOGGER = Bukkit.getLogger();
	}
	
	public static DyeColor randomDyeColor(){
		switch(RANDOM.nextInt(16)){
		case 0: return DyeColor.BLUE;
		case 1: return DyeColor.BROWN;
		case 2: return DyeColor.CYAN;
		case 3: return DyeColor.GRAY;
		case 4: return DyeColor.GREEN;
		case 5: return DyeColor.LIGHT_BLUE;
		case 6: return DyeColor.LIME;
		case 7: return DyeColor.MAGENTA;
		case 8: return DyeColor.ORANGE;
		case 9: return DyeColor.PINK;
		case 10: return DyeColor.PURPLE;
		case 11: return DyeColor.RED;
		case 12: return DyeColor.SILVER;
		case 13: return DyeColor.WHITE;
		case 14: return DyeColor.YELLOW;
		case 16: return DyeColor.BLACK;
		}
		return DyeColor.BLACK;
	}
	
	/**
	 * Calculates the distance of two blocks
	 * @param x1
	 * @param y1
	 * @param z1
	 * @param x2
	 * @param y2
	 * @param z2
	 * @return
	 */
	public static double distance(int x1, int y1, int z1, int x2, int y2, int z2){
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
	}
	
}
