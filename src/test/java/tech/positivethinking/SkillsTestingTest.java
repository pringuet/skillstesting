package tech.positivethinking;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SkillsTestingTest {

	private static SkillsTesting skillsTesting;
	private List<List<Integer>> listeResultante;
	private List<List<Integer>> listeAttendue;

	@Test(expected = IllegalArgumentException.class)
	/**
	 * La liste inexistante ou vide.
	 */
	public void testPartitionListesInvalides() {
		skillsTesting.partition(null, 3);
		skillsTesting.partition(new ArrayList<Integer>(), 3);
	}

	@Test(expected = IllegalArgumentException.class)
	/**
	 * La taille des partitions est inférieure ou égale à 0.
	 */
	public void testPartitionTaillesInvalides() {
		skillsTesting.partition(liste(1, 10), -3);
		skillsTesting.partition(liste(1, 10), 0);
	}

	@Test(expected = IllegalArgumentException.class)
	/**
	 * La taille de la liste est inférieure à la taille des partitions.
	 */
	public void testPartitionTaillesIncoherentes() {
		skillsTesting.partition(liste(1, 10), 12);
	}

	@Test
	/**
	 * La taille de la liste est �gale � la taille des partitions. 
	 */
	public void testPartition() {
		listeResultante = skillsTesting.partition(liste(1, 10), 10);
		listeAttendue.add(liste(1, 10));
		assertEquals(listeAttendue, listeResultante);
	}

	@Test
	/**
	 * Toutes les partitions ont une taille identique.
	 */
	public void testPartition2() {
		listeResultante = skillsTesting.partition(liste(1, 10), 5);
		listeAttendue.add(liste(1, 5));
		listeAttendue.add(liste(6, 10));
		assertEquals(listeAttendue, listeResultante);
	}

	@Test
	/**
	 * La taille de la derni�re partition est plus petite.
	 */
	public void testPartition3() {
		listeResultante = skillsTesting.partition(liste(1, 12), 5);
		listeAttendue.add(liste(1, 5));
		listeAttendue.add(liste(6, 10));
		listeAttendue.add(liste(11, 12));
		assertEquals(listeAttendue, listeResultante);
	}

	/**
	 * Fabrication d'une liste d'�l�ments croissants par incr�ment de 1.
	 * @param debut La valeur de d�but de la liste.
	 * @param fin La valeur de fin de la liste.
	 * @return La liste born�e : [debut, ... , fin]
	 */
	private List<Integer> liste(final int debut, final int fin) {
		List<Integer> liste = new ArrayList<Integer>();
		for (int i = debut; i <= fin; i++) {
			liste.add(i);
		}
		return liste;
	}

	@Before
	public void setUp() throws Exception {
		listeAttendue = new ArrayList<List<Integer>>();
	}

	@After
	public void tearDown() throws Exception {
		listeResultante = null;
		listeAttendue = null;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		skillsTesting = new SkillsTesting();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		skillsTesting = null;
	}
}
