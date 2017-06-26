package com.delcid;
/**
 * Created by NEHEMIAS on 21/06/2017.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import static com.delcid.Bitacora.accion;
public class Cuenta_Largo_Plazo extends Cuenta {

    public  void Cuenta_Largo(Double balancea) {
        setBalance(balancea);
        setTipocuenta(2);
        setcuenta(getTipocuenta());
    }
    public   void guardar(Cuenta_Largo_Plazo cuenta_largo_plazo) {
        Calendar fechaguardarcuentalp = new GregorianCalendar();
        accion+="Guardar Cuenta Largo plazo "+cuenta_largo_plazo.getcuenta()+"Perteneciente"+cuenta_largo_plazo.getId()+" "+ fechaguardarcuentalp .get(Calendar.DAY_OF_MONTH) + "/" + fechaguardarcuentalp.get(Calendar.MONTH) + "+" + fechaguardarcuentalp.get(Calendar.YEAR) + " " + fechaguardarcuentalp .get(Calendar.HOUR_OF_DAY) + ":" + fechaguardarcuentalp .get(Calendar.MINUTE)+"\n";
        Cliente.cuenta.add(cuenta_largo_plazo);
    }
    public void Retirar(Double ret, int posicion) {
        Calendar fecharetirar = new GregorianCalendar();
        accion += "Retirar de la cuenta" + Cliente.cuenta.get(posicion).getcuenta() + " " + Cliente.cuenta.get(posicion).getcuenta() + " " + fecharetirar.get(Calendar.DAY_OF_MONTH) + "/" + fecharetirar.get(Calendar.MONTH) + "/" + fecharetirar.get(Calendar.YEAR) + " " + fecharetirar.get(Calendar.HOUR_OF_DAY) + ":" + fecharetirar.get(Calendar.MINUTE) + "\n";
        double a = Cliente.cuenta.get(posicion).getBalance();
        Cliente.cuenta.get(posicion).setBalance(a - ret*1.10);
    }
}