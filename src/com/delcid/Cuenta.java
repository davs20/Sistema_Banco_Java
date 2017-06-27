package com.delcid;

import java.util.*;

import static com.delcid.Bitacora.accion;

public class Cuenta {
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
        Calendar Fecha = new GregorianCalendar();
        int sumames = Fecha.get(Calendar.MONTH) + 1;
        this.Cuenta = Fecha.get(Calendar.DAY_OF_MONTH) + "-" + sumames + "-" + Fecha.get(Calendar.YEAR) + "-" + rnd.nextInt(54456) + "-" + getTipocuenta();
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
        Calendar Fecha = new GregorianCalendar();
        int sumames = Fecha.get(Calendar.MONTH) + 1;
        Double ab = Cliente.cuenta.get(getPosicion()).getBalance();
        Cliente.cuenta.get(posicion).setBalance(ab + mont);
        accion += "Depositar A Cuenta  " + Cliente.cuenta.get(posicion).getcuenta() + "Cantidad  " + mont + "  " + Fecha.get(Calendar.DAY_OF_MONTH) + "/" + sumames + "/" + Fecha.get(Calendar.YEAR) + " " + Fecha.get(Calendar.HOUR_OF_DAY) + ":" + Fecha.get(Calendar.MINUTE) + "\n";
    }

    protected Double getBalance() {
        return balance;
    }

    protected void setBalance(Double balance) {
        this.balance = balance;
    }

    public void Retirar(Double ret, int posicion) {
        Calendar fechabusqueda = new GregorianCalendar();
        Calendar Fecha = new GregorianCalendar();
        int sumames = Fecha.get(Calendar.MONTH) + 1;
        double a = Cliente.cuenta.get(posicion).getBalance();
        accion += "Retirar de Cuenta  " + Cliente.cuenta.get(posicion).getcuenta() + "Cantidad  " + ret + fechabusqueda.get(Calendar.DAY_OF_MONTH) + "/" + sumames + "/" + fechabusqueda.get(Calendar.YEAR) + " " + fechabusqueda.get(Calendar.HOUR_OF_DAY) + ":" + fechabusqueda.get(Calendar.MINUTE) + "\n";
        ;
        Cliente.cuenta.get(posicion).setBalance(a - ret);

    }

    public int buscarcuenta(String numerocuenta) {
        Calendar fechabusqueda = new GregorianCalendar();
        Bitacora newaction = new Bitacora();
        setPosicion(-1);
        int suma = fechabusqueda.get(Calendar.MONTH) + 1;
        if (Cliente.cuenta.size() > 0) {
            for (int i = 0; i < Cliente.cuenta.size(); i++) {
                if (Cliente.cuenta.get(i).getcuenta().equals(numerocuenta)) {
                    setPosicion(i);
                    accion += "Buscar Cuenta  " + numerocuenta + Cliente.cuenta.get(getPosicion()).getcuenta() + " " + Cliente.cuenta.get(getPosicion()).getcuenta() + " " + fechabusqueda.get(Calendar.DAY_OF_MONTH) + "/" + suma + "/" + fechabusqueda.get(Calendar.YEAR) + " " + fechabusqueda.get(Calendar.HOUR_OF_DAY) + ":" + fechabusqueda.get(Calendar.MINUTE) + "\n";
                    return getPosicion();
                }
            }
        }
        return getPosicion();

    }

    public int buscarcuentaid(String numerocuenta, String id) {
        Calendar fechabusqueda = new GregorianCalendar();
        setPosicion(-1);
        int suma = fechabusqueda.get(Calendar.MONTH) + 1;
        accion += "Buscar En Sistema Cuenta   " + numerocuenta + "  " + id + "   " + fechabusqueda.get(Calendar.DAY_OF_MONTH) + "/" + suma + "/" + fechabusqueda.get(Calendar.YEAR) + " " + fechabusqueda.get(Calendar.HOUR_OF_DAY) + ":" + fechabusqueda.get(Calendar.MINUTE) + "\n";
        if (Cliente.cuenta.size() > 0) {
            for (int i = 0; i < Cliente.cuenta.size(); i++) {
                if (Cliente.cuenta.get(i).getcuenta().equals(numerocuenta) && Cliente.cuenta.get(i).getId().equals(id)) {
                    setPosicion(i);
                    accion += "Cuenta Encontrada  " + numerocuenta + Cliente.cuenta.get(i).getcuenta() + " " + Cliente.cuenta.get(i).getcuenta() + "   " + fechabusqueda.get(Calendar.DAY_OF_MONTH) + "/" + fechabusqueda.get(Calendar.MONTH) + "/" + fechabusqueda.get(Calendar.YEAR) + " " + fechabusqueda.get(Calendar.HOUR_OF_DAY) + ":" + fechabusqueda.get(Calendar.MINUTE) + "\n";
                    return getPosicion();
                }
            }
        }
        return getPosicion();
    }

    public int buscartipo(String numerocuenta) {
        Calendar fechabusqueda = new GregorianCalendar();
        int suma = fechabusqueda.get(Calendar.MONTH) + 1;
        int re = -1;
        for (int i = 0; i < Cliente.cuenta.size(); i++) {
            if (Cliente.cuenta.get(i).getcuenta().equals(numerocuenta)) {
                accion += "Cuenta Encontrada  " + numerocuenta + " " + "Perteneciente a  " + Cliente.cuenta.get(i).getId() + " " + fechabusqueda.get(Calendar.DAY_OF_MONTH) + "/" + suma + "/" + fechabusqueda.get(Calendar.YEAR) + " " + fechabusqueda.get(Calendar.HOUR_OF_DAY) + ":" + fechabusqueda.get(Calendar.MINUTE) + "\n";
                re = i;
                return Cliente.cuenta.get(i).getTipocuenta();
            }
        }
        return Cliente.cuenta.get(re).getTipocuenta();
    }

    public static void mostrarceuntaindividual(Cuenta cuenta) {
        Calendar fechabusqueda = new GregorianCalendar();
        int suma = fechabusqueda.get(Calendar.MONTH) + 1;
        accion+="Mostrar Cuenta :"+cuenta.getcuenta()+" Perteneciente a "+cuenta.getId()+ " "+ fechabusqueda.get(Calendar.DAY_OF_MONTH) + "/" + suma + "/" + fechabusqueda.get(Calendar.YEAR) + " " + fechabusqueda.get(Calendar.HOUR_OF_DAY) + ":" + fechabusqueda.get(Calendar.MINUTE) + "\n";
        System.out.println("Transaccion Exitosa!");
        System.out.println("---Cuenta---    ----Cliente----     ----Balance-----");
        System.out.println(cuenta.getcuenta() + "     " + cuenta.getId() + "      " + cuenta.getBalance());
    }

    public static void mostrarceuntaindividual(int posicion) {
        Calendar fechabusqueda = new GregorianCalendar();
        int suma = fechabusqueda.get(Calendar.MONTH) + 1;
       accion+="Mostrar Cuenta :"+Cliente.cuenta.get(posicion).getcuenta()+" Perteneciente a "+Cliente.cuenta.get(posicion).getId()+fechabusqueda.get(Calendar.DAY_OF_MONTH) + "/" + suma + "/" + fechabusqueda.get(Calendar.YEAR) + " " + fechabusqueda.get(Calendar.HOUR_OF_DAY) + ":" + fechabusqueda.get(Calendar.MINUTE) + "\n";
        System.out.println("Transaccion Exitosa!");
        System.out.println("---Cuenta---    ----Cliente----     ----Balance-----");
        System.out.println(Cliente.cuenta.get(posicion) + "     " + Cliente.cuenta.get(posicion) + "      " + Cliente.cuenta.get(posicion).getBalance());
    }
}


