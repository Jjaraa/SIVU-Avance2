
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
public class Vendedor {
    private String nombreUsuario;
    private String contraseña; 
    private ArrayList<Venta> ventasUsuario;
    
    public Vendedor(String nombreUsuario, String contraseña){
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }
    
    public String getNombreUsuario(){
        return this.nombreUsuario;
    }
    
    public String getContraseña(){
        return this.contraseña;
    }
    
    public ArrayList<Venta> getVentasUsuario(){
        return this.ventasUsuario;
    }
    
    //se creó un "mostrarVender" para que muestre el precioTotal */
    public void vender(int codigo, int cantidad, ArrayList<Producto> productos, ArrayList<Venta> ventas){
        int precioTotal;
       
        for(Producto item:productos){
            if(codigo == item.getCodigo()){
                item.sumarStock(-cantidad);
                precioTotal = item.getPrecio()*cantidad;
                codigo = item.getCodigo();
                ventas.add(new Venta(precioTotal, codigo, cantidad,this.nombreUsuario)); 
                mostrarVender(precioTotal);
            }
        }
    }
    
      private void mostrarVender(int precioTotal){
        System.out.println("El valor total de la venta es de : "+(precioTotal));
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
    
  
    
    //la cantidad de ventas que se realizaron por el usuario en esa sesión 
    public int totalVentas(ArrayList<Venta> ventas){
        return ventas.size();    
    
    }
    
    public void mostrarTotalVentas(int total){
        System.out.println("El numero de ventas para el usuario "+this.nombreUsuario+" es de: "+total);
    }
    //la cantidad de productos vendidos por el usuario en esa sesión
    public int cantidadVendida(ArrayList<Venta> ventas){
        int cantidadVendida = 0;
        for(Venta item: ventas){
            cantidadVendida += item.returnCantidad();
        }
        return cantidadVendida;
    }
    public void mostrarCantidadVendida(int total){
        System.out.println("La cantidad total de productos vendidos por el usuario "+this.nombreUsuario+" es de: "+total);
    }
    //el valor total que se vendio entre todos los productos vendidos por el usuario en esa sesión
    public int valorVendido(ArrayList<Venta> ventas){
        int valorVendido = 0;
        for(Venta item: ventas){
            valorVendido += item.getValor();
        }
        return valorVendido;
    }
    
    public void mostrarValorVendido(int total){
        System.out.println("El valor total vendido por el usuario "+this.nombreUsuario+" es de: $"+total+" pesos");
    }
    //el porcentaje de productos vendidos por el usuario comparados con el total de los productos vendidos por todos los usuarios
   
    public double porcentajeVendido(ArrayList<Venta> ventasUsuario, ArrayList<Venta> ventasTotales){
        int total = 0; 
        int totalUsuario = cantidadVendida(ventasUsuario);
        for(Venta item2: ventasTotales){
            total += item2.returnCantidad();
        }
        double porcentaje = (totalUsuario*100)/total;
        return porcentaje; 
    }
    
    public void mostrarProcentajeVentas(double porcentaje){
        System.out.println("El usuario "+this.nombreUsuario+" vendió un "+porcentaje+"% de las ventas totales");
    }
    
    //el porcentaje de su valor total vendido entre todos los productos del usuario, comparado con el total vendido entre todos
    public double porcentajeValorVentas(ArrayList<Venta> ventasUsuario, ArrayList<Venta> ventasTotales){
        int totalUsuario = valorVendido(ventasUsuario);
        int total = 0;
        for(Venta item2: ventasTotales){
            total += item2.getValor();
        }
        double porcentajeValor = (totalUsuario*100)/total; 
        return porcentajeValor;
    }
    
    public void mostrarPorcentajeValorVentas(double porcentajeValor){
        System.out.println("El usuario "+this.nombreUsuario+" ha vendido un "+porcentajeValor+"% del total vendido");
    }
    
    public void mostrarEstadisticas(ArrayList<Venta> ventasTotales){
        int ventas = totalVentas(this.ventasUsuario);
        mostrarTotalVentas(ventas);
        int vendido = cantidadVendida(this.ventasUsuario);
        mostrarCantidadVendida(vendido);
        int valor = valorVendido(this.ventasUsuario);
        mostrarValorVendido(valor);
        double porcentaje = porcentajeVendido(ventasUsuario, ventasTotales);
        mostrarProcentajeVentas(porcentaje);
        double valorVenta = porcentajeValorVentas(ventasUsuario, ventasTotales);
        mostrarPorcentajeValorVentas(valorVenta);
    }
}
