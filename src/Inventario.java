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
            System.out.println("Producto #" + (i+1));
            
            System.out.print("Ingrese el nombre del producto: ");
            datosProductos[i][0] = scanner.nextLine();
            
            System.out.print("Ingrese la cantidad en inventario: ");
            datosProductos[i][1] = scanner.nextInt();
            
            System.out.print("Ingrese el precio unitario: $");
            datosProductos[i][2] = scanner.nextDouble();
            
            scanner.nextLine(); 
        }
        scanner.close(); // Cerrar el scanner
    }
}