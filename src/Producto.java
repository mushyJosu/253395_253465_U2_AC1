public class Producto {
    private String nombre;
    private double precio;
//constructor
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
//metodos getter y setter
    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public double getPrecio() {

        return precio;
    }

    public void setPrecio(double precio) {

        this.precio = precio;
    }
//se sobreescribe para imprimir el tipo
    @Override
    public String toString() {
        return nombre + " - $" + String.format("%.2f", precio);
    }
}
