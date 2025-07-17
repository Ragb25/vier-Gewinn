package tuc.isse.model;
/**
 * Ausnahme, die erhoben wurde, wenn man versucht, einen Chip in eine bereits volle Spalte zu legen.
 * email:ragb25@tu-clausthal.de
 * email: Ft81@tu-clausthal.de
 *@autor1 Ramane Gbatkom Mouliom Abdel
 *@author2 TIEGAM NJOYA FRANCK WILFRIED
 */
public class ColumnFullException extends Exception{

    public ColumnFullException(String message){

        super(message);

    }

}
