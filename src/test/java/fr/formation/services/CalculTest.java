package fr.formation.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class CalculTest {

    private Calcul calcul;

    @BeforeEach // C'est la methode qui sera execute avant chaque test
    void setUp() throws Exception {
        calcul = new Calcul();
    }

    @AfterEach // C'est la methode qui sera execute aprèS chaque test
	void tearDown() throws Exception {
		calcul = null;
	}
    
    @DisplayName("Test de la méthode somme(...)")
    @RepeatedTest(3)
    void testSomme(TestInfo testInfo, RepetitionInfo repetitionInfo) {

        System.out.println("*** TEST DETAILS ***");
		System.out.println("*** Nom du test *** : " + testInfo.getDisplayName());
		System.out.println("*** Nom de la méthode *** : " + testInfo.getTestMethod().get().getName());

        System.out.println("*** REPETITION DETAILS ***");
		System.out.println("*** Répétition courante *** : " + repetitionInfo.getCurrentRepetition());
		System.out.println("*** Répétitions totales *** : " + repetitionInfo.getTotalRepetitions());
        
        assertTrue(calcul.somme(0, 0) == 0, "entier x null");
        assertFalse(calcul.somme(2, 3) == 6, "2 entiers positifs");
        assertNotNull(calcul.somme(2, -3), "2 entiers designe differents");
        assertEquals(-5, calcul.somme(-2, -3), "2 entiers négatifs");
    }

    @DisplayName("Test de la méthode division(...)")
	@Test
    void testDivision(TestInfo testInfo) {
        System.out.println("*** TEST DETAILS ***");
		System.out.println("*** Nom du test *** : " + testInfo.getDisplayName());
		System.out.println("*** Nom de la méthode *** : " + testInfo.getTestMethod().get().getName());
        
		assertEquals(2, calcul.division(-6, -3), "2 entiers negatifs");
		assertNotNull(calcul.division(-6, 3), "2 entiers de signe different");
        assertTrue(calcul.division(0, 3) == 0, "entier x nul");
    }

    @DisplayName("Test de la methode division(...) - Exception attendue")
	@Test
	public void testDivisionByZero(TestInfo testInfo) {
		
		System.out.println("*** TEST DETAILS ***");
		System.out.println("*** Nom du test *** : " + testInfo.getDisplayName());
		System.out.println("*** Nom de la méthode *** : " + testInfo.getTestMethod().get().getName());
		
        assertThrows(ArithmeticException.class, () -> calcul.division(2, 0));
	}

    @DisplayName("Test de la methode multiplication(...)")
	@Test
	public void testMultiplication(TestInfo testInfo) {
		
		System.out.println("*** TEST DETAILS ***");
		System.out.println("*** Nom du test *** : " + testInfo.getDisplayName());
		System.out.println("*** Nom du tag ***  : " + testInfo.getTags());
		System.out.println("*** Nom de la méthode *** : " + testInfo.getTestMethod().get().getName());
		
		assertFalse(calcul.multiplication(3, 4) == 7, "2 entiers positifs");
		assertEquals(0 ,calcul.multiplication(0, 5), "Error Multiplication");
		assertNotNull(calcul.multiplication(-6, 3), "Err 2 entiers");
		assertTrue(calcul.multiplication(2, 6) == 12, "Entier x non null");	
	}

    @DisplayName("Test de la methode soustraction(...)")
	@Test
	public void testSoustraction(TestInfo testInfo) {
		
		System.out.println("*** TEST DETAILS ***");
		System.out.println("*** Nom du test *** : " + testInfo.getDisplayName());
		System.out.println("*** Nom du tag ***  : " + testInfo.getTags());
		System.out.println("*** Nom de la méthode *** : " + testInfo.getTestMethod().get().getName());
			
		assertFalse(calcul.soustraction(2, 3) == 2, "2 entiers positifs");
		assertEquals(1, calcul.soustraction(-2, -3), "2 entiers negatifs");
		assertNotNull(calcul.soustraction(-2, 3), "2 entiers designe different");
		assertTrue(calcul.soustraction(0, 0) == 0, "entier x nul");
	}

}