import java.io.*;

public class testagenda {

   /* public static void main (String []args ){
        test(args[0], args[1]);
    }*/


    public static void test(String nom, String telefon){

        contacte c=new contacte();

        c.setNom(nom);
        Integer tel = Integer.valueOf(telefon);
        c.setNumero(tel);

        creaArxiu(c);
    }

    public static void creaArxiu(contacte c){
        try {
            File f = new File("agenda.txt");
            FileOutputStream fo = new FileOutputStream(f,true);
            ObjectOutputStream o = new ObjectOutputStream(fo);

            o.writeObject(c);

            o.close();
            fo.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
