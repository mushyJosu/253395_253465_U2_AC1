import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Se instancia sin parámetro porque LinkedList maneja su propio tamaño
        Almacen almacen = new Almacen();

        // Carga inicial de los productos con su metodo
        almacen.agregarProducto(new Producto("Teclado", 450.00));
        almacen.agregarProducto(new Producto("Mouse", 280.00));
        almacen.agregarProducto(new Producto("Monitor", 3200.00));
        almacen.agregarProducto(new Producto("Memoria USB", 190.00));
        almacen.agregarProducto(new Producto("Audifonos", 650.00));

        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Selecciona una opcion: ");

            switch (opcion) {
                case 1:
                    almacen.visualizarListaProductos();
                    break;

                case 2:
                    almacen.ordenarListaProductos();
                    System.out.println("\nProductos ordenados por precio:");
                    almacen.visualizarListaProductos();
                    break;

                case 3:
                    double precioABuscar = leerDouble(scanner, "Precio a buscar: ");
                    Producto encontrado = almacen.buscarProducto(precioABuscar); // Nombre según UML

                    if (encontrado != null) {
                        System.out.println("Producto encontrado: " + encontrado);
                    } else {
                        System.out.println("No se encontro un producto con ese precio.");
                    }
                    break;

                case 4:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    double nuevoPrecio = leerDouble(scanner, "Precio del producto: ");

                    boolean agregado = almacen.agregarProducto(new Producto(nombre, nuevoPrecio));

                    if (agregado) {
                        System.out.println("Producto agregado correctamente.");
                    } else {
                        System.out.println("No se pudo agregar el producto.");
                    }
                    break;

                case 0:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion no valida. Intenta de nuevo.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    //metodo auxilares para el main

    private static void mostrarMenu() {
        System.out.println("\nMenu del almacen");
        System.out.println("1. Mostrar productos");
        System.out.println("2. Ordenar productos por precio");
        System.out.println("3. Buscar producto por precio");
        System.out.println("4. Agregar producto");
        System.out.println("0. Salir");
    }

    // Valida que el usuario ingrese un numero entero para no romper el programa
    private static int leerEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no valida. Por favor, escribe un numero entero.");
            scanner.next(); // Descarta el dato incorrecto
            System.out.print(mensaje);
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpia el salto de linea sobrante en el buffer
        return valor;
    }

    // Valida que el usuario ingrese un numero decimal
    private static double leerDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.println("Entrada no valida. Por favor, escribe un numero decimal.");
            scanner.next();
            System.out.print(mensaje);
        }
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }
}