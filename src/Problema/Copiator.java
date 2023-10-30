package Problema;

public class Copiator extends Echipament{
    private int p_ton;

    private Format format;

    public Copiator() {}

    public Copiator(String denumire, int nr_inv, float pret, String zona_mag, Situatie_echipament situatie, Tip tip, int p_ton, Format format)
    {
        super(denumire,nr_inv,pret,zona_mag,situatie,tip);
        this.p_ton=p_ton;
        this.format=format;
    }

    @Override public String toString()
    {
        return(super.toString()+"\nNumar de pagini/toner: "+p_ton+"\nFormat: "+format);
    }

    public void setFormat(String form)
    {
        format=Format.valueOf(form);
    }

    public Format getFormat()
    {
        return format;
    }
    enum Format
    {
        A3,
        A4
    }

}
