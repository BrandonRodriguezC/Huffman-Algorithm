
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Process process;
	
	public static void main(String[] args) throws IOException {
		
		pc2Read(); // No se envía nombre de archivo por que la entrada es por
					// consola C:\Users\sg701-01\Documents\Task\pc2\src\taller.java
	}
	
	public static void pc2Read() throws IOException {
		String line;
		char vec[] = null;
		BufferedReader buffer = new BufferedReader(new InputStreamReader(
				System.in));

		try {
			while ((line = buffer.readLine()).length() > 0) {
				process= new Process();
				vec = line.toCharArray();
				process.listInformation(vec);
			}
		} catch (NullPointerException e) {
		}
		buffer.close();
	}
}