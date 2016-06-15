package util;

import java.util.Random;

public class RandomUtil {
	
	private static Random r;
	
	public static double getRandom(){
		return r.nextDouble();
	}
	
	public static int getRandom(int right){
		return getRandom(0, right);
	}
	
	public static int getRandom(int left, int right){
		return r.nextInt(right-left)+left;
	}

	public static void init(){
		r = new Random();
	}
	
	public static void init(int seed) {
		r = new Random(seed);
	}
}
