import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args){

        // Testare interogari din clasa Jucator

        JucatorService jucatorService = new JucatorInMemoryService();

        Jucator jucator1 = new Jucator("Tanase","Florin","0745637291","florin.tanase@yahoo.com",10800,"Roman",25,185,"Atacant","Drept");
        Jucator jucator2 = new Jucator("Vinicius","Paulo","0725431579","ViniPaulo@yahoo.com",5500,"Brazilian",37,186,"Fundas","Ambele");
        Jucator jucator3 = new Jucator("Tarnovanu","Stefan","0739238201","stefftarno@gmail.com",3200,"Roman",21,197,"Portar","Stang");

        jucatorService.save(jucator1);
        jucatorService.save(jucator2);
        jucatorService.save(jucator3);

        System.out.println("Testare interogari din clasa JUCATOR:" + "\n");

        System.out.println("Toti jucatorii inregistrati sunt:");
        List<Jucator> lista1= jucatorService.getAllSorted();
        for(int i=0; i< lista1.size();i++)
        {
            System.out.println(lista1.get(i));
        }

        System.out.println("\n");
        System.out.println("Jucatorii cautati dupa nume sunt");
        System.out.println(jucatorService.getByNume("Tanase") +"\n");

        System.out.println("Jucatorii sub varsta mentionata sunt:");
        List<Jucator> lista= jucatorService.findPlayersUnder(26);
        for(int i=0; i< lista.size();i++)
        {
            System.out.println(lista.get(i));
        }

        System.out.println("\n");
        System.out.println("Jucatorii care pot suta cu piciorul mentionat sunt:");
        List<Jucator> lista2= jucatorService.findPlayersByFoot("Drept");
        for(int i=0; i< lista2.size();i++)
        {
            System.out.println(lista2.get(i));
        }

        System.out.println("\n");
        System.out.println("Jucatorii dupa micsorarea cu 1000euro a salariului pentru cei cu salariul peste 10000 euro:");
        jucatorService.updateAboveSalary(10000);
        List<Jucator> lista7 = jucatorService.getAllSorted();
        for(int i=0; i< lista7.size();i++)
        {
            System.out.println(lista7.get(i));
        }
        System.out.println("\n");


        System.out.println("Jucatorii dupa eliminarea jucatorului mentionat sunt:");
        jucatorService.deleteByFullName("Vinicius","Paulo");
        List<Jucator> lista10 = jucatorService.getAllSorted();
        for(int i=0; i< lista10.size();i++)
        {
            System.out.println(lista10.get(i));
        }

        System.out.println("\n");


        System.out.println("-----------------------------------------------------------------------" + "\n");


        //----------------------------------------------------------------------------------------------------------------------------------

        //Testare interogari din clasa STADION

        StadionService stadionService= new StadionInMemoryService();
        Stadion stadion1 = new Stadion("Arena Nationala", 55634,"iarba naturala", "Bulevardul Basarabia 37-39, București 022103" );
        Stadion stadion2 = new Stadion("Giulesti", 19100,"iarba naturala", "Calea Giulești 18, București" );

        stadionService.save(stadion1);
        stadionService.save(stadion2);

        System.out.println("Testare interogari din clasa STADION:" + "\n");

        System.out.println("Toate stadionele inregistrate sunt:");
        Set<Stadion> lista3= stadionService.getAll();
        for (Stadion element : lista3)
            System.out.println(element);

        System.out.println("\n");

        System.out.println("Stadioanele care au capacitatea peste cea mentionata sunt:");
        Set<Stadion> lista4= stadionService.findStadiumAboveCapacity(20000);
        for (Stadion element : lista4)
            System.out.println(element);

        System.out.println("\n");

        System.out.println("Stadioanele cautate dupa denumire sunt");
        System.out.println(stadionService.getByDenumire("Giulesti") +"\n");

        System.out.println("Stadioanele dupa ce s-a eliminat stadionul mentionat sunt:");
        stadionService.delete(stadion1);
        Set<Stadion> lista9 = stadionService.getAll();
        for (Stadion element : lista9)
            System.out.println(element);

        System.out.println("\n");

        System.out.println("\n");
        System.out.println("-----------------------------------------------------------------------" + "\n");

        //----------------------------------------------------------------------------------------------------------------------------------

        //Testare interogari din clasa BILET

        BiletService biletService= new BiletInMemoryService();
        Bilet bilet1 = new Bilet("Peluza Nord", 10 );
        Bilet bilet2 = new Bilet("Peluza Sud", 15);
        Bilet bilet3 = new Bilet("Tribuna 1", 50 );
        Bilet bilet4 = new Bilet("Tribuna 2", 30);
        Bilet bilet5 = new Bilet("Tribuna Oficiala", 100 );
        Bilet bilet6 = new Bilet("Loja", 200 );

        biletService.save(bilet1);
        biletService.save(bilet2);
        biletService.save(bilet3);
        biletService.save(bilet4);
        biletService.save(bilet5);
        biletService.save(bilet6);


        System.out.println("Testare interogari din clasa BILET:" + "\n");

        System.out.println("Toate biletele inregistrate sunt:");
        List<Bilet> lista5= biletService.getAllSorted();
        for(int i=0; i< lista5.size();i++)
        {
            System.out.println(lista5.get(i));
        }

        System.out.println("\n");


        System.out.println("Biletele cautate dupa sector sunt");
        System.out.println(biletService.getBySector("Peluza Nord") +"\n");

        System.out.println("Biletele dupa ce s-a eliminat biletul mentionat sunt:");
        biletService.deleteBySector("Peluza Sud");
        List<Bilet> lista6 = biletService.getAllSorted();
        for(int i=0; i< lista6.size();i++)
        {
            System.out.println(lista6.get(i));
        }

        System.out.println("\n");
    }

}
