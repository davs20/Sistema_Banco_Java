package com.delcid;
/**
 * Created by NEHEMIAS on 21/06/2017.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import static com.delcid.Bitacora.accion;
public class Cuenta_Largo_Plazo extends Cuenta {

    public Cuenta_Largo_Plazo(Double balancea) {
        setBalance(balancea);
        setTipocuenta(2);
        setcuenta(getTipocuenta());
    }
    public Double Retirar(Double ret) {
        Calendar fecharetirar = new GregorianCalendar();
        accion += "Retirar de la cuenta" + Cliente.cuenta.get(posicion).getcuenta() + " " + Cliente.cuenta.get(posicion).getcuenta() + " " + fecharetirar.get(Calendar.DAY_OF_MONTH) + "/" + fecharetirar.get(Calendar.MONTH) + "/" + fecharetirar.get(Calendar.YEAR) + " " + fecharetirar.get(Calendar.HOUR_OF_DAY) + ":" + fecharetirar.get(Calendar.MINUTE) + "\n";
        Bitacora bitacora = new Bitacora();
        Cliente.cuenta.get(posicion);
        return (balance - ret * 0.90);
    }
    public static  void guardar(Cuenta_Largo_Plazo cuenta_largo_plazo) {
        Calendar fechaguardarcuentalp = new GregorianCalendar();
        accion+="Guardar Cuenta Largo plazo "+cuenta_largo_plazo.getcuenta()+"Perteneciente"+cuenta_largo_plazo.getId()+" "+ fechaguardarcuentalp .get(Calendar.DAY_OF_MONTH) + "/" + fechaguardarcuentalp.get(Calendar.MONTH) + "+" + fechaguardarcuentalp.get(Calendar.YEAR) + " " + fechaguardarcuentalp .get(Calendar.HOUR_OF_DAY) + ":" + fechaguardarcuentalp .get(Calendar.MINUTE)+"\n";
        Cliente.cuenta.add(cuenta_largo_plazo);
    }
}