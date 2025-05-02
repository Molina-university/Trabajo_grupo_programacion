import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
// Solicitar al usuario la cantidad de productos
        System.out.print("¿Cuántos productos desea ingresar al sistema? ");
        int numProductos = scanner.nextInt();
        scanner.nextLine(); 
        
// Crear una matriz para almacenar los datos
// Para cada producto usaremos: nombre (String), cantidad (int) y precio (double)
// Como Java no permite matrices con diferentes tipos de datos, usaremos Object
        Object[][] datosProductos = new Object[numProductos][3];
        
// Ingresar datos para cada producto
        for (int i = 0; i < numProductos; i++) {

            System.out.println("Producto #" + (i + 1));
            
            System.out.print("Ingrese el nombre del producto: ");
            datosProductos[i][0] = scanner.nextLine();
            System.out.print("Ingrese la cantidad en inventario: ");
            datosProductos[i][1] = scanner.nextInt();           
            System.out.print("Ingrese el precio unitario: $");
            datosProductos[i][2] = scanner.nextDouble();
            
            scanner.nextLine(); 
        }

// Mostrar el valor total de cada producto 
        for (int i = 0; i < numProductos; i++) {
            int cantidad = (int) datosProductos[i][1];
            double precio = (double) datosProductos[i][2];
            double totalProducto = cantidad * precio;
            System.out.println("Producto: " + datosProductos[i][0] + " || Cantidad: " + datosProductos[i][1] + " || Precio unitario: " + datosProductos[i][2] + " || Total: $" + totalProducto);
        }       
// Calcular el valor total del inventario solicitado
        double valorTotalInventario = 0;
        for (int i = 0; i < numProductos; i++) {
            int cantidad = (int) datosProductos[i][1];
            double precio = (double) datosProductos[i][2];
            valorTotalInventario += cantidad * precio;
        }
            System.out.println("El valor total del inventario es: $" + valorTotalInventario);

// Se presenta al usuario un menú con tres opciones posibles
            System.out.println("¿Desea realizar otra acción?");
            System.out.println("1. Agregar más productos");
            System.out.println("2. Editar cantidad de un producto");
            System.out.println("3. Finalizar");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

// Mientras el usuario no elija finalizar (opción 3)
    while (opcion != 3) {

        // Opción 1: Agregar un nuevo producto
            if (opcion == 1) {
            // Se crea un nuevo producto en la matriz
                Object[][] nuevosDatosProductos = new Object[numProductos + 1][3];

            // Se copian los datos existentes a la nueva matriz
                for (int i = 0; i < numProductos; i++) {
                nuevosDatosProductos[i] = datosProductos[i];
                }
            // Se ingresan los datos del nuevo producto

                System.out.println("Producto #" + (numProductos + 1));
                System.out.print("Ingrese el nombre del producto: ");
                nuevosDatosProductos[numProductos][0] = scanner.nextLine();
                System.out.print("Ingrese la cantidad en inventario: ");
                nuevosDatosProductos[numProductos][1] = scanner.nextInt();
                System.out.print("Ingrese el precio unitario: $");
                nuevosDatosProductos[numProductos][2] = scanner.nextDouble();
                scanner.nextLine(); 

            // Se actualiza la matriz 
                datosProductos = nuevosDatosProductos;
                numProductos++; 

            // Se muestra de nuevo el inventario
                double nuevoTotalInventario = 0;
                for (int i = 0; i < numProductos; i++) {
                    int cantidad = (int) nuevosDatosProductos[i][1];
                    double precio = (double) nuevosDatosProductos[i][2];
                    double totalProducto = cantidad * precio;
                    nuevoTotalInventario += totalProducto;
                    System.out.println("Producto: " + nuevosDatosProductos[i][0] + " || Cantidad: " + nuevosDatosProductos[i][1] + " || Precio unitario: " + nuevosDatosProductos[i][2] + " || Total: $" + totalProducto);
                } 
                System.out.println("El valor total actualizado del inventario es: $" + nuevoTotalInventario);        
            } 
        // Opción 2: Editar la cantidad de un producto
            else if (opcion == 2) {
                // Se pide el nombre del producto cuya cantidad se desea modificar
                System.out.println("Ingrese el nombre del producto al que desea cambiar la cantidad:");
                String nombreProducto = scanner.nextLine();
                // Se busca de nuevo el producto
                for (int i = 0; i < numProductos; i++) {
                    if (datosProductos[i][0].toString().equalsIgnoreCase(nombreProducto)) {
                // Se muestra la cantidad actual y se pide la nueva
                        System.out.println("Cantidad actual: " + datosProductos[i][1]);
                        System.out.print("Ingrese la nueva cantidad: ");
                        datosProductos[i][1] = scanner.nextInt();
                        scanner.nextLine(); 
                        break; 
                    } 
                }
            // Se muestra de nuevo el inventario
                for (int i = 0; i < numProductos; i++) {
                    int cantidad = (int) datosProductos[i][1];
                    double precio = (double) datosProductos[i][2];
                    double totalProducto = cantidad * precio;
                    System.out.println("Producto: " + datosProductos[i][0] + " || Cantidad: " + datosProductos[i][1] + " || Precio unitario: " + datosProductos[i][2] + " || Total: $" + totalProducto);
                }
            // Mostrar el valor actualizado del inventario
                double nuevoTotalInventario = 0;
                for (int i = 0; i < numProductos; i++) {
                    int cantidad = (int) datosProductos[i][1];
                    double precio = (double) datosProductos[i][2];
                    nuevoTotalInventario += cantidad * precio;
                }
                System.out.println("El valor total actualizado del inventario es: $" + nuevoTotalInventario);
            }        
        // Mostrar el menú de nuevo
        System.out.println("¿Desea realizar otra acción?");
        System.out.println("1. Agregar más productos");
        System.out.println("2. Editar cantidad de un producto");
        System.out.println("3. Finalizar");
        opcion = scanner.nextInt();
        scanner.nextLine();    
    }
    scanner.close();
    } 
}