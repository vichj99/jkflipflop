
public class FlipFlop_T extends FlipFlop_JK{
	
	//---------------BASIC DIAGRAM------------------
	//----------------------------------------------
	//------------^--------------------^------------
	//------------|--------------------|------------
	//---------Q_FFSR---------------Qc_FFSR---------
	//-----------(Q)------------------(Qc)----------
	//------------|--------------------|------------
	//-----------NAND-----------------NAND----------
	//----------^----^---------------^---^----------
	//----------|----|---------------|---|----------
	//--------FIRST--|---------------|-SECOND-------
	//---------(R)---|---------------|--(S)---------
	//----------|----|---------------|---|----------
	//---------NAND--Qc_FFSR-----Q_FFSR-NAND--------
	//---------^--^---------------------^--^--------
	//---------|--|---------------------|--|--------
	//--------OR-CLOCK[0]--------CLOCK[1]-OR--------
	//-------^-^--------------------------^-^-------
	//-------|-|--------------------------|-|-------
	//-------|-|--------------------------|-|-------
	//-Qc_FFSR-T--------------------------T-S_FFSR--
	//----------------------------------------------
	//----------------------------------------------
	
	public FlipFlop_T() {
		super(); //Invokes FlipFlop_JK Constructor
		
	}//End constructor
	
	/*
	 * (non-Javadoc)
	 * @see FlipFlop_JK#update(int)
	 * 
	 * It is important to know that the method below essentially emulates T in the Diagram above, 
	 * such that whenever R_FFSR or S_FFSR are changed, the other is ensured to be the same. 
	 * R_FFSR and S_FFSR become one synchronized boolean and as a result a T FlipFlop is made.
	 * 
	 * See FlipFlop_JK class for more diagram information.
	 * 
	 */
	
	@Override
	public void update(int timeElapsed) {
		if(Gates.OR(getR_FFSR(), getS_FFSR())) {
			setR_FFSR(true);
			setS_FFSR(true);
		
		}
		else{
			setR_FFSR(false);
			setS_FFSR(false);
		
		}
		super.update(timeElapsed);
		
	}//End update
	
}//End Class
