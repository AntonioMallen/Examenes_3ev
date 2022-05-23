import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Buscar {

	private String fichero;

	private String datosUsuario;

	Scanner in = null;


	public Buscar(String fichero) {
		this.fichero=fichero;
		try {
			in = new Scanner(new BufferedReader( new FileReader(fichero)));
		} catch (FileNotFoundException e) {
			System.out.println("El archivo aun no ha sido creado");
		}
	}


	public void encontrar( String nombre ) {
		if(comprobarUsuario(nombre)) {
			System.out.println(this.datosUsuario);
		}else {
			System.out.println("Este nombre aun no está en la agenda");
		}
	}


	public boolean comprobarUsuario (String nom) {
		/**
		 * Comprobamos si el archivo es nulo, si lo es devolvemos false,
		 * ya que aun no ha sido añadido el usuario
		 */
		if ( in == null )
			return false;
		boolean encontrado = false;
		/**
		 * Se va comprobando uno por uno los tokens y si alguno coincide, se hace un return de true,
		 * si ha terminado el archivo sin encontrar ninguno con el mismo nombre, se devuelve false.
		 */
		while ( ! encontrado && in.hasNext() ) {
			String nombre = in.next();
			/**
			 * En caso de que se encuentre el usuario, haremos un next para evitar el ; y guardaremos
			 * el nextLine para imprimirlo en otro metodo
			 */
			if ( nom.equals(nombre) ) {
				in.next();
				datosUsuario=in.nextLine();
				return true;
			}
			in.nextLine();
		}
		return false;
	}
}
