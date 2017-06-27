package com.delcid;

import java.util.ArrayList;

public class Bitacora {
    private int numero;
    public static String accion = "";
    private static int contador;
    private String usuario;
    private String accion1;
    private String fecha;
    private String id;
    private String cuenta;
    private Double Balance;
    public static ArrayList<Bitacora> bitacoras = new ArrayList<>();

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


    public void guardarbitacira(Bitacora bitacora) {
        Bitacora.bitacoras.add(bitacora);
    }

    public static void mostrarbitacora() {
        for (int b = 0; b < Cliente.cuenta.size(); b++) {
            System.out.println("      "+Bitacora.bitacoras.get(b).getAccion1()+"      "+Bitacora.bitacoras.get(b).getCuenta()+"      "+Bitacora.bitacoras.get(b).getFecha());
        }
    }
}
