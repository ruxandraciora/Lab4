package Problema;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Deserializare {

    static Serializare lista;
    public static void deserializare()
    {
        try
        {
            FileInputStream file = new FileInputStream("echip.bin");
            ObjectInputStream obj = new ObjectInputStream(file);
            try
            {
                lista = (Serializare)obj.readObject();
            }
            catch(ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            System.out.println("Noua lista: "+lista);
            file.close();
            obj.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
