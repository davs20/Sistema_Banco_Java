package com.delcid;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;


import static com.delcid.Cuenta.*;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import static com.delcid.Bitacora.accion;

public class Main {
    public int opcion;
    public static boolean condicion = TRUE;


    public static void menu() {
        System.out.println("----------------------MENU---------------------------");
        System.out.println("1---------------Agregar Cuentas----------------------");
        System.out.println("3-------------------Depositar------------------------");
        System.out.println("4-------------------Retirar--------------------------");
        System.out.println("5-------------------Bitacora-------------------------");
        System.out.println("6---------------------Salir--------------------------");
        System.out.println("----------------Elija Una Opcion:--------------------");
    }

    public static void main(String[] args) {
        String dest;
        String id;
        Double mont;
        String nombredepositente;
        Scanner lector = new Scanner(System.in);
        java.util.Date fecha = new Date();
        menu();
        int opcion = lector.nextInt();
        while (condicion == TRUE) {
            switch (opcion) {
                case 1:
                    System.out.println("jkjk");
                    Cliente nuevo_cliente = new Cliente();
                    System.out.println("Ingrese el Nombre");
                    nuevo_cliente.setNombre(lector.next());
                    System.out.println("Ingrese el Correo Electronico");
                    nuevo_cliente.setCorreo(lector.next());
                    System.out.println("Ingrese el Numero de Telefono");
                    nuevo_cliente.setTelefono(lector.next());
                    System.out.println("Ingrese el Numero de Identidad");
                    nuevo_cliente.setId(lector.next());
                    nuevo_cliente.guardar_cliente(nuevo_cliente);
                    System.out.println("Tipo De Cuenta");
                    System.out.println("1. Cuenta Normal--");
                    System.out.println("2. Cuenta A largo Plazo");
                    switch (lector.nextInt()) {
                        case 1:
                            System.out.println("Ingrese la cantidad de apertura");
                            Cuenta_Normal nuevanormal = new Cuenta_Normal(lector.nextDouble());
                            nuevanormal.setId(nuevo_cliente.getId());
                            nuevanormal.guardard(nuevanormal);
                            menu();
                            opcion = lector.nextInt();
                            break;
                        case 2:
                            System.out.println("Ingrese la cantidad de apertura");
                            Cuenta_Largo_Plazo nuevalargoplazo = new Cuenta_Largo_Plazo();
                            nuevalargoplazo.Cuenta_Largo(lector.nextDouble());
                            nuevalargoplazo.setId(nuevo_cliente.getId());
                            nuevalargoplazo.guardar(nuevalargoplazo);
                            menu();
                            opcion = lector.nextInt();
                            break;
                        default:
                            System.out.println("Has Ingresado una opcion Invalida intenta den nuevo 1, regresar al menu princiooal 2");
                            opcion = 1;
                            break;

                    }

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
                    System.out.println("Ingrese el nombre ...");
                     nombredepositente=lector.next();
                     System.out.println(deposito.buscarcuenta(dest));
                    if (deposito.buscarcuenta(dest) > -1) {
                        Cliente busquedacliente=new Cliente();
                        System.out.println("Ingrese el Monto a Depositar");
                        mont=lector.nextDouble();
                        deposito.Depositar(mont, deposito.buscarcuenta(dest));
                        System.out.println("Transaccion Exitosa!");
                        System.out.println("---------Depositante-------Cuenta Receptor--------Nombre Receptor---------Deposito-----");
                        System.out.println("   "+nombredepositente+"                "+dest+"      "+Cliente.registro.get(busquedacliente.posicioncliente(dest)).getNombre()+"        "+mont);
                        menu();
                        opcion = lector.nextInt();
                    } else {
                        System.out.println("Esta Cuenta no existe intenta de nuevo ");
                        opcion = 3;
                    }
                    break;
                case 4:
                    Cuenta retiro = new Cuenta();
                    System.out.println("Ingrese el numero de cuenta");
                    dest = lector.next();
                    System.out.println("Ingrese el numero de identidad del Cliente");
                    id = lector.next();
                    System.out.println("Ingrese el Monto a Retirar");
                    mont = lector.nextDouble();
                    if (retiro.buscarcuentaid(dest, id) == -1) {
                        System.out.println("El numero de cuenta que has ingresado no existe o no eres dueno de la cuenta");
                    } else if (retiro.buscartipo(dest) == 2) {
                        Cuenta_Largo_Plazo largo = new Cuenta_Largo_Plazo();
                        largo.Retirar(mont, retiro.buscarcuentaid(dest, id));
                    } else if (retiro.buscartipo(dest) == 1) {
                        retiro.Retirar(mont, retiro.buscarcuentaid(dest, id));
                    }
                    menu();
                    opcion = lector.nextInt();
                    break;
                case 5:
                    System.out.println("---Cuenta---    ----Cliente----     ----Balance-----");
                    Cuenta mostrar = new Cuenta();
                    System.out.println(mostrar());
                    Cliente.mostrarcliente();
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