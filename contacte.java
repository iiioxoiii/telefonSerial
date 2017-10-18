import java.io.Serializable;

public class contacte implements Serializable {
    private String nom;
    private Integer numero;

    public contacte(){
    }

    public contacte(String nom, Integer numero){
        this.nom= nom;
        this.numero=numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
