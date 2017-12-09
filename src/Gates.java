
public class Gates {
	final private static boolean ONE = true;
	final private static boolean ZERO = false;
	
	public static boolean NOT(Boolean a) {
		return !a;
		
	}//End NOT
	
	public static boolean AND(Boolean a, Boolean b) {
		if(a && b) {
			return ONE;
		
		}
		return ZERO;
	
	}//End AND
	
	public static boolean NAND(Boolean a, Boolean b) {
		if(NOT(AND(a, b))) {
			return ONE;
		
		}
		return ZERO;
	
	}//End NAND
	
	public static boolean OR(Boolean a, Boolean b) {
		if(a || b) {
			return ONE;
		
		}
		return ZERO;
	
	}//End OR
	
	public static boolean NOR(Boolean a, Boolean b) {
		if(NOT(OR(a, b))) {
			return ONE;
		
		}
		return ZERO;
		
	}//End NOR
	
	public static boolean XOR(Boolean a, Boolean b) {
		if(OR(AND(NOT(a), b), AND(a, NOT(b)))) {
			return ONE;
		
		}
		return ZERO;
	
	}//END XOR
	
	public static boolean XNOR(Boolean a, Boolean b) {
		if(NOT(XOR(a, b))) {
			return ONE;
		
		}
		return ZERO;
	
	}//End XNOR
	
	public static boolean ONLY(Boolean a, Boolean b) {
		return ZERO;
	
	}//End ONLY
	
	
}//End Class
