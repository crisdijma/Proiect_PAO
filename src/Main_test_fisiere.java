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

        Jucator jucator1 = new Jucator("Demir","Yusuf","0726318291","demiyus@yahoo.com",17000,"Danez",18,189,"Fundas","Stang");
        jucatorService.save(jucator1);

        List<Jucator> lista_plus_adaugare_jucator= jucatorService.getAllSorted();

        System.out.println("Toti jucatorii din fisierul jucatori.csv (dupa adaugare jucator) sunt: \n");

        for(int i=0; i< lista_plus_adaugare_jucator.size();i++)
        {
            System.out.println(lista_plus_adaugare_jucator.get(i));
        }

        DateTimeFormatter date_ad1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime_ad1 = LocalDateTime.now();
        auditService.scriere("Add_player", date_ad1.format(localDateTime_ad1));

        System.out.println("Toti jucatorii din fisierul jucatori.csv (dupa stergere jucator) sunt: \n");
        jucatorService.delete(jucator1);
        List<Jucator> lista10 = jucatorService.getAllSorted();
        for(int i=0; i< lista10.size();i++)
        {
            System.out.println(lista10.get(i));
        }

        DateTimeFormatter date_del1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime_del1 = LocalDateTime.now();
        auditService.scriere("Delete_player", date_del1.format(localDateTime_del1));

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


        Antrenor antrenor1 = new Antrenor("Ion","George","0710256477","ionion1000@yahoo.com",2490,"Moldovean","Popa Iosif","Licenta in curs","Antrenor portari rezerva");
        antrenorService.save(antrenor1);

        List<Antrenor> lista_plus_adaugare_antrenor= antrenorService.getAllSorted();

        System.out.println("Toti antrenorii din fisierul antrenori.csv (dupa adaugare antrenor) sunt: \n");

        for(int i=0; i< lista_plus_adaugare_antrenor.size();i++)
        {
            System.out.println(lista_plus_adaugare_antrenor.get(i));
        }

        DateTimeFormatter date_ad2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime_ad2 = LocalDateTime.now();
        auditService.scriere("Add_coach", date_ad2.format(localDateTime_ad2));

        System.out.println("Toti antrenorii din fisierul antrenori.csv (dupa stergere antrenor) sunt: \n");
        antrenorService.delete(antrenor1);
        List<Antrenor> lista11 = antrenorService.getAllSorted();
        for(int i=0; i< lista11.size();i++)
        {
            System.out.println(lista11.get(i));
        }

        DateTimeFormatter date_del2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime_del2 = LocalDateTime.now();
        auditService.scriere("Delete_coach", date_del2.format(localDateTime_del2));


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

        Bilet bilet1 = new Bilet("Loja VIP 2",400);
        biletService.save(bilet1);

        List<Bilet> lista_plus_adaugare_bilet= biletService.getAllSorted();
        System.out.println("Toare biletele din bilete.csv (dupa adaugare bilet) sunt: \n");
        for(int i=0; i< lista_plus_adaugare_bilet.size();i++)
        {
            System.out.println(lista_plus_adaugare_bilet.get(i));
        }

        DateTimeFormatter date_ad3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime_ad3 = LocalDateTime.now();
        auditService.scriere("Add_ticket", date_ad3.format(localDateTime_ad3));

        System.out.println("Toate biletele din bilete.csv (dupa stergere bilet) sunt: \n");
        biletService.delete(bilet1);
        List<Bilet> lista12 = biletService.getAllSorted();
        for(int i=0; i< lista12.size();i++)
        {
            System.out.println(lista12.get(i));
        }

        DateTimeFormatter date_del3 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime_del3 = LocalDateTime.now();
        auditService.scriere("Delete_ticket", date_del3.format(localDateTime_del3));

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

        Stadion stadion1 = new Stadion("Dan Paltiniseanu",32980,"iarba naturala","Strada Stadionului, Timisoara");
        stadionService.save(stadion1);

        Set<Stadion> lista_plus_adaugare_stadion= stadionService.getAll();
        System.out.println("Toare stadioanele din stadioane.csv (dupa adaugare stadion) sunt: \n");
        for (Stadion element : lista_plus_adaugare_stadion)
            System.out.println(element);

        DateTimeFormatter date_ad4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime_ad4 = LocalDateTime.now();
        auditService.scriere("Add_ticket", date_ad4.format(localDateTime_ad4));



        System.out.println("Toate stadioanele din stadioane.csv (dupa stergere stadion) sunt: \n");
        stadionService.delete(stadion1);
        Set<Stadion> lista13 = stadionService.getAll();
        for (Stadion element : lista13)
            System.out.println(element);

        DateTimeFormatter date_del4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime_del4 = LocalDateTime.now();
        auditService.scriere("Delete_stadium", date_del4.format(localDateTime_del4));

        System.out.println("\n");
        System.out.println("--------------------------------------------------------------------------\n");
    }
}
