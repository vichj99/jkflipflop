
public class FlipFlop_T extends FlipFlop_JK{
	
	public FlipFlop_T() {
		super();
		if(Gates.OR(getR_FFSR(), getS_FFSR())) {
			setR_FFSR(true);
			setS_FFSR(true);
		
		}
		else{
			setR_FFSR(false);
			setS_FFSR(false);
		
		}
		
	}//End constructor
	
}//End Class
