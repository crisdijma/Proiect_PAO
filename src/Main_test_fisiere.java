import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main_test_fisiere {

    public static void main(String[] args){

        //AUDIT
        AuditService auditService = new AuditService();
        /////////////

        System.out.println("Testare JucatoriCsvSerice \n");

        JucatorService jucatorService = new JucatoriCsvService();

        List<Jucator> lista_toti_jucatorii= jucatorService.getAllSorted();

        System.out.println("Toti jucatorii din fisierul jucatori.csv sunt: \n");

        for(int i=0; i< lista_toti_jucatorii.size();i++)
        {
            System.out.println(lista_toti_jucatorii.get(i));
        }

        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        auditService.scriere("Print_all_players", date.format(localDateTime));

        System.out.println("\n");
        System.out.println("--------------------------------------------------------------------------\n");


//        #########################################################################
        Scanner scanner = new Scanner(System.in);
        String s= scanner.nextLine(); ///SE DA ENTER CA SA AFISEZE URMATORUL (pentru a vedea mai bine cum scrie ora in audit)


        System.out.println("Testare AntrenorCsvSerice \n");

        AntrenorService antrenorService = new AntrenorCsvService();

        List<Antrenor> lista_toti_antrenorii= antrenorService.getAllSorted();

        System.out.println("Toti antrenorii din fisierul antrenori.csv sunt: \n");

        for(int i=0; i< lista_toti_antrenorii.size();i++)
        {
            System.out.println(lista_toti_antrenorii.get(i));
        }

        DateTimeFormatter date2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime2 = LocalDateTime.now();
        auditService.scriere("Print_all_coaches", date2.format(localDateTime2));

        System.out.println("\n");
        System.out.println("--------------------------------------------------------------------------\n");

//        #########################################################################
        Scanner scanner2 = new Scanner(System.in);
        String s2= scanner.nextLine(); ///SE DA ENTER CA SA AFISEZE URMATORUL (pentru a vedea mai bine cum scrie ora in audit)

        System.out.println("Testare BiletCsvSerice \n");

        BiletService biletService = new BiletCsvService();

        List<Bilet> lista_toate_biletele= biletService.getAllSorted();

        System.out.println("Toate biletele din fisierul bilete.csv sunt: \n");

        for(int i=0; i< lista_toate_biletele.size();i++)
        {
            System.out.println(lista_toate_biletele.get(i));
        }

        DateTimeFormatter date3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime3 = LocalDateTime.now();
        auditService.scriere("Print_all_tickets", date3.format(localDateTime3));

        System.out.println("\n");
        System.out.println("--------------------------------------------------------------------------\n");


        //        #########################################################################

        Scanner scanner3 = new Scanner(System.in);
        String s3= scanner.nextLine(); ///SE DA ENTER CA SA AFISEZE URMATORUL (pentru a vedea mai bine cum scrie ora in audit)

        System.out.println("Testare StadionCsvSerice \n");

        StadionService stadionService = new StadionCsvService();

        Set<Stadion> lista_toate_stadioanele= stadionService.getAll();

        System.out.println("Toate stadioanele din fisierul stadioane.csv sunt: \n");

        for (Stadion element : lista_toate_stadioanele)
            System.out.println(element);

        DateTimeFormatter date4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime4 = LocalDateTime.now();
        auditService.scriere("Print_all_stadiums", date4.format(localDateTime4));

        System.out.println("\n");
        System.out.println("--------------------------------------------------------------------------\n");
    }
}
