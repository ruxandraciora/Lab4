package Problema;

public class Echipament {
    private String denumire;
    private int nr_inv;
    private float pret;
    private String zona_mag;
    private Situatie_echipament situatie;
    private Tip tip;

    public Echipament(){}
    public Echipament(String denumire,int nr_inv, float pret, String zona_mag, Situatie_echipament situatie, Tip tip)
    {
        this.denumire=denumire;
        this.nr_inv=nr_inv;
        this.pret=pret;
        this.zona_mag=zona_mag;
        this.situatie=situatie;
        this.tip=tip;
    }

    public String toString()
    {
        return ("Denumire: "+denumire+"\nNumar de inventar: "+nr_inv+"\nPret: "+pret+"\nZona magazin: "+zona_mag+"\nStare: "+situatie);
    }
    enum Situatie_echipament
    {
        achizitionat,
        expus,
        vandut
    }

    enum Tip
    {
        imprimanta,
        copiator,
        sistem_de_calcul
    }

    public Tip getTip()
    {
        return tip;
    }

    public String getDenumire()
    {
        return denumire;
    }

    public void setStare(String stare)
    {
        situatie=Situatie_echipament.valueOf(stare);
    }

    public String getStare()
    {
        return situatie.toString();
    }
}


