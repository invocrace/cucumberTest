package appli;

import domaine.Personne;
import repositories.RepositoryPersonneInterface;

import java.util.List;
import java.util.stream.Collectors;

public class ConnectingAPerson implements ConnectInterface {

     RepositoryPersonneInterface repositoryPersonneInterface;

    @Override
    public String connect(String email, String mdp) {
        List<Personne> personnes = repositoryPersonneInterface.getPersonnes();
        List<Personne> personnePresent = personnes.stream()
                .filter(personne -> personne.getEmail().equals(email) && personne.getMotDePasse().equals(mdp))
                .collect(Collectors.toList());
        if( personnePresent.isEmpty()){
            return "Le nom utilisateur ou le mot de passe est incorrect";
        }else return "connected";



    }
}
