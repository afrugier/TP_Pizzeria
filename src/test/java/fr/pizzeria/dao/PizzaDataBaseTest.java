package fr.pizzeria.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDataBaseTest {
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	static Connection connection;
	static Statement statement;
	PizzaDataBase pizzaDataBase = new PizzaDataBase();;

	static List<Pizza> listePizza;
	static PreparedStatement insertPizza;

	@BeforeClass
	public static void setUp() throws Exception {

		listePizza = new ArrayList<>();

		listePizza.add(new Pizza("FDM", "Fruit de mer", 12.50, CategoriePizza.POISSON));
		listePizza.add(new Pizza("LEG", "La 4 légumes", 14.00, CategoriePizza.VEGETALIENNE));
		listePizza.add(new Pizza("REI", "La reine", 11.50, CategoriePizza.VIANDE));
		listePizza.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.FROMAGES));
		listePizza.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		listePizza.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		listePizza.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.VIANDE));
		listePizza.add(new Pizza("CHA", "Champetre", 14.00, CategoriePizza.VEGETARIENNE));
	}

	@Test
	public void testFindAllPizzasBDD() throws Exception {
		pizzaDataBase.initPizza();
		assertThat(listePizza).containsAll(pizzaDataBase.findAllPizzas());
	}

	@Test
	public void testSaveNewPizza() throws Exception {

		pizzaDataBase.initPizza();
		Pizza pizza = new Pizza("CAL", "Calzone", 12.50, CategoriePizza.VIANDE);
		pizzaDataBase.saveNewPizza(pizza);
		assertThat(pizzaDataBase.findAllPizzas()).contains(pizza);

	}

	@Test
	public void testUpdatePizza() throws Exception {
		pizzaDataBase.initPizza();
		Pizza pizza = new Pizza("CAL", "Calzone", 12.50, CategoriePizza.VIANDE);
		String codePizza = "LEG";
		pizzaDataBase.updatePizza(codePizza, pizza);
		assertThat(pizzaDataBase.findAllPizzas()).contains(pizza);
	}

	@Test
	public void testDeletePizza() throws Exception {
		pizzaDataBase.initPizza();
		Pizza pizza = new Pizza("FDM", "Fruit de mer", 12.50, CategoriePizza.POISSON);
		String codePizza = "FDM";
		pizzaDataBase.deletePizza(codePizza);
		assertThat(pizzaDataBase.findAllPizzas()).doesNotContain(pizza);
	}
}
