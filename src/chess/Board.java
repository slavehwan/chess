package chess;

public class Board {

	String returnLine = System.getProperty("line.separator");
	String line = "........";

	public Object draw() {
		return line + returnLine + line + returnLine + line + returnLine + line + returnLine + line + returnLine + line
				+ returnLine + line + returnLine + line + returnLine;
	}

}