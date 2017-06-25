package com.delcid;

import java.util.*;

import static com.delcid.Bitacora.accion;

/**
 * Created by NEHEMIAS on 21/06/2017.
 */

public class Cuenta {
    //private static com.delcid.Cuenta Cuenta;
    Random rnd = new Random();
    public static Double porcentaje_retiro;
    protected double monto;
    static public ArrayList<Cuenta> cuenta = new ArrayList<>();
    protected int posicion;
    private String Cuenta;
    protected int tipocuenta;
    private String id;

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    protected Double balance;

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    protected void setcuenta(int tipocuenta) {
        Calendar fechasetcuenta = new GregorianCalendar();
        Cuenta = fechasetcuenta.get(Calendar.DAY_OF_MONTH) + "-" + fechasetcuenta.get(Calendar.MONTH) + "-" + fechasetcuenta.get(Calendar.YEAR) + "-" + rnd.nextInt(54456) + "-" + tipocuenta;
        accion += " Creacion de la  Cuenta " + Cuenta + fechasetcuenta.get(Calendar.DAY_OF_MONTH) + "/" + fechasetcuenta.get(Calendar.MONTH) + "/" + fechasetcuenta.get(Calendar.YEAR) + " " + fechasetcuenta.get(Calendar.HOUR_OF_DAY) + ":" + fechasetcuenta.get(Calendar.MINUTE) + "\n";

    }

    public int getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(int tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public String getcuenta() {
        return this.Cuenta;
    }

    public void Depositar(Double mont, int posicion) {
        Calendar fechadepositar = new GregorianCalendar();
        accion += "Depositar en la Cuenta " + Cliente.cuenta.get(getPosicion()).getcuenta() + " " + fechadepositar.get(Calendar.DAY_OF_MONTH) + "/" + fechadepositar.get(Calendar.MONTH) + "/" + fechadepositar.get(Calendar.YEAR) + " " + fechadepositar.get(Calendar.HOUR_OF_DAY) + ":" + fechadepositar.get(Calendar.MINUTE) + "\n";
        Double ab = Cliente.cuenta.get(getPosicion()).getBalance();
        Cliente.cuenta.get(getPosicion()).setBalance(ab + mont);
    }

    protected Double getBalance() {
        return balance;
    }

    protected void setBalance(Double balance) {
        this.balance = balance;
    }

    public void Retirar(Double ret, int posicion) {
        Calendar fecharetirar = new GregorianCalendar();
        accion += "Retirar de la cuenta" + Cliente.cuenta.get(posicion).getcuenta() + " " + Cliente.cuenta.get(posicion).getcuenta() + " " + fecharetirar.get(Calendar.DAY_OF_MONTH) + "/" + fecharetirar.get(Calendar.MONTH) + "/" + fecharetirar.get(Calendar.YEAR) + " " + fecharetirar.get(Calendar.HOUR_OF_DAY) + ":" + fecharetirar.get(Calendar.MINUTE) + "\n";
        double a = Cliente.cuenta.get(posicion).getBalance();
        Cliente.cuenta.get(posicion).setBalance(a - ret);
    }

    public  int buscarcuenta(String numerocuenta) {
        Calendar fechabusqueda = new GregorianCalendar();
        setPosicion(-1);
        if (Cliente.cuenta.size() > 0) {
            for (int i = 0; i < Cliente.cuenta.size(); i++) {
                if (Cliente.cuenta.get(i).getcuenta().equals(numerocuenta)) {

                    setPosicion(i);
                    accion += "Buscar Cuenta  " + numerocuenta + Cliente.cuenta.get(getPosicion()).getcuenta() + " " + Cliente.cuenta.get(getPosicion()).getcuenta() + " " + fechabusqueda.get(Calendar.DAY_OF_MONTH) + "/" + fechabusqueda.get(Calendar.MONTH) + "/" + fechabusqueda.get(Calendar.YEAR) + " " + fechabusqueda.get(Calendar.HOUR_OF_DAY) + ":" + fechabusqueda.get(Calendar.MINUTE) + "\n";
                    return getPosicion();
                }
            }
        }
        return getPosicion();
    }

    public int buscarcuentaid(String numerocuenta, String id) {
        Calendar fechabusqueda = new GregorianCalendar();
        setPosicion(-1);
        if (Cliente.cuenta.size() > 0) {
            for (int i = 0; i < Cliente.cuenta.size(); i++) {
                if (Cliente.cuenta.get(i).getcuenta().equals(numerocuenta) && Cliente.cuenta.get(i).getId().equals(id)) {

                    setPosicion(i);
                    accion += "Buscar Cuenta  " + numerocuenta + Cliente.cuenta.get(getPosicion()).getcuenta() + " " + Cliente.cuenta.get(getPosicion()).getcuenta() + " " + fechabusqueda.get(Calendar.DAY_OF_MONTH) + "/" + fechabusqueda.get(Calendar.MONTH) + "/" + fechabusqueda.get(Calendar.YEAR) + " " + fechabusqueda.get(Calendar.HOUR_OF_DAY) + ":" + fechabusqueda.get(Calendar.MINUTE) + "\n";
                    return getPosicion();
                }
            }
        }
        return getPosicion();
    }

    public int buscartipo(String numerocuenta) {
        Calendar fechabusqueda = new GregorianCalendar();
        int re = -1;
        for (int i = 0; i < Cliente.cuenta.size(); i++) {
            if (Cliente.cuenta.get(i).getcuenta().equals(numerocuenta)) {
                accion += "Buscar Cuenta  " + numerocuenta + Cliente.cuenta.get(i).getcuenta() + " " + Cliente.cuenta.get(i).getcuenta() + " " + fechabusqueda.get(Calendar.DAY_OF_MONTH) + "/" + fechabusqueda.get(Calendar.MONTH) + "/" + fechabusqueda.get(Calendar.YEAR) + " " + fechabusqueda.get(Calendar.HOUR_OF_DAY) + ":" + fechabusqueda.get(Calendar.MINUTE) + "\n";
                re = i;
                return Cliente.cuenta.get(i).getTipocuenta();
            }
        }
        return Cliente.cuenta.get(re).getTipocuenta();
    }


    public static String mostrar() {
        String mensaje = "";
        Calendar fechamostrar = new GregorianCalendar();
        accion += "Mostrar Cuentas Guardadas en el Sistema" + fechamostrar.get(Calendar.DAY_OF_MONTH) + "/" + fechamostrar.get(Calendar.MONTH) + "/" + fechamostrar.get(Calendar.YEAR) + " " + fechamostrar.get(Calendar.HOUR_OF_DAY) + ":" + fechamostrar.get(Calendar.MINUTE) + "\n";
        if (Cliente.cuenta.size() > 0) {
            for (int i = 0; i < Cliente.cuenta.size(); i++) {
                mensaje += Cliente.cuenta.get(i).getcuenta() + " " + Cliente.cuenta.get(i).getId() + " " + Cliente.cuenta.get(i).balance + "\n";
            }
            return mensaje;
        } else {
            System.out.println("El Arreglo esta vacio");
            return mensaje;
        }
    }
}
