import java.util.Scanner;

/**
 * 
 * En esta clase se usara para imprimir el menu y llamar a las distintas
 * opciones que este te da.
 * 
 * 
 * @author Antonio Mallén
 *
 */
public class Menu {

	/**
	 * Creamos el atributo fichero para que el programa tenga el lugar donde quiere ser almacenado
	 */
	private String fichero;

	/**
	 * Creamos un nuevo Scanner con System.in como parametros para meter por teclado una de las posibles opciones
	 * que nos da el programa
	 */
	Scanner tec = new Scanner(System.in);

	/**
	 * 
	 * En el constructor creamos un bucle do-while para que nos pregunte
	 * todo el rato la opcion que queremos seleccionar, el cual se parara si
	 * introduces la opcion de parar.
	 * 
	 * @param archivo: Pedimos por parametro el nombre del archivo en 
	 * el constructor para posteriormente igualarlo a fichero
	 */
	Menu( String archivo ){
		this.fichero=archivo;
		boolean seguir=true;
		do {
			seguir=opciones();
		}while( seguir);
	}


	/**
	 * Creamos un metodo void para mostrar por pantalla todas las opciones que tiene el programa
	 */
	public void imprimirMenu() {
		System.out.println("Elija una opción\r\n"
				+ "0. Salir\r\n"
				+ "1. Añadir contacto en la agenda\r\n"
				+ "2. Borrar contacto en la agenda\r\n"
				+ "3. Listado en orden alfabetico\r\n"
				+ "4. Buscar por nombre\r\n"
				+ "5. Añadir un teléfono\r\n"
				+ "6. Borrar un teléfono\r\n"
				+ "7. Buscar por teléfono");
	}


	/**
	 * Creo un metodo booleano llamado opciones el cual, primero llamara a imprimirMenu,
	 * para mostrar las opciones, y te comprobara si has metido un numero entre el 0 y 7
	 * @return false en caso de haber introducido un numero que no esta en el rango y
	 * true en caso de que el numero este en el rango.
	 */
	public boolean opciones() {
		int opcion=0;
		imprimirMenu();
		opcion = tec.nextInt();
		if(opcion<0 || opcion>7) {
			System.out.println("Tienes que elegir una opcion entre 0 y 7");
			return true;
		}
		if(opcion == 0) {
			System.out.println("Cerrando programa");
			return false;
		}
		switch (opcion) {
		case 1: {
			annadirContacto();
			break;
		}
		case 2: {
			borrarUsuario();
			break;
		}
		case 3: {
			ordenar();
			break;
		}
		case 4: {
			buscarNombre();
			break;
		}
		case 5: {
			annadirTel();
			break;
		}
		case 6: {
			borrarTel();
			break;
		}
		case 7: {

			break;
		}
		}

		return true;
	}

	public void annadirContacto() {
		System.out.println("Dime el nombre del Contacto");
		tec.nextLine();
		String nombre=tec.nextLine();
		Contacto miContacto = new Contacto(nombre);
		Annadir nuevo = new Annadir(this.fichero,miContacto);
		if(nuevo.comprobarUsuario( nombre )) {
			nuevo.finalizar();
			System.out.println("Este usuario ya existe");
		}else {
			System.out.println("Dime el numero del trabajo del Contacto");
			String num_trabajo=tec.nextLine();
			System.out.println("Dime el numero del telefono móvil del Contacto");
			String num_movil=tec.nextLine();
			System.out.println("Dime otro de los numeros del Contacto");
			String num_otro=tec.nextLine();
			System.out.println("Dime el fax del Contacto");
			String fax=tec.nextLine();
			miContacto.añadirDatos(num_trabajo ,num_movil ,num_otro ,fax);
			nuevo.annadirUsuario();
		}
	}

	public void borrarUsuario() {
		System.out.println("Dime el nombre del usuario que quieres borrar");
		tec.nextLine();
		String nombre=tec.nextLine();
		Borrar b =new Borrar(fichero);
		b.eliminar(nombre);

	}


	public void ordenar() {
		Ordenar o = new Ordenar(fichero);
		o.ordenAlfabetico();
	}

	public void buscarNombre() {
		Buscar b = new Buscar(fichero);
		System.out.println("Dime el nombre del Usuario que quieres buscar");
		tec.nextLine();
		String nom = tec.nextLine();
		b.encontrar(nom);
	}

	public void borrarTel() {
		BorrarTel bt = new BorrarTel(fichero);
		System.out.println("Dime el numero de telefono que quiere ser eliminado");
		tec.nextLine();
		String telefono = tec.nextLine();
		bt.eliminarTel(telefono);
	}
	
	public void annadirTel() {
		AnadirTel at = new AnadirTel(fichero);
		System.out.println("Dime el nombre del usuario");
		tec.nextLine();
		String u=tec.nextLine();
		System.out.println("Dime el telefono a cambiar del usuario");
		String t=tec.nextLine();
		System.out.println("Dime el tipo de telefono a cambiar");
		String m=tec.nextLine();
		
		
		at.anadir(u, t, m);
	}


}
