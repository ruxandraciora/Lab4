package Problema;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //CITIRE FISIER SI ADAUGARE ELEMENTE IN LISTA
        Scanner readFile = new Scanner(new File("echipamente.txt"));

        Echipament[] ech = new Echipament[50];
        List<Echipament> lista = new ArrayList<>();
        int nr_e = 0;
        while (readFile.hasNext()) {
            String line = readFile.nextLine();
            String[] split = line.split(";");
            String[] date = new String[50];
            int i = 0;
            for (String s : split) {
                date[i] = s;
                //System.out.println(date[i]);
                i++;
            }

            String denum = date[0];
            int nr_i = Integer.parseInt(date[1]);
            float pret = Float.parseFloat(date[2]);
            String zona = date[3];
            String situatie = date[4];
            Echipament.Situatie_echipament sit = Echipament.Situatie_echipament.valueOf(situatie);
            String tip = date[5];
            System.out.println("Tip: "+tip);
            Echipament.Tip tip_e = Echipament.Tip.valueOf(tip);
            System.out.println("Tip_e1"+tip_e);
            ech[nr_e] = new Echipament(denum, nr_i, pret, zona, sit, tip_e);
            nr_e++;

            switch (tip_e) {
                case imprimanta:
                    int pp = Integer.parseInt(date[6]);
                    String dp = date[7];
                    int nrp = Integer.parseInt(date[8]);
                    String mod_t = date[9];
                    Imprimanta.Mod_tiparire mod = Imprimanta.Mod_tiparire.valueOf(mod_t);

                    Imprimanta imp = new Imprimanta(denum, nr_i, pret, zona, sit, tip_e, pp, dp, nrp, mod);
                    lista.add(imp);
                    break;
                case copiator:
                    int nr_p = Integer.parseInt(date[6]);
                    String form = date[7];
                    Copiator.Format f = Copiator.Format.valueOf(form);

                    Copiator cop = new Copiator(denum, nr_i, pret, zona, sit, tip_e, nr_p, f);
                    lista.add(cop);
                    break;

                case sistem_de_calcul:
                    String monitor = date[6];
                    float viteza = Float.parseFloat(date[7]);
                    float cap = Float.parseFloat(date[8]);
                    String sist = date[9];
                    SistemDeCalcul.SistemOperare so = SistemDeCalcul.SistemOperare.valueOf(sist);

                    SistemDeCalcul s = new SistemDeCalcul(denum, nr_i, pret, zona, sit, tip_e, monitor, viteza, cap, so);
                    lista.add(s);
                    break;
            }

        }
        readFile.close();
        //MENIU
        Scanner read = new Scanner(System.in);
        int optiune;
        do {
            System.out.println("0. Exit.");
            System.out.println("1. Afisarea tuturor echipamentelor.");
            System.out.println("2. Afisarea imprimantelor.");
            System.out.println("3. Afisarea copiatoarelor.");
            System.out.println("4. Afisarea sistemelor de calcul.");
            System.out.println("5. Modificarea starii in care se afla un echipament.");
            System.out.println("6. Setarea unui anumit mod de scriere pentru o imprimanta.");
            System.out.println("7. Setarea unui format de copiere pentru copiatoare.");
            System.out.println("8. Instalarea unui anumit sistem de operare pe un sistem de calcul.");
            System.out.println("9. Afişarea echipamentelor vândute.");
            System.out.println("10. Să se realizeze două metode statice pentru serializarea / deserializarea colecției de\n" +
                    "obiecte în fișierul echip.bin.");
            System.out.println("Introduceti optiunea: ");
            optiune = read.nextInt();
            switch (optiune) {
                case 0:
                    break;
                case 1:
                    for (Echipament e : lista) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    for (Echipament e:lista)
                    {
                        if(e.getTip().toString().compareTo("imprimanta")==0)
                        {
                            System.out.println(e);
                        }
                    }
                    break;
                case 3:
                    for (Echipament e:lista)
                    {
                        if(e.getTip().toString().compareTo("copiator")==0)
                        {
                            System.out.println(e);
                        }
                    }
                    break;
                case 4:
                    for (Echipament e:lista)
                    {
                        if(e instanceof SistemDeCalcul)
                        {
                            System.out.println(e);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Introduceti denumirea echipamentului: ");
                    String denumire = read.nextLine();
                    denumire = read.nextLine();
                    System.out.println(denumire);
                    int ok=0;
                    for(Echipament e:lista)
                    {
                        if(e.getDenumire().compareTo(denumire)==0) {
                            ok = 1;
                            System.out.println("Starea echipmentului este: "+e.getStare().toString());
                            System.out.println("Introduceti starea modificata: ");
                            //read.next();
                            String stare = read.next();
                            while(stare.compareTo("achizitionat") !=0 && stare.compareTo("expus")!=0 && stare.compareTo("vandut")!=0)
                            {
                                System.out.println("Starile posibile sunt: achizitionat, expus, vandut. Introduceti inca o data: ");;
                                stare = read.next();
                            }
                            e.setStare(stare);
                            System.out.println(e);
                        }
                    }
                    if(ok==0)
                        System.out.println("Produsul nu a fost gasit in lista!");
                    break;
                case 6:
                    System.out.println("Introduceti denumirea imprimantei: ");
                    String denumire_i = read.nextLine();
                    denumire_i = read.nextLine();
                    ok=0;
                    for(Echipament e: lista)
                    {
                        if(e.getDenumire().compareTo(denumire_i)==0) {
                            ok = 1;
                            System.out.println("Modul de tiparire al imprimantei selectate este: "+((Imprimanta) e).getMod_tiparire());
                            System.out.println("Introduceti modul de scriere nou: ");
                            String mod = read.next();
                            while(mod.compareTo("albnegru") !=0 && mod.compareTo("color")!=0)
                            {
                                System.out.println("Modurile de tiparire posibile sunt: albnegru, color. Introduceti inca o data: ");;
                                mod = read.next();
                            }
                            ((Imprimanta) e).setMod(mod);
                            System.out.println(e);
                        }

                    }
                    if(ok==0)
                        System.out.println("Produsul nu a fost gasit in lista!");
                    break;
                case 7:
                    System.out.println("Introduceti denumirea copiatorului: ");
                    read.nextLine();
                    denumire=read.nextLine();
                    ok=0;
                    for(Echipament e:lista)
                    {
                        if(e.getDenumire().compareTo(denumire)==0)
                        {
                            ok=1;
                            System.out.println("Formatul de copiere al copiatorului selectat este: "+((Copiator) e).getFormat());
                            System.out.println("Introduceti formatul nou: ");
                            String form=read.next();
                            while(form.compareTo("A3")!=0 && form.compareTo("A4")!=0)
                            {
                                System.out.println("Formatul de copiere poate sa fie doar A3 sau A4. Introduceti din nou: ");
                                form=read.next();
                            }
                            ((Copiator) e).setFormat(form);
                            System.out.println(e);
                        }
                    }
                    if(ok==0)
                        System.out.println("Produsul nu a fost gasit in lista!");
                    break;

                case 8:
                    System.out.println("Introduceti denumirea sistemului de calcul: ");
                    read.nextLine();
                    denumire=read.nextLine();
                    ok=0;
                    for(Echipament e:lista)
                    {
                        if(e.getDenumire().compareTo(denumire)==0)
                        {
                            ok=1;
                            System.out.println("Sistemul de operare al sistemului de calcul selectat este: "+((SistemDeCalcul) e).getSistem());
                            System.out.println("Introduceti sistemul de operare nou: ");
                            String sist=read.next();
                            while(sist.compareTo("Windows")!=0 && sist.compareTo("Linux")!=0)
                            {
                                System.out.println("Sistemul de operare poate sa fie doar Windows sau Linux. Introduceti din nou: ");
                                sist=read.next();
                            }
                            ((SistemDeCalcul) e).setSistem(sist);
                            System.out.println(e);
                        }
                    }
                    if(ok==0)
                        System.out.println("Produsul nu a fost gasit in lista!");
                    break;

                case 9:
                    System.out.println("Echipamentele vandute: ");
                    for(Echipament e:lista)
                    {
                        if(e.getStare().toString().compareTo("vandut")==0)
                        {
                            System.out.println(e);
                        }
                    }
                    break;
                case 10:
                    Serializare.serializare(lista);
                    //Deserializare.deserializare();
                    break;
            }

        }while(optiune!=0);
    }
}
