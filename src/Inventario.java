import java.util.Scanner;

public class Inventario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar al usuario la cantidad de productos
        System.out.print("¿Cuántos productos desea ingresar? ");
        int numProductos = scanner.nextInt();
        scanner.nextLine(); 
        
        // Crear una matriz para almacenar los datos
        // Para cada producto almacenaremos: nombre (String), cantidad (int) y precio (double)
        // Como Java no permite matrices con diferentes tipos de datos, usaremos Object[][]
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
        // Se inicializa la variable totalProducto para almacenar el valor total de cada producto
        for (int i = 0; i < numProductos; i++) {
            int cantidad = (int) datosProductos[i][1];
            double precio = (double) datosProductos[i][2];
            double totalProducto = cantidad * precio;

            System.out.println("Producto: " + datosProductos[i][0] + " || Total: $" + totalProducto);
        }       
// Calcular el valor total del inventario solicitado
        // Se inicializa la variable valorTotalInventario para almanecenar el valor total
        double valorTotalInventario = 0;
        for (int i = 0; i < numProductos; i++) {
            int cantidad = (int) datosProductos[i][1];
            double precio = (double) datosProductos[i][2];
            valorTotalInventario += cantidad * precio;
        }
            System.out.println("El valor total del inventario es: $" + valorTotalInventario);

// Se solicita al usuario si va a agregar más productos, "si" si el usuario desea seguir inventariando y "no" si desea finalizar el programa

            System.out.println("¿Desea agregar más productos? Escriba 'si' para continuar o 'no' para finalizar.");

            String respuesta = scanner.nextLine();
        while (respuesta.equalsIgnoreCase("si")) {
            Object[][] nuevosDatosProductos = new Object[numProductos + 1][3];
            
        // Se copian los datos anteriores a la nueva matriz que es la que se va a usar para almacenar los nuevos datos 
            for (int i = 0; i < numProductos; i++) {
                nuevosDatosProductos[i] = datosProductos[i];
            }
            
            System.out.println("Producto #" + (numProductos + 1));
            
            System.out.print("Ingrese el nombre del producto: ");
            nuevosDatosProductos[numProductos][0] = scanner.nextLine();
            
            System.out.print("Ingrese la cantidad en inventario: ");
            nuevosDatosProductos[numProductos][1] = scanner.nextInt();
            
            System.out.print("Ingrese el precio unitario: $");
            nuevosDatosProductos[numProductos][2] = scanner.nextDouble();
            
            scanner.nextLine(); 

            datosProductos = nuevosDatosProductos;
            numProductos++;
            
// Se calcula de nuevo el valor total del inventario con los nuevos datos anteriormente agregados
// Se inicializa la variable valorTotalInventario para almacenar el valor total
            valorTotalInventario = 0;
            for (int i = 0; i < numProductos; i++) {
                int cantidad = (int) datosProductos[i][1];
                double precio = (double) datosProductos[i][2];
                valorTotalInventario += cantidad * precio;
            }
            
            System.out.println("El valor total del inventario con los nuevos productos es: $" + valorTotalInventario);
            System.out.println("¿Desea agregar más productos? Escriba 'si' para continuar o 'no' para indicar que el inventario ha sido registrado exitosamente. ");
            respuesta = scanner.nextLine();
        }
        
        scanner.close(); 
    }
}