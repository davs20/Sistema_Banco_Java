package com.delcid;
import java.util.ArrayList;
/**
 * Created by NEHEMIAS on 21/06/2017.
 */
public class Bitacora {
    private int numero;
    public static String accion="";
    private String usuario;
    private String accion1;
    private String fecha;
    private String id;
    private String cuenta;
    private Double  Balance;
    public static ArrayList<Bitacora> bitacoras =new ArrayList<>();

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getAccion1() {
        return accion1;
    }

    public void setAccion1(String accion1) {
        this.accion1 = accion1;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Double getBalance() {
        return Balance;
    }

    public void setBalance(Double balance) {
        Balance = balance;
    }

    public void guardarbitacira(Bitacora bitacoras){
        this.bitacoras.add(bitacoras);
    }
}
