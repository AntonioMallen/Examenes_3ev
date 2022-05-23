import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

public class BorrarTel {


	private String fichero;

	Scanner in = null;
	PrintStream tmp = null;

	String resto="";


	public BorrarTel(String fichero) {
		this.fichero=fichero;
		try {
			in = new Scanner(new BufferedReader( new FileReader(fichero)));
			tmp = new PrintStream (new FileOutputStream("tmp.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("El archivo aun no ha sido creado");
		}
	}



	public boolean comprobarTelefono (String nom) {
		/**
		 * Comprobamos si el archivo es nulo, si lo es devolvemos false,
		 * ya que no se puede borrar algo de un archivo que no existe.
		 */
		if ( in == null )
			return false;
		/**
		 * Se va comprobando uno por uno los tokens y si alguno coincide, se hace un return de true,
		 * si ha terminado el archivo sin encontrar ninguno con el mismo numero de telefono, se devuelve false.
		 */
		while (  in.hasNext() ) {
			String nombre = in.next();
			if ( nom.equals(nombre) ) {	
				return true;
			}
			if(nombre.equals("fax")) {
				resto+=nombre+" ";
				resto+=in.next();
				tmp.println(resto);
				resto="";
			}else {
				resto+=nombre+" ";
			}
		}
		return false;
	}



	public void eliminarTel(String telefono) {
		/**
		 * Lo cerramos para que empiece desde el principio del fichero
		 */
		if(comprobarTelefono(telefono)) {
			tmp.print(resto);
			String users="";
			while(in.hasNext()) {

				String n=in.nextLine();
				tmp.println(n);
			}



			Scanner templectura= null;
			PrintStream tempescritura= null;
			try {
				templectura = new Scanner(
						new BufferedReader(
								new FileReader("tmp.txt")));
				tempescritura = new PrintStream (new FileOutputStream(fichero));
			} catch (FileNotFoundException e1) {

			}
			while(templectura.hasNext()) {
				String ntemp= templectura.nextLine();
				tempescritura.println(ntemp);
			}
			templectura.close();
			tempescritura.close();
	}else {
		System.out.println("El numero que se quiere eliminar aun no existe");
	}
}


}
