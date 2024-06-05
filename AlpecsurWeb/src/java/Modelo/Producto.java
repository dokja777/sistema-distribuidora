package Modelo;

public class Producto {

    private int idProducto;
    private Categoria idCategoria;
    private Marca idMarca;
    private String nombre;
    private double precio;
    private int stock;
    private String descripcion;
    private String imagen;
    private String estado;

    public Producto() {
    }

    public Producto(int idProducto, Categoria categoria, Marca marca, String nombre, double precio, int stock, String descripcion, String imagen, String estado) {
        this.idProducto = idProducto;
        this.idCategoria = categoria;
        this.idMarca = marca;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.estado = estado;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Categoria getCategoria() {
        return idCategoria;
    }

    public void setCategoria(Categoria categoria) {
        this.idCategoria = categoria;
    }

    public Marca getMarca() {
        return idMarca;
    }

    public void setMarca(Marca marca) {
        this.idMarca = marca;
    }

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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
