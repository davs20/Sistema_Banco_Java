package com.delcid;

import java.sql.Timestamp;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static com.delcid.Bitacora.accion;
/**
 * Created by NEHEMIAS on 21/06/2017.
 */
public class Cliente {
    private String nombre;
    private String id;
    private String telefono;
    private String correo;
    private DateTimeException fecha_nacimieto;
    public static ArrayList<Cliente> registro=new ArrayList<>();
    static  public ArrayList<Cuenta> cuenta = new ArrayList<>();
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
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

    public  void guardar_cliente(Cliente cliente){

        Calendar fechaguardarcliente = new GregorianCalendar();
        accion+="Guardar Cliente"+ fechaguardarcliente.get(Calendar.DAY_OF_MONTH) + "/" + fechaguardarcliente.get(Calendar.MONTH) + "+" + fechaguardarcliente.get(Calendar.YEAR) + " " + fechaguardarcliente.get(Calendar.HOUR_OF_DAY) + ":" + fechaguardarcliente.get(Calendar.MINUTE)+"\n";;
        this.registro.add(cliente);
        Bitacora bitacora =new Bitacora();


    }
    public  void mostrat(Cliente cliente){
        Calendar fechamostrarcliente = new GregorianCalendar();
        accion+="Mostrar Clientes"+ fechamostrarcliente.get(Calendar.DAY_OF_MONTH) + "/" + fechamostrarcliente.get(Calendar.MONTH) + "+" + fechamostrarcliente.get(Calendar.YEAR) + " " + fechamostrarcliente.get(Calendar.HOUR_OF_DAY) + ":" + fechamostrarcliente.get(Calendar.MINUTE)+"\n";;

    }
}
