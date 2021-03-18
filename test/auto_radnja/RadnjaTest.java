package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja r;

	@Test
	final void testDodajGumu() {
		AutoGuma g = new AutoGuma();
		g.setMarkaModel("Tigar");
		g.setPrecnik(20);
		g.setSirina(200);
		g.setVisina(70);

		r.dodajGumu(g);

		assertEquals(1, r.pronadjiGumu(g.getMarkaModel()).size());

	}

	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, () -> r.dodajGumu(null));
	}

	@Test
	void testDodajGumuDuplikat() {
		AutoGuma g = new AutoGuma();
		g.setMarkaModel("Pirelli");
		g.setPrecnik(19);
		g.setSirina(213);
		g.setVisina(79);

		r.dodajGumu(g);

		AutoGuma g1 = new AutoGuma();
		g1.setMarkaModel("Pirelli");
		g1.setPrecnik(19);
		g1.setSirina(213);
		g1.setVisina(79);

		assertThrows(java.lang.RuntimeException.class, () -> r.dodajGumu(g1));

	}

	@Test
	final void testPronadjiGumu() {
		AutoGuma g = new AutoGuma();
		g.setMarkaModel("Pirelli");
		g.setPrecnik(22);
		g.setSirina(210);
		g.setVisina(76);

		r.dodajGumu(g);

		List<AutoGuma> rezultat = r.pronadjiGumu("Pirelli");
		assertEquals(1, rezultat.size());
		assertTrue(rezultat.contains(g));

	}

	@Test
	void testPronadjiGumuNull() {
		assertEquals(null, r.pronadjiGumu(null));
	}

	@Test
	void testPronadjiGumuKojaNijeUListi() {
		AutoGuma guma = new AutoGuma();

		guma.setMarkaModel("Cordiant");
		guma.setPrecnik(15);
		guma.setSirina(220);
		guma.setVisina(50);

		AutoGuma guma1 = new AutoGuma();

		guma1.setMarkaModel("Pirelli");
		guma1.setPrecnik(22);
		guma1.setSirina(210);
		guma1.setVisina(76);

		r.dodajGumu(guma1);
		List<AutoGuma> rezultat = r.pronadjiGumu("Cordiant");
		assertEquals(0, rezultat.size());
		assertFalse(rezultat.contains(guma));

	}

	@Test
	void pronadjiViseGumaIstihMarkiIModelaRazlicitihDimenzija() {
		AutoGuma guma = new AutoGuma();

		guma.setMarkaModel("Cordiant");
		guma.setPrecnik(20);
		guma.setSirina(225);
		guma.setVisina(55);

		AutoGuma guma1 = new AutoGuma();

		guma1.setMarkaModel("Cordiant");
		guma1.setPrecnik(22);
		guma1.setSirina(210);
		guma1.setVisina(76);

		AutoGuma guma2 = new AutoGuma();

		guma2.setMarkaModel("Cordiant");
		guma2.setPrecnik(18);
		guma2.setSirina(300);
		guma2.setVisina(90);

		r.dodajGumu(guma);
		r.dodajGumu(guma1);
		r.dodajGumu(guma2);

		List<AutoGuma> rezultat = r.pronadjiGumu("Cordiant");

		assertEquals(3, rezultat.size());
		assertTrue(rezultat.contains(guma));
		assertTrue(rezultat.contains(guma1));
		assertTrue(rezultat.contains(guma2));
	}
}
