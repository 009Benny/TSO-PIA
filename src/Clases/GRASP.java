/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author 52812
 */
public class GRASP {
    private Scanner in;
    private Grafo myGrafo;
    private int t, n, initialPoint;
    private int[][] results;
    
    public GRASP(Grafo obj, int iteraciones){
        this.in = new Scanner(System.in);
        this.t = iteraciones;
        this.myGrafo = obj;
        this.n = this.myGrafo.getElementsLength();
//        System.out.println("");
//        System.out.println("Ingresa el punto inicial");
//        this.initialPoint = this.in.nextInt();
        this.initialPoint = 0;
        this.calcular();
    }
    
    public void calcular(){
        System.out.println("");
        System.out.println("");
        System.out.println("GRASP");
        int soluciones = 0;
        boolean validacion = false;
        do{
            int[] camino = new int[this.t];
            double[] initialPoint = this.myGrafo.getElementOfIndex(this.initialPoint);
            System.out.println("Se inicia desde el punto (x: " + initialPoint[0] + " ,y: " + initialPoint[1] + ")");
            int actual = this.initialPoint;
            for (int i = 0; i < this.t; i++) {
                int[] mejores = this.myGrafo.getLowestValues(actual, 5);
                System.out.println(Arrays.toString(mejores));
                double total = 0;
                double random = Math.random();
                for (int j = 0; j < mejores.length; j++) {
                    total += this.myGrafo.getScoreAtIndex(mejores[j]);
                }
                double suma = 0;
                int seleccionado = mejores.length;
                double[] probabilidades = new double[mejores.length];
                for (int j = 0; j < mejores.length; j++) {
                    probabilidades[j] = this.myGrafo.getScoreAtIndex(mejores[j]) / total ;
                    suma += probabilidades[j];
                    if (seleccionado == mejores.length && suma > random){
                        seleccionado = j;
                    }
                }

                //Preparar
                camino[i] = seleccionado;
                actual = seleccionado;
            }
            this.addElement(camino);
            if (this.results != null){
                System.out.println("No es nulo");
                if(this.results.length > 1){
                    System.out.println("ya esta haciendo validacion");
                    System.out.println( this.myGrafo.getTotalScore(this.results[soluciones]) );
                    System.out.println( this.myGrafo.getTotalScore(this.results[soluciones - 1]) );
                    validacion = ( this.myGrafo.getTotalScore(this.results[soluciones]) <= this.myGrafo.getTotalScore(this.results[soluciones - 1]) );
                }
            }
            soluciones ++;
        }while(!validacion);
        
        System.out.println("");
        System.out.println("Mejores");
        System.out.println("");
        for (int i = 0; i < this.results.length; i++) {
            System.out.println(Arrays.toString(this.results[i]));
        }
        
    }
    
    public void addElement(int[] element){
        if (this.results == null){
            this.results = new int[1][this.t];
            this.results[0] = element;
        }else {
            int size = this.results.length + 1;
            int[][] aux = this.results;
            this.results = new int[size][this.t];
            System.arraycopy(aux, 0, this.results, 0, aux.length);
            this.results[size - 1] = element;
        }
    }
    
}
