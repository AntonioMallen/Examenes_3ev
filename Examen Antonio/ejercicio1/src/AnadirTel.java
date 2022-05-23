import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class AnadirTel {

	private String fichero;
	
	Scanner in = null;
	PrintStream tmp=null;
	
	public AnadirTel( String fichero){
		this.fichero=fichero;
		try {
			in = new Scanner(new BufferedReader( new FileReader(fichero)));
			tmp = new PrintStream (new FileOutputStream("tmp.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("El archivo aun no ha sido creado");
		}
	}
	
	
	
	
	public void anadir(String nombre, String num, String tipo) {
		while(in.hasNext()) {
			String n= in.next();
			tmp.print(n+" ");
			
			if( nombre.equals(n)) {
				if(tipo.equals("trabajo")) {
					tmp.print(in.next());
					tmp.print(" "+in.next());
					tmp.print(" "+num);
					
				}
				else if(tipo.equals("móvil")) {
					tmp.print(in.next());
					tmp.print(" "+in.next());
					tmp.print(" "+in.next());
					tmp.print(" "+in.next());
					tmp.print(" "+in.next());
					tmp.print(" "+num);
				}
				else if(tipo.equals("otro")) {
					tmp.print(in.next());
					tmp.print(" "+in.next());
					tmp.print(" "+in.next());
					tmp.print(" "+in.next());
					tmp.print(" "+in.next());
					tmp.print(" "+in.next());
					tmp.print(" "+in.next());
					tmp.print(" "+in.next());
					tmp.print(" "+in.next());
					tmp.print(" "+num);
				}else {
					System.out.println("Tipo no admitido");
				}
			}
			if(nombre.equals("fax")) {
				tmp.print(n+" ");
				tmp.println(in.next());
				tmp.println();
			}
			
			
		}
	}
	
	
}
