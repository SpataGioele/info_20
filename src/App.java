import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // apro scanner
        Scanner input = new Scanner(System.in);

        // creo libreria
        Lista libreria = new Lista();

        int scelta = -1;
        do {
            printMenu();
            scelta = Integer.parseInt(input.nextLine());

            switch (scelta) {
                case 0:
                    System.out.println("\nArrivederci!");
                    scelta = 0;
                    break;
                case 1:
                    System.out.println("\n- - LIBRERIA - -");
                    libreria.showInfo();
                    break;
                case 2:
                    
                    break;
                default:
                    System.out.println("\nOpzione non valida. Riprova.");
                    break;
            }
        } while (scelta != 0);

        // chiudo scanner
        input.close();
    }

    public static void printMenu() {
        System.out.println("\n- - MENU - -");
        System.out.println("1) Mostra libreria"); 
        System.out.println("2) Inserisci libro");   // ordinata
        System.out.println("0) Esci");
    }

    public static void getLibroInputs(Scanner input) {
        System.out.println("Inserisci l'isbn: ");
        String isbn = input.nextLine();
        System.out.println("Inserisci il titolo: ");
        String titolo = input.nextLine();
        System.out.println("Inserisci l'anno: ");
        int anno = Integer.parseInt(input.nextLine());
        System.out.println("Inserisci la casa editrice: ");
        String editore = input.nextLine();
        System.out.println("Inserisci il codice fiscale dell'autore: ");
        String cf = input.nextLine();
        System.out.println("Inserisci il nome dell'autore: ");
        String nome = input.nextLine();



    }
}
