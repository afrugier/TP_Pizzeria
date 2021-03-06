package fr.pizzeria.ihm.menu.option;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IClientDao;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.StockageException;

public class SortirOptionMenu implements OptionMenu {

	private static final Logger LOG = LoggerFactory.getLogger(SupprimerPizzaOptionMenu.class);
	@Override
	public String getLibelle() {
		return "sortir";
	}

	@Override
	public String getTitle() {
		return null;
	}

	/**
	 * Affiche simplement un message de courtoisie indiquant que l'on quitte le
	 * menu.
	 */
	@Override
	public boolean execute(IPizzaDao dao) {

		LOG.info("Aurevoir :-(");

		return true;
	}

	@Override
	public boolean execute(IClientDao dao) throws StockageException {
		// pas ici
		return false;
	}

}
