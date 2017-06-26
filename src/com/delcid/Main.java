package com.delcid;

import java.util.Scanner;

import static com.delcid.Cuenta.*;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Main {
    public static int opcion;
    public static boolean condicion = TRUE;

    public static void condicionnuevacuenta(Scanner lector, String id, int condicion) {
        int opcionswitch = 0;
        Cliente buscar = new Cliente();
        if (condicion == 2 && buscar.posicionclienteid(id) == -1) {
            opcionswitch = 3;
        } else {
            System.out.println("Tipo De Cuenta");
            System.out.println("1.Cuenta Normal--");
            System.out.println("2. Cuenta A largo Plazo");
        }
        if (condicion == 1 || (condicion == 2 && buscar.posicionclienteid(id) > -1)) opcionswitch = lector.nextInt();
        switch (opcionswitch) {
            case 1:
                System.out.println("Ingrese la cantidad de apertura");
                Cuenta_Normal nuevanormal = new Cuenta_Normal(lector.nextDouble());
                nuevanormal.setId(id);
                nuevanormal.guardar(nuevanormal);
                Cuenta.mostrarceuntaindividual(nuevanormal);
                break;
            case 2:
                System.out.println("Ingrese la cantidad de apertura");
                Cuenta_Largo_Plazo nuevalargoplazo = new Cuenta_Largo_Plazo();
                nuevalargoplazo.Cuenta_Largo(lector.nextDouble());
                nuevalargoplazo.setId(id);
                nuevalargoplazo.guardar(nuevalargoplazo);
                Cuenta.mostrarceuntaindividual(nuevalargoplazo);
                break;
            default:
                System.out.println("Opcion Invalida o Cliente no Encontrado");
                break;
        }
    }

    public static void menu() {
        System.out.println("----------------------MENU---------------------------");
        System.out.println("1---------------Agregar Cuentas----------------------");
        System.out.println("2-------------------Depositar------------------------");
        System.out.println("3-------------------Retirar--------------------------");
        System.out.println("4-------------------Bitacora-------------------------");
        System.out.println("5---------------------Salir--------------------------");
        System.out.println("----------------Elija Una Opcion:--------------------");
    }

    public static void main(String[] args) {
        String dest;
        String id;
        int opcion;
        int opcioncuentas;
        Double mont;
        String nombredepositente;
        Scanner lector = new Scanner(System.in);
        menu();
        opcion = lector.nextInt();
        while (condicion == TRUE) {
            switch (opcion) {
                case 1:
                    System.out.println("1.Agregar Cuentas a Nuevos Clientes");
                    System.out.println("2.Agregar Cuentas a Clientes Existentes");
                    opcioncuentas = lector.nextInt();
                    switch (opcioncuentas) {
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
                            nuevo_cliente.guardar_cliente(nuevo_cliente);
                            condicionnuevacuenta(lector, nuevo_cliente.getId(), opcioncuentas);
                            break;
                        case 2:
                            System.out.println("Ingrese el numero de indentidad");
                            String ida = lector.next();
                            condicionnuevacuenta(lector, ida, opcioncuentas);
                            break;
                    }
                    menu();
                    opcion = lector.nextInt();
                    break;
                case 2:
                    Cuenta deposito = new Cuenta();
                    System.out.println("Que tipo de deposito desea realizar");
                    System.out.println("Cuenta Propia");
                    System.out.println("Cuenta Aparte");
                    System.out.println("Ingrese el numero de cuenta del destinatario");
                    dest = lector.next();
                    System.out.println("Ingrese el nombre del depositante");
                    nombredepositente = lector.next();
                    System.out.println(deposito.buscarcuenta(dest));
                    if (deposito.buscarcuenta(dest) > -1) {
                        Cliente busquedacliente = new Cliente();
                        System.out.println("Ingrese el Monto a Depositar");
                        mont = lector.nextDouble();
                        deposito.Depositar(mont, deposito.buscarcuenta(dest));
                        System.out.println("Transaccion Exitosa!");
                        System.out.println("---------Depositante-------Cuenta Receptor--------Nombre Receptor---------Deposito-----");
                        System.out.println("            " + nombredepositente + "              " + dest + "             " + Cliente.registro.get(busquedacliente.posicioncliente(dest)).getNombre() + "          " + mont);
                        menu();
                        opcion = lector.nextInt();
                    } else {
                        System.out.println("Esta Cuenta no existe intenta de nuevo porfavor ");
                        opcion = 3;
                    }
                    break;
                case 3:
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
                case 4:
                    System.out.println("------------------Bitacoras------------------");
                    Bitacora.mostrarbitacora();
                    menu();
                    opcion = lector.nextInt();
                    break;
                case 5:
                    condicion = FALSE;
                    break;
            }
        }
    }
}