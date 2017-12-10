import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Debug {
	private String fileName;
	private File file;
	private PrintWriter writer;
	
	public Debug(String fileName) {
		this.fileName = fileName;
		file = newFile(this.fileName);
		writer = newPrintWriter(file);
		
	}//End constructor
	
	/*
	 * Important -
	 * It is assumed that the fileName must contain ".txt" 
	 * for the method to work, otherwise it returns null.
	 * 
	 */
	
	public File newFile(String fileName) {
		if(fileName.contains(".txt")) {
			int count = 0;
			File tempFile = new File(System.getProperty("user.dir") + "/P16B_Debug/" + fileName);
			try {
				if(!tempFile.exists()) {
					file.createNewFile();
					return tempFile;
					
				}
				else{
					count++;
					newFile(fileName.substring(0, fileName.length() - 4) + count + ".txt");
					
				}
					
			}
			catch(IOException e) {
				e.printStackTrace();
				
			}
		}
		return null;
		
	}//End newFile
	
	public PrintWriter newPrintWriter(File file) {
		try {
			PrintWriter tempWriter = new PrintWriter(file);
			return tempWriter;
			
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}
		return null;
		
	}//End newPrintWriter
	
	//Get Methods
	public String getFileName() {
		return this.fileName;
		
	}//End getFileName
	
	public File getFile() {
		return this.file;
		
	}//End getFile
	
	public PrintWriter getWriter() {
		return this.writer;
		
	}//End getWriter
	
	//Set Methods
	public void setFileName(String fileName) {
		this.fileName = fileName;
		
	}//End setFileName
	
	public void setFile(File file) {
		this.file = file;
		
	}//End setFile
	
	public void setWriter(PrintWriter writer) {
		this.writer = writer;
		
	}//End setWriter
	
}//End Class
