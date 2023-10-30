package Problema;

public class Imprimanta extends Echipament {
    private int ppm;
    private String dpi;
    private int p_car;
    private Mod_tiparire mod_tiparire;

    public Imprimanta() {}

    public Imprimanta(String denumire, int nr_inv, float pret, String zona_mag, Situatie_echipament situatie, Tip tip, int ppm, String dpi, int p_car, Mod_tiparire mod_tiparire)
    {
        super(denumire,nr_inv,pret,zona_mag,situatie,tip);
        this.ppm=ppm;
        this.dpi=dpi;
        this.p_car=p_car;
        this.mod_tiparire=mod_tiparire;
    }

    @Override public String toString()
    {
        return (super.toString() + "\nNumar de pagini scrise pe minut: "+ppm+"\nRezolutie: "+dpi+"\nNumar de pagini/cartus: "+p_car+"\nMod de tiparire: "+mod_tiparire);
    }

    public void setMod(String mod)
    {
        mod_tiparire=Mod_tiparire.valueOf(mod);
    }

    public Mod_tiparire getMod_tiparire()
    {
        return mod_tiparire;
    }
    enum Mod_tiparire
    {
        color,
        albnegru
    }


}

