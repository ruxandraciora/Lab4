package Problema;

public class SistemDeCalcul extends Echipament{
    private String tip_mon;
    private float vit_proc;
    private float c_hdd;
    private SistemOperare sistem;

    public SistemDeCalcul() {}

    public SistemDeCalcul(String denumire,int nr_inv, float pret, String zona_mag, Situatie_echipament situatie,Tip tip, String tip_mon,float vit_proc,float c_hdd,SistemOperare sistem)
    {
        super(denumire,nr_inv,pret,zona_mag,situatie,tip);
        this.tip_mon=tip_mon;
        this.vit_proc=vit_proc;
        this.c_hdd=c_hdd;
        this.sistem=sistem;
    }

    @Override public String toString()
    {
        return(super.toString()+"\nTipul monitorului: "+tip_mon+"\nViteza procesorului: "+vit_proc+"\nCapacitate HDD: "+c_hdd+"\nSistem de operare: "+sistem);
    }

    public void setSistem(String sist)
    {
        sistem=SistemOperare.valueOf(sist);
    }

    public SistemOperare getSistem()
    {
        return sistem;
    }
    enum SistemOperare
    {
        Windows,
        Linux
    }

}
