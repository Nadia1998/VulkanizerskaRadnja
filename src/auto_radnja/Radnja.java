package auto_radnja;

import java.util.LinkedList;

import auto_radnja.gume.AutoGuma;
/**
 * Interfejs koji implementira radnju
 * 
 * @author Nadia
 *
 */
public interface Radnja {
	/**
	 * Dodaje novu gumu u radnju.
	 * 
	 * @param a guma koja se dodaje kao instanca klase AutoGuma
	 * 
	 * @throws java.lang.NullPointerException ako je uneta guma null.
	 * 
	 * @throws java.lang.RuntimeException ako u listi guma vec postoji ova guma.
	 * 
	 */
	void dodajGumu(AutoGuma a);
    /**
     * Pronalazi gumu u listi guma.
     * 
     * @param markaModel marka i model gume kao String koja se pronalazi u listi guma.
     * 
     * @return vraca gumu koju je pronasla metoda kao instancu klase AutoGuma.
     * 
     */
	LinkedList<AutoGuma> pronadjiGumu(String markaModel);
}
