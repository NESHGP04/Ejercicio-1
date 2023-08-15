/*Marinés García - 23391
 * Ejercicio1: Overloading y relaciones entre clases
 * Clase
 */

import java.util.Random;

public class Localidad {

    //Inicializar variables
    private int loc1, loc2, loc3;
    public int locRan;
    private Random r;

    //Métodos clase Localidad
    public Localidad(){
        this.locRan = 0;
        r = new Random();
    }

    //Setters
    public void setLoc1(int loc1) {
        this.loc1 = 100;
    }

    public void setLoc2(int loc2) {
        this.loc1 = 500;
    }

    public void setLoc3(int loc3) {
        this.loc1 = 1000;
    }    
    public void incLocRan(int locRan) {
        this.locRan = this.r.nextInt(2) + 1;
    }    

    //Getters
    public int getLoc1(){
        return this.loc1;
    }

    public int getLoc2(){
        return this.loc2;
    }

    public int getLoc3(){
        return this.loc3;
    }

    public int getLocRan(){
        return this.locRan;
    }    
    
}
