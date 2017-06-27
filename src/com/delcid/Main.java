package com.delcid;

import java.util.Scanner;

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
            System.out.println("1.Cuenta Normal");
            System.out.println("2.Cuenta A largo Plazo");
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

    public static void volveralmenuprincipal() {
        System.out.println("Desea Intentar de Nuevo ?");
        System.out.println("1. si");
        System.out.println("2. Volver al Menu Principal");
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
        int opciondep;
        int opcioncuentas;
        Double mont;
        String nombredepositente;
        Scanner lector = new Scanner(System.in);
        menu();
        opcion = lector.nextInt();
        while (condicion == TRUE) {
            if (Cliente.registro.size() == 0) {
                System.out.println("No hay clientes Registrados, Agregue Cuentas a Nuevos Clientes");
                opcion = 1;
            }
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
                    System.out.println("1. Deposito en Cuenta Propia");
                    System.out.println("2. Deposito en Cuenta Aparte");
                    opciondep = lector.nextInt();
                    System.out.println("Ingrese el numero de cuenta");
                    dest = lector.next();
                    if (deposito.buscarcuenta(dest) > -1) {
                        Cliente busquedacliente = new Cliente();
                        System.out.println("Ingrese el Monto a Depositar");
                        mont = lector.nextDouble();
                        if (opciondep == 2) {
                            System.out.println("Ingrese el nombre del depositante");
                            nombredepositente = lector.next();
                            deposito.Depositar(mont, deposito.buscarcuenta(dest));
                            System.out.println("Transaccion Exitosa!");
                            System.out.println("---------Depositante-------Cuenta Receptor--------Nombre Receptor---------Deposito-----");
                            System.out.println("            " + nombredepositente + "              " + dest + "             " + Cliente.registro.get(busquedacliente.posicioncliente(dest)).getNombre() + "          " + mont);
                        } else if (opciondep == 1) {
                            System.out.println("Ingrese el ID del Depositante");
                            String depid = lector.next();
                            if (deposito.buscarcuentaid(dest, depid) > -1) {
                                deposito.Depositar(mont, deposito.buscarcuenta(dest));
                                Cuenta.mostrarceuntaindividual(deposito.buscarcuentaid(dest,depid));
                                System.out.println();
                            }

                        }

                        menu();
                        opcion = lector.nextInt();
                    } else {
                        System.out.println("El numero de Cuenta no Exite en el sistema");
                        volveralmenuprincipal();
                        if (lector.nextInt() == 2) {
                            menu();
                            opcion = lector.nextInt();
                        }
                    }
                    break;
                case 3:
                    Cuenta retiro = new Cuenta();
                    System.out.println("Ingrese el numero de cuenta");
                    dest = lector.next();
                    if (retiro.buscarcuenta(dest) == -1) {
                        System.out.println("El numero de cuenta que has ingresado no existe");
                        volveralmenuprincipal();
                        if (lector.nextInt() == 2) {
                            menu();
                            opcion = lector.nextInt();
                        }
                    } else {
                        System.out.println("Ingrese el numero de identidad del Cliente");
                        id = lector.next();
                        System.out.println("Ingrese el Monto a Retirar");
                        mont = lector.nextDouble();
                        if (retiro.buscarcuentaid(dest, id) == -1) {
                            System.out.println("El numero de indentidad ingresado no le pertence a ningun cliente");
                        } else if (retiro.buscartipo(dest) == 2) {
                            Cuenta_Largo_Plazo largo = new Cuenta_Largo_Plazo();
                            largo.Retirar(mont, largo.buscarcuentaid(dest, id));
                        } else if (retiro.buscartipo(dest) == 1) {
                            retiro.Retirar(mont, retiro.buscarcuentaid(dest, id));
                        }
                        menu();
                        opcion = lector.nextInt();
                    }
                    break;
                case 4:
                    System.out.println(Bitacora.accion);
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