package com.delcid;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import static com.delcid.Cuenta.*;
import static com.delcid.Cuenta_Largo_Plazo.guardar;
import static com.delcid.Cuenta_Normal.guardard;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import static com.delcid.Bitacora.accion;

public class Main {
    public int opcion;
    public static boolean condicion = TRUE;


    public static void menu() {
        System.out.println("----------------------MENU---------------------------");
        System.out.println("1---------------Registro de Cliente------------------");
        System.out.println("2-------Registrar Cuentas en Clientes Existentes-----");
        System.out.println("3-------------------Depositar------------------------");
        System.out.println("4-------------------Retirar--------------------------");
        System.out.println("5-------------------Bitacora-------------------------");
        System.out.println("6---------------------Salir--------------------------");
        System.out.println("----------------Elija Una Opcion:--------------------");
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        java.util.Date fecha = new Date();
        menu();

        int opcion = lector.nextInt();
        String dest;
        String id;
        while (condicion == TRUE) {
            switch (opcion) {
                case 1:
                    Cliente nuevo_cliente = new Cliente();
                    System.out.println("Ingrese el Nombre");
                    nuevo_cliente.setNombre(lector.next());
                    System.out.println("Ingrese el Correo Electronico");
                    nuevo_cliente.setCorreo(lector.next());
                    System.out.println("Ingrese el Numero de Telefono");
                    nuevo_cliente.setTelefono(lector.next());
                    System.out.println("Ingrese el Numero de Identidad");
                    nuevo_cliente.setId(lector.next());
                    System.out.println("Tipo De Cuenta");
                    System.out.println("1. Cuenta Normal--");
                    System.out.println("2. Cuenta A largo Plazo");
                    int tipocuenta = lector.nextInt();
                    if (tipocuenta == 1) {
                        System.out.println("Ingrese la cantidad de apertura");
                        Cuenta_Normal nuevanormal = new Cuenta_Normal(lector.nextDouble());
                        nuevanormal.setId(nuevo_cliente.getId());
                        guardard(nuevanormal);
                    } else if (tipocuenta == 2) {
                        System.out.println("Ingrese la cantidad de apertura");
                        Cuenta_Largo_Plazo nuevalargoplazo = new Cuenta_Largo_Plazo();
                        nuevalargoplazo.Cuenta_Largo(lector.nextDouble());
                        nuevalargoplazo.setId(nuevo_cliente.getId());
                        guardar(nuevalargoplazo);
                    }
                    menu();
                    opcion = lector.nextInt();
                    break;
                case 2:
                    Cuenta buscarcliete = new Cuenta();
                    System.out.println("Ingrese el numero de identidad del Cliente");
                    id = lector.next();

                    break;
                case 3:
                    Cuenta deposito = new Cuenta();
                    System.out.println("Ingrese el numero de cuenta del destinatario");
                    dest = lector.next();
                    if (deposito.buscarcuenta(dest) > -1) {
                        System.out.println("Ingrese el Monto a Depositar");
                        Double mont = lector.nextDouble();
                        deposito.Depositar(mont, deposito.buscarcuenta(dest));
                    } else {
                        System.out.println("Esta Cuenta no existe");

                    }
                    menu();
                    opcion = lector.nextInt();
                    break;
                case 4:
                    Cuenta retiro = new Cuenta();
                    System.out.println("Ingrese el numero de cuenta");
                    dest = lector.next();
                    System.out.println("Ingrese el numero de identidad del Cliente");
                    id = lector.next();
                    System.out.println("Ingrese el Monto a Retirar");
                    Double mont = lector.nextDouble();
                    if (retiro.buscarcuentaid(dest, id) == -1) {
                        System.out.println("El numero de cuenta que has ingresado no existe o no eres dueno de la cuenta");
                    } else {
                        if (retiro.buscartipo(dest) == 2) {
                             Cuenta_Largo_Plazo largo =new Cuenta_Largo_Plazo();
                            largo.Retirar(mont, retiro.buscarcuentaid(dest, id));
                        } else {
                            retiro.Retirar(mont, retiro.buscarcuentaid(dest, id));
                        }
                    }
                    menu();
                    opcion = lector.nextInt();
                    break;
                case 5:
                    System.out.println("---Cuenta---    ----Cliente----     ----Balance-----");
                    Cuenta mostrar = new Cuenta();
                    System.out.println(mostrar());
                    menu();
                    opcion = lector.nextInt();
                    break;
                case 6:
                    condicion = FALSE;
                    break;

            }

        }
    }
}