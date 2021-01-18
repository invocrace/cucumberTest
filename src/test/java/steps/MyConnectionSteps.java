package steps;

import Dto.Client;
import appli.ConnectingAPerson;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import domaine.Personne;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class MyConnectionSteps {

    final List<Personne> personnes = new ArrayList<Personne>();
    private String resultConnected;

    @Given("^users$")
    public void users(List<Client> clients) {
        personnes.clear();
       clients.forEach(client -> { Personne personne = new Personne();
                personne.setNom(client.getNom());
                personne.setEmail(client.getEmail());
                personne.setPrenom(client.getPrenom());
                personne.setMotDePasse(client.getMotDePasse());
                personnes.add(personne);
                    });
    }

    @When("^i try to connect mySelf$")
    public void iTryToConnectMySelf(List<Personne>personnes) {
        ConnectingAPerson connectingPerson = new ConnectingAPerson();
                personnes
                        .forEach(personne -> resultConnected = connectingPerson.connect(personne.getEmail(),personne.getMotDePasse()));
    }

    @Then("^this message is displyed\"([^\"]*)\"$")
    public void thisMessageIsDisplyed(String arg0) throws Throwable {
        Assert.assertEquals("Le nom utilisateur ou le mot de passe est incorrect", resultConnected);
    }
}
