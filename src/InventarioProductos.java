//Se les ha pedido desarrollar una aplicación para llevar el inventario de productos de una pequeña tienda. 
//La tienda vende diferentes tipos de productos y necesita que el sistema registre el nombre de los productos, la cantidad en inventario y el precio por unidad. 
//Además, el sistema debe calcular el valor total del inventario y mostrar un reporte final.

// El sistema debe registrar el nombre, cantidad y precio de **al menos 5 productos**
// El sistema debe permitir agregar más productos si es necesario.
// El sistema debe incluir una opción para actualizar la cantidad de un producto si llega más inventario.
// Para cada producto, se debe calcular el valor total (cantidad * precio).
// Al final, se debe generar un reporte que muestre el valor total del inventario (sumando los valores de todos los productos).



// registrar el nombre, cantidad y precio de "al menos 5 productos"
// permitir agregar más productos si es necesario.
// incluir una opción para actualizar la cantidad de un producto si llega más inventario.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Producto {
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getValorTotal() {
        return cantidad * precio;
    }
}

public class InventarioProductos {
    private List<Producto> inventario;
    private Scanner scanner;

    public InventarioProductos() {
        inventario = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void agregarProducto() {
        while (true) {
            System.out.println("Ingrese el nombre del producto (o '0' para terminar): ");
            String nombre = scanner.nextLine();
            if (nombre.equals("0")) {
                break; // Termina el ciclo si el usuario ingresa '0'
            }

            System.out.println("Ingrese la cantidad en inventario: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el precio por unidad: ");
            double precio = Double.parseDouble(scanner.nextLine());

            inventario.add(new Producto(nombre, cantidad, precio));
            System.out.println("Producto agregado: " + nombre);
        }
    }

    public void mostrarInventario() {
        System.out.println("Inventario actual:");
        for (Producto producto : inventario) {
            System.out.printf("Producto: %s, Cantidad: %d, Precio: %.2f, Valor Total: %.2f%n",
                    producto.getNombre(), producto.getCantidad(), producto.getPrecio(), producto.getValorTotal());
        }
    }

    public void actualizarCantidadProducto() {

        System.out.println("¿Desea actualizar la cantidad de un producto? (si/no)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            System.out.println("Ingrese el nombre del producto a actualizar: ");
            String nombreProducto = scanner.nextLine();

            for (Producto producto : inventario) {
                
                if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                    System.out.println("Ingrese la nueva cantidad: ");
                    int nuevaCantidad = Integer.parseInt(scanner.nextLine());
                    producto.setCantidad(nuevaCantidad);
                    System.out.println("Cantidad actualizada para el producto: " + nombreProducto);
                    return;
                }
            }
            System.out.println("Producto no encontrado.");
        }
    }

    public static void main(String[] args) {
        InventarioProductos inventarioProductos = new InventarioProductos();
        inventarioProductos.agregarProducto();
        inventarioProductos.mostrarInventario();
        inventarioProductos.actualizarCantidadProducto();
        inventarioProductos.mostrarInventario();
    }
}