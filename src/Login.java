
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
public class Login {    
    SIVU sivu;

    public void preguntarTipoUsuario() {
        Scanner sc = new Scanner(System.in);
        int eleccion;
        boolean estado = false;
        do {
            System.out.println("Bienvenido a S.I.V.U");
            System.out.println("¿Que tipo de usuario va a ingresar?");
            System.out.println("1)Administrador");
            System.out.println("2)Vendedor");
            System.out.println("3)Salir");
            eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    loginAdmin();
                    break;
                case 2:
                    loginVendedor();
                    break;
                case 3:
                    System.out.println("Gracias por usar S.I.V.U");
                    estado = true;
                    break;
                default:
                    break;
            }
        } while (!estado);

    }

//como aun no se implementa el gestor de archivos, solo se creará un administrador nuevo en vez de leerlo en el archivo        
    private void loginAdmin() {
        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        Admin administrador = new Admin("usernameReal","passwordReal");
        boolean estado = false;
        do {
            System.out.println("Ingrese el nombre de usuario");
            username = sc.next();
            System.out.println("Ingrese la contraseña");
            password = sc.next();
            if (username.equals(administrador.getNombreUsuario()) && password.equals(administrador.getContraseña())) {
                System.out.println("Ha ingresado las credenciales correctas. Bienvenido a S.I.V.U");

                estado = true;

            } else {
                System.out.println("Ha ingresado las credenciales incorrectas, intente denuevo");
            }
        } while (!estado);
        sivu.menuAdmin(administrador);
    }

    private void loginVendedor() {
        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        Vendedor vendedor = new Vendedor("usernameReal","passwordReal");
        boolean estado = false;
        do {
            System.out.println("Ingrese el nombre de usuario");
            username = sc.next();
            System.out.println("Ingrese la contraseña");
            password = sc.next();
            if (username.equals(vendedor.getNombreUsuario()) && password.equals(vendedor.getContraseña())) {
                System.out.println("Ha ingresado las credenciales correctas. Bienvenido a S.I.V.U");

                estado = true;

            } else {
                System.out.println("Ha ingresado las credenciales incorrectas, intente denuevo");
            }
        } while (!estado);
        sivu.menuUsuario(vendedor);
    } 
}
