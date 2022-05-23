import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Borrar {

	private String fichero;

	Scanner in=null;
	PrintStream tmp=null;

	public Borrar( String fichero ){
		this.fichero=fichero;
		try {
			in = new Scanner(new BufferedReader( new FileReader(fichero)));
			tmp = new PrintStream (new FileOutputStream("tmp.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("El contacto no esta en el archivo");
		}
	}

	public boolean comprobarUsuario (String nom) {
		/**
		 * Comprobamos si el archivo es nulo, si lo es devolvemos false,
		 * ya que aun no ha sido añadido el usuario
		 */
		if ( in == null )
			return false;
		/**
		 * Se va comprobando uno por uno los tokens y si alguno coincide, se hace un return de true,
		 * si ha terminado el archivo sin encontrar ninguno con el mismo nombre, se devuelve false.
		 */
		while (  in.hasNext() ) {
			String nombre = in.next();
			if ( nom.equals(nombre) )
				return true;
			in.nextLine();
		}
		return false;
	}


	/**
	 * Primero te comprobara si el usuario existe, si no es asi
	 * te dice que no puedes eliminarlo.
	 * 
	 * En este metodo se va recorriendo el archivo y te lo va guardando
	 * en uno temporal, en caso de encontrar el nombre, este
	 * no se pasara al temporal y finalmente, se copia todo lo del archivo temporal en el documento principal
	 * @param nombre= nombre del contacto que se quiere eliminar
	 */
	public void eliminar(String nombre) {
		if(comprobarUsuario(nombre)) {
			String users="";
			while(in.hasNext()) {
				String n= in.next();
				if( nombre.equals(n)&&in.hasNextLine()) {
					in.nextLine();
				}else {
					users= in.nextLine();
					tmp.println(n+" ; "+users);
				}
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
			System.out.println("El nombre que buscas, aun no se ha añadido");
		}
		
	}
}

