/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tso.pia;

import Clases.GRASP;
import Clases.Grafo;

/**
 *
 * @author Benny Reyes Sosa
 */
public class TSOPIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataExample obj = new DataExample("tsiligirides_problem_1_budget_05.txt");
        Grafo myGrafo = new Grafo(obj.getMatriz());
        GRASP metodo = new GRASP(myGrafo, obj.getNumeroIteraciones());
    }
    
}
