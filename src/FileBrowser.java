import java.io.File;
import java.util.Scanner;


public class FileBrowser {
	static File f;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String ruta = sc.nextLine();
		f = new File(ruta);
		if (f.exists()){ 
			File[] fs = f.listFiles();
			for (File fa: fs){
				System.out.println(fa.getName());
			}
		} else { 
			System.out.println("Error en la ruta");
		}
		
	}
	
}
