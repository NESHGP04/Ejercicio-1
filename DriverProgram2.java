/*Marinés García - 23391
 * Ejercicio1: Overloading y relaciones entre clases
 * Main program
*/

//import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class DriverProgram2{
    public static void main(String[] args){

        //Declaración variables
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion = 0;
        boolean vender = true;

        int dispBoleto = 60;
        Random boletoRan;
        Random rangoRan1;
        int boleto;
        ArrayList <Integer> boletos = new ArrayList <Integer> ();

        Comprador comprador = new Comprador();
        
        Localidad localidad = new Localidad();
        int espLoc1 = 20;
        int espLoc2 = 20;
        int espLoc3 = 20;
        int precioLoc = 0;
        int locs;

        int disp = 0;

        Scanner scanCant;
        Scanner scanPresupuesto;
        int cantBoletoLine = 0;
        int presupuestoLine = 0;

        while(!salir){ 

            //Menú
            System.out.println("\n === Venta boletos Eras Tour (Taylor's Version) === \n ");
            System.out.println("\n1. Nuevo comprador.");
            System.out.println("2. Nueva solicitud de boletos");
            System.out.println("3. Consultar disponibilidad total");
            System.out.println("4. Consultar disponibilidad individual");
            System.out.println("5. Reporte de caja");
            System.out.println("6. Salir\n");

            System.out.println("Escribe una de las opciones: ");            
            opcion = sn.nextInt();
            try{    
            switch(opcion){
                case 1:
                //Creación del nuevo cliente
                    System.out.println("Has seleccionado la opcion 1");

                    Scanner scanNombre = new Scanner(System.in);
                    Scanner scanEmail = new Scanner(System.in);
                    scanCant = new Scanner(System.in);
                    scanPresupuesto = new Scanner(System.in);
                    Comprador2 comprador2 = new Comprador2(scanNombre, scanEmail, scanCant,scanPresupuesto);
                    comprador2.readNombre();
                    comprador2.readEmail();
                    comprador2.cantBoleto(scanCant); 
                    comprador2.presupuesto(scanPresupuesto);

                    cantBoletoLine = Integer.parseInt(scanCant.next());
                    presupuestoLine = Integer.parseInt(scanPresupuesto.next());

                    break;

                case 2:
                //Genera tickets y su rango
                    System.out.println("Has seleccionado la opcion 2");

                    boletoRan = new Random();
                    boletoRan.setSeed(234);
                    boleto = boletoRan.nextInt(15000 - 1 +1)+1;
                    System.out.println("Tu número de ticket es: " + boleto);

                    for(int i=1; i<=15000; i++){
                        rangoRan1 = new Random();
                        rangoRan1.setSeed(234);
                        boleto = rangoRan1.nextInt(15000 - 1 +1)+1;
                        if (boletos.contains(boleto)){
                            i--;
                            //System.out.print("Ticket adquirido con éxito!");
                        } else {
                            boletos.add(boleto); //QUITAR
                            //System.out.print("Ticket inválido, inténtelo otra vez");
                            vender = false;
                        }
                    }

                    System.out.println("Boleto es: ");
                    for (Integer n : boletos){
                        System.out.print((n+ "\t"));
                    }
                

                    //Localidad random
                    locs = localidad.getLocRan(); //No se puede void a int
                    
                    break;

                case 3:
                //Valida disponibilidad localidad
                    System.out.println("Has seleccionado la opcion 3");

                    locs = localidad.getLocRan(); //No se puede void a int
                    System.out.print(locs);

                    if (locs == 1){
                        if (espLoc1 <=20){
                            precioLoc = 100;
                            espLoc1--;
                            System.out.print("Espacio validado, continuar con compra. ");
                        } else{
                            System.out.print("Ya no hay espacio en esta localidad, favor volver a empezar.");
                            vender = false;
                        }
                    }    
                    if (locs == 2){
                        if (espLoc2 <=20){
                            precioLoc = 500;
                            espLoc1--;
                            System.out.print("Espacio validado, continuar con compra. ");
                        } else{
                            System.out.print("Ya no hay espacio en esta localidad, favor volver a empezar.");
                            vender = false;
                        } 
                    }
                    if (locs == 3){
                        if (espLoc3 <=20){
                            precioLoc = 1000;
                            espLoc3--;
                            System.out.print("Espacio validado, continuar con compra. ");
                        } else{
                            System.out.print("Ya no hay espacio en esta localidad, favor volver a empezar.");
                            vender = false;
                        }
                    }
                    break;

                case 4:
                //Disponibilidad individual
                    System.out.print("Has seleccionado la opcion 4");

                    System.out.print("\n Defina una localidad (1-3) para corroborar disponibilidad: ");
                    disp = sn.nextInt();

                    while(comprador.getCantBoleto() <= dispBoleto){
                        //comprador.setCantBoleto(-1);
                        continue; //REVISAR
                    }

                    switch(disp){
                        case 1 :
                            System.out.println("La disponibilidad de localidad 1 es de: " + espLoc1);
                            break;
                        case 2: 
                            System.out.println("La disponibilidad de localidad 2 es de: " + espLoc2);
                            break;
                        case 3:
                            System.out.println("La disponibilidad de localidad 3 es de: " + espLoc3);
                            break;                    
                        default:   
                            System.out.println("Localidad inválida, vuelva a intentar");
                            break;
                    }
                    break;

                case 5: 
                //Reporte de caja
                    System.out.println("Has seleccionado la opcion 5");

                    int total = precioLoc * cantBoletoLine;

                    if(total <= presupuestoLine){
                        continue;
                    }else{
                        System.out.println("Ya no tiene presupuesto, fin del programa");
                        vender = false;
                    }

                    System.out.println("En boletos, se ha generado: " + total);
                    break;    

                case 6:
                //Salir programa
                    System.out.println("¡Ha salido del programa!");
                    salir = true;
                    break;

                default:
                    System.out.println("Solo números entre 1 y 6.");
            }    
        } catch(InputMismatchException e){
            System.out.println("Debes ingresar un número");
            sn.next();
        }
            opcion = sn.nextInt();
            vender = false;
            sn.close();
        }    
    }
}    

