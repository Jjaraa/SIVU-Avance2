/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Master
 */
public class Venta {

    private int valor;
    private int codigo;
    private int cantidad;
    private String vendedor;

    public Venta(int valor, int codigo, int cantidad, String vendedor) {
        this.valor = valor;
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.vendedor = vendedor;
    }

    public int getValor() {
        return this.valor;
    }

    public int returnCodigo() {
        return this.codigo;
    }

    public int returnCantidad() {
        return this.cantidad;
    }
}
