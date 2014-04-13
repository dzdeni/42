public class isEqual {
	
	private final static double EPSILON = 0.00001;

	/**
	 * You should not do this.
	 * 
	 * The reason you shouldn't check floats for equality is that floating point numbers are not perfectly precise -- there's some inaccuracy in storage with some numbers, such as those that extended too far into the mantissa and repeating decimals (note that I'm talking about repeating decimals in base 2). You can think of this imprecision as "rounding down". The digits that extend beyond the precision of the floating-point number are truncated, effectively rounding down.
	 * If it has not changed, it will keep that equality. However, if you change it even slightly, you probably should not use equalities, but instead a range like (x < 0.0001 && x > -.0001).
	 * In short: as long as you're not playing with x at a very small level, it's OK.
	 * 
	 * @see http://stackoverflow.com/questions/7180952/is-checking-a-double-for-equality-ever-safe
	 */
	public static boolean isEqualWrong(float a, float b) {
		return a == b;
	}
	
	/**
	 * Instead isEqualWrong you should do this.
	 * 
	 */
	public static boolean isEqualRight(float a, float b) {
		return Math.abs(a-b) < EPSILON;
	}

}