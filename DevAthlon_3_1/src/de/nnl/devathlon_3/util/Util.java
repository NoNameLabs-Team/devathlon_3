package de.nnl.devathlon_3.util;

import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.Bukkit;


public class Util {

	public static Random RANDOM;
	public static Logger LOGGER;
	
	static {
		RANDOM = new Random();
		LOGGER = Bukkit.getLogger();
	}
}
