
public class FlipFlop_D extends FlipFlop_SR{
	
	//-----------BASIC DIAGRAM---------------------
	//---------------------------------------------
	//--------^--------------------^---------------
	//--------|--------------------|---------------
	//-----Q_FFSR---------------Qc_FFSR------------
	//-------(Q)------------------(Qc)-------------
	//--------|--------------------|---------------
	//-------NAND-----------------NAND-------------
	//------^----^---------------^---^-------------
	//------|----|---------------|---|-------------
	//----FIRST--|---------------|-SECOND----------
	//-----(R)---|---------------|--(S)------------
	//------|----|---------------|---|-------------
	//-----NAND--Qc_FFSR-----Q_FFSR-NAND-----------
	//-----^--^---------------------^--^-----------
	//-----|--|---------------------|--|-----------
	//-R_FFSR-CLOCK[0]--------CLOCK[1]-NOT(R_FFSR)-
	//---------------------------------------------
	//---------------------------------------------
	
	public FlipFlop_D() {
		super();//Invokes FlipFlop_SR Constructor
		
	}//End constructor
	
	/*
	 * (non-Javadoc)
	 * @see FlipFlop_SR#update(int)
	 * 
	 * It is important to know that the method below essentially emulates D 
	 * Flip Flop in the Diagram above, such that whatever R_FFSR is, S_FFSR 
	 * is changed to be the be the negation of R_FFSR. 
	 * 
	 * See FlipFlop_SR class for more diagram information.
	 * 
	 */
	
	@Override
	public void update(int timeElapsed) {
		setS_FFSR(Gates.NOT(getR_FFSR()));
		super.update(timeElapsed);
		
	}//End update
	
}//End Class
