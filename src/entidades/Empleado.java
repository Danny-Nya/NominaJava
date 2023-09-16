/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jose Daniel Niño
 */
public class Empleado {
    private String nombre;
    private String numCedula;
    private double salario;
    
    private static final double SLMV=800000;
    private static final double ST=90000;
    private static final double PORC_IBC=0.75;
    private static final double PORC_PENSION=0.03875;
    private static final double PORC_SALUD=0.045;
    private static final double FS=0.01;
    private static final double EXCEDE_SLMV=4;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumCedula() {
        return numCedula;
    }

    public void setNumCedula(String numCedula) {
        this.numCedula = numCedula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public static double getSLMV() {
        return SLMV;
    }
    
    public Empleado() {
    }

    public Empleado(String nombre, String numCedula, double salario) {
        this.nombre = nombre;
        this.numCedula = numCedula;
        this.salario = salario;
    }
    
    public double calcularSubTrans(){
      
        if(this.salario>(2*SLMV)){
            return 90000;
        }
        else{
            return 0;
        }
        
    }
    
    public double calcularTotalDev(){
        
        return this.salario+calcularSubTrans();
        
    }
    
    public double calcularIBC(){
        
        return calcularTotalDev()*PORC_IBC;
        
    }
    
    public double calcularPension(){
        
        return calcularIBC()*PORC_PENSION;
        
    }
    
    public double calcularSalud(){
        
        return calcularIBC()*PORC_SALUD;
        
    }
    
    public double calcularFondoSolid(){
        
        if(this.salario>(4*SLMV))
            return this.calcularIBC()*1;
        else
            return 0;
        
    }
    public double calcularTotDescuentos(){
        
        return calcularPension()+calcularFondoSolid()+calcularSalud();
        
    }
    
    public double calcularTotNomina(){
        
        return calcularTotalDev()-calcularTotDescuentos();
        
    }
    
}
