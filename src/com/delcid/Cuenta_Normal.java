package com.delcid;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.delcid.Bitacora.accion;
import static jdk.nashorn.internal.objects.NativeMath.random;

/**
 * Created by NEHEMIAS on 21/06/2017.
 */
public class Cuenta_Normal extends Cuenta {

    public Cuenta_Normal(double balance) {
        setBalance(balance);
        setTipocuenta(1);
        setcuenta(tipocuenta);
    }

    public  void guardard(Cuenta_Normal cuenta){
        Calendar fechaguardarcuentaN = new GregorianCalendar();
        accion+="Guardar Cuenta Normal "+cuenta.getcuenta()+"Perteneciente"+cuenta.getId()+" "+ fechaguardarcuentaN .get(Calendar.DAY_OF_MONTH) + "/" + fechaguardarcuentaN.get(Calendar.MONTH) + "+" + fechaguardarcuentaN.get(Calendar.YEAR) + " " + fechaguardarcuentaN .get(Calendar.HOUR_OF_DAY) + ":" + fechaguardarcuentaN .get(Calendar.MINUTE)+"\n";

        Cliente.cuenta.add(cuenta);
    }

}
