
public class FlipFlop_SR extends Latch_SR{	

	/*
	 * One important thing to know about this diagram
	 * is that Q_FFSR is the same as the inherited Q
	 * from the Latch_SR class and Qc_FFSR is the same
	 * as the inherited Qc from the same class.
	 * Because R and S were manual inputs from the 
	 * Latch_SR class, they have become FIRST and 
	 * SECOND in this class. The new manual inputs
	 * have become R_FFSR and S_FFSR. See the diagram below 
	 * for extra details.
	 * 
	 */
	
	//-----------BASIC DIAGRAM--------------
	//--------------------------------------
	//--------^--------------------^--------
	//--------|--------------------|--------
	//-----Q_FFSR---------------Qc_FFSR-----
	//-------(Q)------------------(Qc)------
	//--------|--------------------|--------
	//-------NAND-----------------NAND------
	//------^----^---------------^---^------
	//------|----|---------------|---|------
	//----FIRST--|---------------|-SECOND---
	//-----(R)---|---------------|--(S)-----
	//------|----|---------------|---|------
	//-----NAND--Qc_FFSR-----Q_FFSR-NAND---
	//-----^--^---------------------^--^----
	//-----|--|---------------------|--|----
	//-R_FFSR-CLOCK[0]----CLOCK[1]-S_FFSR---
	//--------------------------------------
	//--------------------------------------
	
	private boolean[] CLOCK;
	private boolean R_FFSR;
	private boolean S_FFSR;
	private boolean FIRST;
	private boolean SECOND;
	private boolean Q_FFSR;
	private boolean Qc_FFSR;
	
	public FlipFlop_SR() {
		CLOCK = new boolean[2]; //This is the CLOCK that controls the pulse of the counter, you must invert the CLOCK continuously to provide a pulse.
			CLOCK[0] = false;
			CLOCK[1] = false;
			
		R_FFSR = false;//Denotes a manual input R_FFSR
		S_FFSR = false;//Denotes a manual input S_FFSR
		
		FIRST = true; //Denotes the Product of the 1st NAND Gate
			setR(FIRST);
			
		SECOND = true; //Denotes the Product of the 2nd NAND GATE
			setS(SECOND);
			
		Q_FFSR = true; //Denotes the Product of the 3rd NAND Gate
			setQ(Q_FFSR);
			
		Qc_FFSR = false; //Denotes the Product of the 4th NAND Gate
			setQc(Qc_FFSR);
	
	}//End constructor
	
	@Override
	public void update(int timeElapsed) {
		for(int i = 0; i < timeElapsed; i++) {
			invertCLOCK();
			FIRST = Gates.NAND(R_FFSR, CLOCK[0]);
				setR(FIRST);
			SECOND = Gates.NAND(CLOCK[1], S_FFSR);
				setS(SECOND);
			Q_FFSR = Gates.NAND(FIRST, Qc_FFSR);
				setQ(Q_FFSR);
			Qc_FFSR = Gates.NAND(Q_FFSR, SECOND);
				setQc(Qc_FFSR);
			setTime(getTime()+1);
		}
	
	}//End updateAll
	
	public void invertCLOCK() {
		for(int i = 0; i < CLOCK.length; i++) {
			CLOCK[i] = Gates.NOT(CLOCK[i]);
		}
		
	}//End invertCLOCK
	
	public boolean[] getCLOCK() {
		return CLOCK;
		
	}//End getCLOCK
	
	public boolean getR_FFSR() {
		return R_FFSR;
		
	}//End getR_FFSR
	
	public boolean getS_FFSR() {
		return S_FFSR;
		
	}//End getS_FFSR
	
	public boolean getFIRST() {
		return getR();
		
	}//End getFIRST
	
	public boolean getSECOND() {
		return getS();
		
	}//End getSECOND
	
	public boolean getQ_FFSR() {
		return getQ();

	}//End getQ_FFSR
	
	public boolean getQc_FFSR() {
		return getQc();
		
	}//End Qc_FFSR
	
	public void setCLOCK(boolean[] newCLOCK) {
		CLOCK = newCLOCK;
		
	}//End setCLOCK
	
	public void setR_FFSR(boolean newR_FFSR) {
		R_FFSR = newR_FFSR;
		
	}//End setR_FFSR
	
	public void setS_FFSR(boolean newS_FFSR) {
		S_FFSR = newS_FFSR;
	
	}//End setS_FFSR
	
	public void setFIRST(boolean newFIRST) {
		FIRST = newFIRST;
			setR(newFIRST);
		
	}//End setFIRST
	
	public void setSECOND(boolean newSECOND) {
		SECOND = newSECOND;
			setS(newSECOND);
		
	}//End setSECOND
	
	public void setQ_FFSR(boolean newQ_FFSR) {
		setQ(newQ_FFSR);
	
	}//End setQ_FFSR
	
	public void setQc_FFSR(boolean newQc_FFSR) {
		setQc(newQc_FFSR);
		
	}//End set Qc_FFSR
	
}//End Class
