
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Master
 */
public class Admin {

    private String nombreUsuario;
    private String contraseña;
    private int contador;

    

    public String getNombreUsuario(){
        return this.nombreUsuario;
    }
    
    public String getContraseña(){
        return this.contraseña;
    }

    public Admin(String nombre, String contraseña){
        this.nombreUsuario = nombre;
        this.contraseña = contraseña;
    }
    
//método para crear los usuarios vendedores
    public void crearUsuario(String nombreUsuario, String contraseña) {
        Vendedor usuario1 = new Vendedor(nombreUsuario, contraseña);
    }
    
    
    
    //método para añadir productos al inventario
  public  void añadirProducto(String nombre, int precio, int stock, ArrayList<Producto> productos){
        productos.add(new Producto(nombre,precio,stock,this.contador));
        this.contador++;
    }

   public String toString(ArrayList<Producto> productos) {
        String s="";
        s+="El inventario contiene:\n";
        for (Producto item:productos) {
            s+='\n'+item.toString();
        }
        return s;
    }
   //método para mostrar el inventario de productos
    public void imprimirInventario(ArrayList<Producto> productos){
        System.out.println(toString(productos));
    }
    
    //método para buscar los productos en el inventario
     public void buscarProducto(int codigo, ArrayList<Producto> productos){
        for(Producto item:productos){
            if(codigo == item.getCodigo()){
                System.out.println("Se ha encontrado el item con el código : "+codigo);
                item.toString();
            }
        }
    }
     //método para editar el stock de un producto
        public void sumarStock(int codigo, int valor, ArrayList<Producto> productos){
        for(Producto item:productos){
            if(codigo == (item.getCodigo())){
                item.sumarStock(valor);
            }
        }
    }
    
    //método para editar el precio de un producto    
    public void sumarPrecio(int codigo, int valor, ArrayList<Producto> productos){
        for(Producto item:productos){
            if(codigo == (item.getCodigo())){
                item.sumarPrecio(valor);
            }
        }
    }
    
    public void mostrarEstadisticasUsuario(ArrayList<Venta> ventasTotales, Vendedor vendedor){
        vendedor.mostrarEstadisticas(ventasTotales);
    }
    
}
