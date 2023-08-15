import java.util.Scanner;

public class Comprador2{

    //Inicializar variables
    Scanner nombre;
    Scanner email;
    Scanner cantBoleto;
    Scanner presupuesto;
    Scanner x;
    Scanner y;

    //Métodos clase comprador
    public Comprador2(Scanner nombre, Scanner email, Scanner x, Scanner y){
        this.nombre = nombre;
        this.email = email;
        this.x = x;
        this.y = y;
    }

    //Cantidad de boletos usuario
    public void cantBoleto(Scanner x){
        System.out.println("\nIngresa cantidad de boletos: ");
        int cantBoletoLine = Integer.parseInt(x.next());
        System.out.println("Ha adquirido " + cantBoletoLine + " boleto");
    }

    //Presupuesto usuario 
    public void presupuesto(Scanner y){
        System.out.println("\nIngresa tu presupuesto: ");
        int presupuestoLine = Integer.parseInt(y.next());
    }
    
    //Nombre usuario
    public void readNombre(){
        System.out.println("\nIngresa tu nombre: ");
        String nombreLine = nombre.nextLine();
    }

    //Email usuario
    public void readEmail(){
        System.out.println("\nIngresa tu correo: ");
        String emailLine = email.nextLine();
    }
}

