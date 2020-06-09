/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.Arrays;

/**
 *
 * @author 52812
 */
public class Grafo {
    private double[][] lista;
    private double[][] matriz;
    
    public Grafo(double[][] obj){
        this.lista = obj;
        this.createEuclidesMatriz();
        this.imprimirMatriz();
    }
    
    public void createEuclidesMatriz(){
        double[][] euclides = new double[this.lista.length][this.lista.length];
        for (int i = 0; i < this.lista.length; i++) {
            for (int j = 0; j < this.lista.length; j++) {
                double value = 0;
                if (j>i){
                    double x1 = this.lista[i][0];
                    double y1 = this.lista[i][1];
                    double x2 = this.lista[j][0];
                    double y2 = this.lista[j][1];
                    value = Math.sqrt( Math.pow((x2-x1),2) + Math.pow((y2-y1),2) );
                }
                euclides[i][j] = value;
                if(j<i){
                    euclides[i][j] = euclides[j][i];
                }
            }
        }
        this.matriz = euclides;
    }
    
    public void imprimirMatriz(){
        for (int i = 0; i < this.matriz.length; i++) {
            System.out.println(Arrays.toString(this.matriz[i]));
        }
    }
    
    public int getElementsLength(){
        return this.lista.length;
    }
    
    public double[] getElementOfIndex(int index){
        return this.lista[index];
    }
    
    public int[] getLowestValues(int punto, int cantidad){
        int[] lowValues = new int[cantidad];
        double[] fila = this.matriz[punto];
        for (int i = 0; i < cantidad; i++) {
            double menor = 0;
            int indexMenor = 0;
            for (int j = 0; j < fila.length; j++) {
                double actual = fila[j];
                if (actual > 0 && !contains(lowValues, j) ){
                    if (menor == 0 || menor > actual){
                        menor = actual;
                        indexMenor = j;
                    }
                }
            }
            lowValues[i] = indexMenor;
        }
        return lowValues;
    }
    
    public double getScoreAtIndex(int index){
        return this.lista[index][2];
    }
    
    public double getTotalScore(int[] camino){
        double suma = 0;
        for (int i = 0; i < camino.length; i++) {
            suma += this.getScoreAtIndex(camino[i]);
            System.out.println(this.getScoreAtIndex(camino[i]));
        }
        return suma;
    }
    
    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }
    
}
