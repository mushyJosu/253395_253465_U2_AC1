import java.util.Collections;
import java.util.LinkedList;

public class Almacen {
    private LinkedList<Producto> listaProductos;
    private Producto objetoProducto; // Representa la relación de composición del UML

    public Almacen() {
        this.listaProductos = new LinkedList<>();
    }

    public boolean agregarProducto(Producto producto) {
        if (producto == null) {
            return false;
        }
        return this.listaProductos.add(producto);
    }

    public void ordenarListaProductos() {
        Collections.sort(listaProductos, new ComparadorPrecio());
    }

    public void visualizarListaProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("NO hay productos en la lista");
            return;
        }

        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println((i + 1) + ". " + listaProductos.get(i));
        }
    }

    public Producto buscarProducto(double precioBuscado) {
        ordenarListaProductos();

        int izquierda = 0;
        int derecha = listaProductos.size() - 1;

        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            double precioMedio = listaProductos.get(medio).getPrecio();

            if (Double.compare(precioMedio, precioBuscado) == 0) {
                return listaProductos.get(medio);
            }

            if (precioMedio < precioBuscado) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return null;
    }

    public LinkedList<Producto> getListaProductos() {
        return listaProductos;
    }
}