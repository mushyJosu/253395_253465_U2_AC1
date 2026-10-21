import java.util.Comparator;
 //comparará objetos de la clase implementada
public class ComparadorPrecio implements Comparator<Producto> {

    @Override
    public int compare(Producto p1, Producto p2) {

        return Double.compare(p1.getPrecio(), p2.getPrecio());
    }
}
