
public class FlipFlop_JK extends FlipFlop_SR{
	
	/*
	 * One important thing to know about this diagram
	 * is that Q_FFSR is the same as the inherited Q
	 * from the Latch_SR class and Qc_FFSR is the same as
	 * the inherited Qc from the same class.
	 * Because R and S were manual inputs from the 
	 * Latch_SR class, they have become FIRST and 
	 * SECOND in this class. The new manual inputs
	 * have become R1 and S1. See the diagram below 
	 * for extra details.
	 * 
	 */
	
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
	//-Qc_FFSR-R_FFSR----------------Q_FFSR-S_FFSR--
	//----------------------------------------------
	//----------------------------------------------
	
	
	public FlipFlop_JK() {
		super();//Invokes FlipFlop_SR Constructor
		
	}//End constructor
	
	@Override
	public void update(int timeElapsed) {
		for(int i = 0; i < timeElapsed; i++) {
			invertCLOCK();
			setFIRST(Gates.NAND(Gates.OR(getQc_FFSR(), getR_FFSR()), getCLOCK()[0]));
			setSECOND(Gates.NAND(getCLOCK()[1], Gates.OR(getS_FFSR(), getQ_FFSR())));
			setQ_FFSR(Gates.NAND(getFIRST(), getQc_FFSR()));
			setQc_FFSR(Gates.NAND(getQ_FFSR(), getSECOND()));
			setTime(getTime()+1);
		
		}
	
	}//End update
	
}//End Class
