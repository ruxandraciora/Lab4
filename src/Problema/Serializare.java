package Problema;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class Serializare {

    public static void serializare(List<Echipament> lista)
    {
        try(FileOutputStream file = new FileOutputStream("echip.bin");
            ObjectOutputStream obj = new ObjectOutputStream(file))
        {
            obj.writeObject(lista);
            //System.out.println("Object wrote: "+lista);
            //obj.flush();
            obj.close();
            file.close();
            System.out.println("Serializare in echip.bin.");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}
