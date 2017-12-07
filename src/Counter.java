import java.io.*;

public class Counter{
	
	//-----------BASIC DIAGRAM--------------
	//--------------------------------------
	//--------^--------------------^--------
	//--------|--------------------|--------
	//--------Q--------------------Qn-------
	//--------|--------------------|--------
	//-------NAND-----------------NAND------
	//------^----^---------------^---^------
	//------|----|---------------|---|------
	//----FIRST--|---------------|-SECOND---
	//------|----|---------------|---|------
	//-----NAND--Qn--------------Q---NAND---
	//-----^--^---------------------^--^----
	//-----|--|---------------------|--|----
	//-----OR-CLOCK[0]--------CLOCK[1]-OR---
	//----^-^--------------------------^-^--
	//----|-|--------------------------|-|--
	//---Qn-R--------------------------S-Q--
	//--------------------------------------
	//--------------------------------------
	
	public static boolean[] CLOCK = {false, false}; //This is the CLOCK that controls the pulse of the counter, you must invert the CLOCK continuously to provide a pulse.
	public static boolean S = false; //S is a manual input, it does not serve much of a purpose.
	public static boolean R = false; //R is the same as S.
	public static boolean FIRST = true; //Denotes the Product of the 1st NAND Gate
	public static boolean SECOND = true; //Denotes the Product of the 2nd NAND GATE
	public static boolean Q = true; //Denotes the Product of the 3rd NAND Gate
	public static boolean Qn = false; //Denotes the Product of the 4th NAND Gate
	
	public static void main(String[] args) {
		int count = 1;
		PrintWriter new_f = createNewFile("counter-debug.txt");
		do {
			boolean tempFIRST = FIRST;
			boolean tempSECOND = SECOND;
			boolean tempQ = Q;
			boolean tempQn = Qn;
			
			updateAll();
			
			//Debug lines of code
			System.out.println("- Iteration Number "+count+" -");
			new_f.println("- Iteration Number "+count+" -");
			System.out.println("FIRST: "+tempFIRST+" -> "+FIRST);
			new_f.println("FIRST: "+tempFIRST+" -> "+FIRST);
			System.out.println("SECOND: "+tempSECOND+" -> "+SECOND);
			new_f.println("SECOND: "+tempSECOND+" -> "+SECOND);
			System.out.println("Q: "+tempQ+" -> "+Q);
			new_f.println("Q: "+tempQ+" -> "+Q);
			System.out.println("Qn: "+tempQn+" -> "+Qn+"\n");
			new_f.println("Qn: "+tempQn+" -> "+Qn+"\n");
			count++;
			
		}
		while(Gates.AND(new_f != null, count <= 100));
		new_f.close();
		
	}//End main
	
	/**
	 * 
	 * @param fileName - The parameter expects a file name in ".txt" format. It is also important to state that the encoding format is defaulted to UTF-8.
	 * @return Returns a file under the PrintWriter class.
	 * 
	 */
	
	private static PrintWriter createNewFile(String fileName) {
		//This method is made for debug purposes
		
		try {
			PrintWriter writer = new PrintWriter(fileName, "UTF-8");
			return writer;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}//End createNewFile
	
	private static void updateAll() {
		invertCLOCK();
		FIRST = Gates.NAND(Gates.OR(Qn, R), CLOCK[0]);
		SECOND = Gates.NAND(CLOCK[1], Gates.OR(S, Q));
		Q = Gates.NAND(FIRST, Qn);
		Qn = Gates.NAND(Q, SECOND);
	
	}//End updateAll
	
	private static void invertCLOCK() {
		for(int i = 0; i < CLOCK.length; i++) {
			CLOCK[i] = Gates.NOT(CLOCK[i]);
		}
		wait(3000);
		
	}//End invertCLOCK
	
	/**
	 * 
	 * @param ms - Denotes in milliseconds, how long the program should wait.
	 * @return void
	 * 
	 */
	
	private static void wait(int ms) {
		try {
			Thread.sleep(ms);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}//End wait

}//End Counter
