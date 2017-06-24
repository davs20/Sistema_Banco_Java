package com.delcid;
import java.util.ArrayList;
/**
 * Created by NEHEMIAS on 21/06/2017.
 */
public class Bitacora {
    private int numero;
    public static String accion="";
    public static String cuenta;
    protected String usuario;
    public  ArrayList<Bitacora> bitacoras =new ArrayList<>();

    public void guardarbitacira(Bitacora bitacoras){
        this.bitacoras.add(bitacoras);
    }
}
