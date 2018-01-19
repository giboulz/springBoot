package com.gbz.bdd.stepdefinition;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.gbz.Application;
import com.gbz.entity.Customer;
import com.gbz.repository.CustomerRepository;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SpringBootTest
@WebAppConfiguration
@ContextConfiguration(classes = { Application.class })
public class StepRoleTest {
	@Given("^un utilisateur sans rôles$")
	public void un_utilisateur_sans_roles() throws Throwable {
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Given("^sans équipe$")
	public void sans_equipe() throws Throwable {
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@When("^j'accède au privilège de l'utilisateur$")
	public void jaccede_au_privilege_de_l_utilisateur() throws Throwable {
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Then("^l'utilisateur n'a aucun privilège$")
	public void lutilisateur_n_a_aucun_privilege() throws Throwable {
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Given("^une liste de role$")
	public void une_liste_de_role(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Given("^j'attribue la liste de rôle a l'utilisateur$")
	public void jattribue_la_liste_de_role_a_l_utilisateur() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@When("^j'acc�de au privilège de l'utilisateur$")
	public void jacc_de_au_privilege_de_l_utilisateur() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Then("^l'utilisateur a la liste de privilèges suivante :$")
	public void lutilisateur_a_la_liste_de_privileges_suivante(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Given("^j'attribue la liste de rôle à l'utilisateur$")
	public void jattribue_la_liste_de_rale_a_l_utilisateur() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Given("^une entité$")
	public void une_entite() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Given("^une sous entité appartenant à l'entité$")
	public void une_sous_entité_appartenant_a_l_entite() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Given("^une équipe appartenant à la sous entité$")
	public void une_equipe_appartenant_à_la_sous_entite() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Given("^l'utilisateur qui appartient à l'équipe$")
	public void lutilisateur_qui_appartient_a_l_equipe() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Given("^j'attribue la liste de rôle a user$")
	public void jattribue_la_liste_de_role_a_user() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Given("^j'attribue la liste de rôle a equipe$")
	public void jattribue_la_liste_de_role_a_equipe() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Given("^j'attribue la liste de rôle a sous entité$")
	public void jattribue_la_liste_de_role_a_sous_entite() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Given("^j'attribue la liste de rôle a entité$")
	public void jattribue_la_liste_de_role_a_entite() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// for living doc purpose only
		assertThat(true, is(true));
	}

	@Given("^j'attribue la liste de rôle est distribué :$")
	public void jattribue_la_liste_de_role_est_distribue(DataTable arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		// for living doc purpose only
		assertThat(true, is(true));
	}

}
