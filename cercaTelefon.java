import java.io.*;

/* Es passaran parametres a la entrada
*
*
* En el cas que es pasin 3 serà per afegir un contacte
*
*   >java cercaTelefon add Pep 345345345
*
*
* En el cas de passar 2 sera per cercar el telefon del nom associat al segon parametre.
* Retorna el telèfon associat. Si no existeix retorna una cadena que avisa.
*
*   >java cercaTelefon find Pep
*
* */

public class cercaTelefon {

    public static void main (String []args ){
        if (args[0].equals("add")){
            System.out.println("Afegint...");
            afegir(args[1], args[2]);
        }else if (args[0].equals("find")){
            System.out.println("Cerca...");
            cerca(args[1]);

        }else{
            System.out.println("Parametres erronis");
        }
    }


    public static void cerca(String a){

        try{
            FileInputStream f = new FileInputStream("agenda.txt");
            ObjectInputStream ois = new ObjectInputStream(f);

            Boolean sortir = false;

            //Cuando no haya mas objetos saltara la excepcion EOFException
            while(sortir!= true){
                contacte aux=(contacte)ois.readObject();

                System.out.println(aux.getNumero());

                if ((a.compareTo(aux.getNom())==0)) {
                    System.out.println(aux.getNumero());
                    sortir=true;
                }else{
                }

            }


        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(EOFException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();

        }

    }


    public static void afegir(String nom, String tel){

        contacte c = new contacte();

        c.setNom(nom);
        Integer t = Integer.valueOf(tel);
        c.setNumero(t);

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
