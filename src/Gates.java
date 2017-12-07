
public class Gates {
	final static boolean ONE = true;
	final static boolean ZERO = false;
	
	public static boolean NOT(Boolean a) {
		return !a;
		
	}
	
	public static boolean AND(Boolean a, Boolean b) {
		if(a && b) {
			return true;
		}
		return false;
	}
	
	public static boolean NAND(Boolean a, Boolean b) {
		if(NOT(AND(a, b))) {
			return true;
		}
		return false;
	}
	
	public static boolean OR(Boolean a, Boolean b) {
		if(a || b) {
			return true;
		}
		return false;
	}
	
	public static boolean NOR(Boolean a, Boolean b) {
		if(NOT(OR(a, b))) {
			return true;
		}
		return false;
	}
	
	public static boolean XOR(Boolean a, Boolean b) {
		if(OR(AND(NOT(a), b), AND(a, NOT(b)))) {
			return true;
		}
		return false;
	}
	
	public static boolean XNOR(Boolean a, Boolean b) {
		if(NOT(XOR(a, b))) {
			return true;
		}
		return false;
	}
	
	public static boolean ONLY(Boolean a, Boolean b) {
		return false;
	}
	
	
}
