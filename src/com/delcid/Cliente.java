package com.delcid;

import java.sql.Timestamp;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.delcid.Bitacora.accion;

public class Cliente {
    private String nombre;
    private String id;
    private String telefono;
    private String correo;
    private int posicion;
    private DateTimeException fecha_nacimieto;
    static public ArrayList<Cliente> registro = new ArrayList<>();
    static public ArrayList<Cuenta> cuenta = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public DateTimeException getFecha_nacimieto() {
        return fecha_nacimieto;
    }

    public void setFecha_nacimieto(DateTimeException fecha_nacimieto) {
        this.fecha_nacimieto = fecha_nacimieto;
    }

    public  void guardar_cliente(Cliente cliente) {

        Calendar fechaguardarcliente = new GregorianCalendar();
        accion += "Guardar Cliente" + fechaguardarcliente.get(Calendar.DAY_OF_MONTH) + "/" + fechaguardarcliente.get(Calendar.MONTH) + "+" + fechaguardarcliente.get(Calendar.YEAR) + " " + fechaguardarcliente.get(Calendar.HOUR_OF_DAY) + ":" + fechaguardarcliente.get(Calendar.MINUTE) + "\n";
        registro.add(cliente);
        Bitacora bitacora = new Bitacora();

    }

    public int posicioncliente(String cuenta) {
        Calendar fechabusqueda = new GregorianCalendar();
        setPosicion(-1);
        for (int a = 0; a < registro.size(); a++) {

            if (registro.get(a).getId().equals(buscarcliente(cuenta))) {
                // accion += "Cliente Cuenta con numero de Cuenta " + cuenta + Cliente.registro.get(i).getcuenta() + " " + Cliente.cuenta.get(i).getcuenta() + " " + fechabusqueda.get(Calendar.DAY_OF_MONTH) + "/" + fechabusqueda.get(Calendar.MONTH) + "/" + fechabusqueda.get(Calendar.YEAR) + " " + fechabusqueda.get(Calendar.HOUR_OF_DAY) + ":" + fechabusqueda.get(Calendar.MINUTE) + "\n";

                setPosicion(a);
                return getPosicion();
            }
        }
        return getPosicion();
    }
    public int posicionclienteid(String id) {
        Calendar fechabusqueda = new GregorianCalendar();
        setPosicion(-1);
        for (int a = 0; a < registro.size(); a++) {

            if (registro.get(a).getId().equals(id)) {
                // accion += "Cliente Cuenta con numero de Cuenta " + cuenta + Cliente.registro.get(i).getcuenta() + " " + Cliente.cuenta.get(i).getcuenta() + " " + fechabusqueda.get(Calendar.DAY_OF_MONTH) + "/" + fechabusqueda.get(Calendar.MONTH) + "/" + fechabusqueda.get(Calendar.YEAR) + " " + fechabusqueda.get(Calendar.HOUR_OF_DAY) + ":" + fechabusqueda.get(Calendar.MINUTE) + "\n";

                setPosicion(a);
                return getPosicion();
            }
        }
        return getPosicion();
    }

    public String buscarcliente(String cuenta) {
        Calendar fechamostrarcliente = new GregorianCalendar();

        int re = -1;
        for (int i = 0; i < Cliente.cuenta.size(); i++) {
            if (Cliente.cuenta.get(i).getcuenta().equals(cuenta)) {
                // accion += "Cliente Cuenta con numero de Cuenta " + cuenta + Cliente.cuenta.get(i).getcuenta() + " " + Cliente.cuenta.get(i).getcuenta() + " " + fechabusqueda.get(Calendar.DAY_OF_MONTH) + "/" + fechabusqueda.get(Calendar.MONTH) + "/" + fechabusqueda.get(Calendar.YEAR) + " " + fechabusqueda.get(Calendar.HOUR_OF_DAY) + ":" + fechabusqueda.get(Calendar.MINUTE) + "\n";
                re = i;
                return Cliente.cuenta.get(i).getId();
            }
        }
        return Cliente.cuenta.get(re).getId();
    }

    public static void mostrarcliente() {
        String cadena="";
        Calendar fechamostrarcliente = new GregorianCalendar();
        accion += "Mostrar Clientes" + fechamostrarcliente.get(Calendar.DAY_OF_MONTH) + "/" + fechamostrarcliente.get(Calendar.MONTH) + "+" + fechamostrarcliente.get(Calendar.YEAR) + " " + fechamostrarcliente.get(Calendar.HOUR_OF_DAY) + ":" + fechamostrarcliente.get(Calendar.MINUTE) + "\n";
        for (int c=0;c<Cliente.registro.size();c++){
            cadena+=Cliente.registro.get(c).getNombre()+"\n";
        }
        System.out.println(cadena);
    }
}
