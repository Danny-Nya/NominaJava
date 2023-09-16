/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import entidades.Empleado;
/**
 *
 * @author Jose Daniel
 */
public class Empresa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empleado a=crear("Andres", "24217525", Empleado.getSLMV());
        Empleado b=crear("Adrian", "1000941330", 2*Empleado.getSLMV());
        Empleado c=crear("David", "242141525", 5*Empleado.getSLMV());
        imprimir(a);
        imprimir(b);
        imprimir(c);
        double tot=(a.calcularTotNomina()+b.calcularTotNomina()+c.calcularTotNomina());
        System.out.println("Tot. General: "+tot);
        tot=tot*0.04;
        System.out.println("SENA: "+tot);
    }
    
    public static Empleado crear(String nombre, String cedula, double salario){
        
        return new Empleado(nombre, cedula, salario);
        
    }
    
    public static void imprimir(Empleado empleado) {
        System.out.println("Nombre: "+ empleado.getNombre());
        System.out.println("Cedula: "+ empleado.getNumCedula());
        System.out.println("Tot. Devengado: "+ empleado.calcularTotalDev());
        System.out.println("Tot. Descuentos: "+ empleado.calcularTotDescuentos());
        System.out.println("Tot. Nomina: "+ empleado.calcularTotNomina());
    }
    
}
