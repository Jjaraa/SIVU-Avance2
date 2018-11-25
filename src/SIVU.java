
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Master
 */
public class SIVU {
    private ArrayList<Producto> productos;
    private ArrayList<Venta> ventas;
    private ArrayList<Vendedor> vendedores;
   

    public SIVU(){ 
        this.productos =  new ArrayList<Producto>();
        this.ventas = new ArrayList<Venta>();
        
    } 
    
    public void menuAdmin(Admin administrador){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a el Sistema de Inventario y Ventas Automatizado S.I.V.U");
        System.out.println("Eliga que accion desea realizar:");
        System.out.println("1)Crear usuario vendedor");
        System.out.println("2)Agregar producto");
        System.out.println("3)Mostrar el inventario");
        System.out.println("4)Buscar producto");
        System.out.println("5)Añadir o Disminuir el Stock de un producto");
        System.out.println("6)Aumentar o rebajar el precio de un producto");
        System.out.println("7)Mostrar estadisticas de vendedor");
        System.out.println("8)Cerrar sesión");
        int seleccion = sc.nextInt();
        seleccionAdmin(seleccion, administrador);
    }

    private void seleccionAdmin(int seleccion, Admin administrador){
        
        switch(seleccion){
            case 1:
                String nombre = preguntarString("nombre", "usuario");
                String contraseña = preguntarString("password", "usuario");
                administrador.crearUsuario(nombre, contraseña);
                break;
            case 2:
                String nombreProducto = preguntarString("nombre","producto");
                int precioProducto = preguntarInt("precio","producto");
                int stockProducto = preguntarInt("stock","producto");
                administrador.añadirProducto(nombreProducto, precioProducto, stockProducto, productos);
                break;
            case 3:
                administrador.imprimirInventario(this.productos);
                break;
            case 4:
                int codigoBusqueda = preguntarInt("codigo","producto");
                administrador.buscarProducto(codigoBusqueda,this.productos);
                break;            
            case 5:
                int codigoStock = preguntarInt("codigo","producto");
                int stock = preguntarInt("valor","stock");
                administrador.sumarStock(codigoStock,stock,this.productos);
                break;
            case 6:
                int codigoValor = preguntarInt("codigo","producto");
                int valor = preguntarInt("valor","aumento o la rebaja");
                administrador.sumarPrecio(codigoValor,valor, this.productos);
                break;
            case 7:
                String nombreVendedor = preguntarString("nombre de usuario","vendedor a buscar");
                Vendedor vendedor1 = buscarVendedores(nombreVendedor, this.vendedores);
                vendedor1.mostrarEstadisticas(ventas);
            case 8:                
                break;
            default:
                System.out.println("La elección es incorrecta, intente denuevo.");
                menuAdmin(administrador);
                break;
        }
    }
    
     public void menuUsuario(Vendedor vendedor){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido a el Sistema de Inventario y Ventas Automatizado S.I.V.U");
        System.out.println("Eliga que accion desea realizar:");
        System.out.println("1)Realizar una venta");
        System.out.println("2)Mostrar el inventario");
        System.out.println("3)Buscar producto");        
        System.out.println("4)Mostrar estadisticas");
        System.out.println("5)Cerrar sesion");
        int seleccion = sc.nextInt();
        seleccionUsuario(seleccion,vendedor);
    }

    public void seleccionUsuario(int seleccion, Vendedor vendedor){
        switch(seleccion){
            case 1:
                int codigoProducto = preguntarInt("codigo","producto a vender");
                int cantidadProducto = preguntarInt("numero (cantidad) que se venderá","producto");
                vendedor.vender(codigoProducto, cantidadProducto, productos, vendedor.getVentasUsuario());
                break;
            case 2:
                vendedor.imprimirInventario(this.productos);
                break;
            case 3:
                int codigo = preguntarInt("codigo","producto");
                vendedor.buscarProducto(codigo, this.productos);
                break;
            case 4:
                vendedor.mostrarEstadisticas(ventas);
                break;
            case 5:
                break;
            default:
                System.out.println("La elección es incorrecta, intente denuevo.");
                menuUsuario(vendedor);
                break;
        }
    }
    
    
    //Se puede reutilizar segun la pregunta
    private String preguntarString(String palabra, String palabra2){
        Scanner sc = new Scanner(System.in);
        System.out.println("Porfavor ingrese el "+palabra+" del "+palabra2);
        String word = sc.nextLine();
        return word;
    }
    
    //Se puede reutilizar segun la pregunta
    private int preguntarInt(String palabra, String palabra2){
        Scanner sc = new Scanner(System.in);
        System.out.println("Porfavor ingrese el "+palabra+" del "+palabra2);
        int valor = sc.nextInt();
        return valor;
    }
    
    public ArrayList<Venta> getVentas(){
        return this.ventas;
    }

    public ArrayList<Producto> getProductos(){
        return this.productos;
    }
    
    public ArrayList<Vendedor> getVendedores(){
        return this.vendedores;
    }
    
     public Vendedor buscarVendedores(String nombreUsuario, ArrayList<Vendedor> vendedores){
        Vendedor vendedor1 = new Vendedor(null,null);
         for(Vendedor item:vendedores){
            if(nombreUsuario.equals(item.getNombreUsuario())){
                vendedor1 = item;
            }
        }
        return vendedor1;
        
    }
    

   
    
    
   
}
