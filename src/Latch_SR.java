
public class Latch_SR {
	
	//--------BASIC-DIAGARAM--------
	//------------------------------
	//------------------------------
	//--------^-----------^---------
	//--------|-----------|---------
	//--------Q-----------Qc--------
	//--------|-----------|---------
	//-------NAND--------NAND-------
	//-------^--^--------^--^-------
	//-------|--|--------|--|-------
	//-------R--Qc-------Q--S-------
	//------------------------------
	//------------------------------
	
	private boolean R;//Reset
	private boolean S;//Set
	private boolean Q;//Q
	private boolean Qc;//Q compliment
	private int time;
	
	public Latch_SR() {
		time = 0;
		R = false;
		S = false;
		Q = false;
		Qc = true;
		
	}//End Constructor
	
	public void update(int timeElapsed) {
		for(int i = 1; i <= timeElapsed; i++) {
			Q = Gates.NAND(R, Qc);
			Qc = Gates.NAND(Q, S);
			time++;
		
		}
		
	}//End update
	
	public boolean getR() {
		return R;
		
	}//End getR
	
	public boolean getS() {
		return S;
		
	}//End getS
	
	public boolean getQ() {
		return Q;
		
	}//End getQ
	
	public boolean getQc() {
		return Qc;
		
	}//End getQc
	
	public int getTime() {
		return time;
		
	}//End getTime
	
	public void setR(boolean newR) {
		R = newR;
	
	}//End setR
	
	public void setS(boolean newS) {
		S = newS;
		
	}//End setS
	
	public void setQ(boolean newQ) {
		Q = newQ;
		
	}//End setQ
	
	public void setQc(boolean newQc) {
		Qc = newQc;
		
	}//End setQc
	
	public void setTime(int newTime) {
		time = newTime;
	
	}//End setTime

}//End Class
