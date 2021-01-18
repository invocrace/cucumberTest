package repositories;

import domaine.Personne;

import java.util.ArrayList;
import java.util.List;


public class RepositoryPersonnesTest implements RepositoryPersonneInterface {
    final private List<Personne> personnes = new ArrayList<Personne>();

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void addPerson(){
        Personne personne1 = new Personne();
        personne1.setNom("DelaJungle");
        personne1.setPrenom("Georges");
        personne1.setEmail("GeorgesDeLaJungle@gmail.Com");
        personne1.setMotDePasse("azerty123");
        personnes.add(personne1);
    }
}