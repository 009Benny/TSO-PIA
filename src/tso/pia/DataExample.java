/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tso.pia;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Benny Reyes Sosa
 */
public class DataExample {
    private Scanner scan;
    private double[][] matriz;
    private int t, caminos;
    
    public DataExample(String fileName){
        this.openFile(fileName);
        this.readFile();
        this.imprimirMatriz();
    }
    
    public void openFile(String name){
        try{
            this.scan = new Scanner(new File("src/Set1/"+name));
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void readFile(){
        int i = 0;
        String[] array = new String[0];
        while (this.scan.hasNext()){
            String a = this.scan.nextLine();
            String[] cadena = a.split("\\s+");
            if (i == 0){
                this.t = Integer.parseInt(cadena[0]);
                this.caminos = Integer.parseInt(cadena[1]);
            }else{
                double[] element = new double[3];
                element[0] = Double.parseDouble(cadena[0]);
                element[1] = Double.parseDouble(cadena[1]);
                element[2] = Double.parseDouble(cadena[2]);
                this.addElement(element);
            }
            i++;
        }
    }
    
    public void addElement(double[] element){
        if (this.matriz == null){
            this.matriz = new double[1][3];
            this.matriz[0] = element;
        }else {
            int size = this.matriz.length + 1;
            double[][] aux = this.matriz;
            this.matriz = new double[size][3];
            System.arraycopy(aux, 0, this.matriz, 0, aux.length);
            this.matriz[size - 1] = element;
        }
    }
    
    public void imprimirMatriz(){
        System.out.println("");
        System.out.println("Impresion de lista");
        System.out.println("");
        for (int i = 0; i < this.matriz.length; i++) {
            System.out.println(Arrays.toString(this.matriz[i]));
        }
    }
    
    public double[][] getMatriz(){
        return this.matriz;
    }
    
    public int getNumeroIteraciones(){
        return this.t;
    }
}
