/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author ralfne
 */
public class TaxNodeParasiteStatus {
    public int TaxID=-1;
    public int ParasiteChildren=-1;
    public double ParasitePercentage=-1;
    public int AllChildren=-1;
    public void calculatePercentage(int allChilds){
        AllChildren=allChilds;
        ParasitePercentage=ParasiteChildren/(double)AllChildren;
    }    
}
