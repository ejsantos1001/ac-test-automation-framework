package com.angloinfo.tools;
import java.util.*;

public class MinMaxRandom {

	
		public static int generate(int Max,int Min) {
			Random rand = new Random();
			return rand.nextInt((Max-Min)+1)+Min;
		}
}
