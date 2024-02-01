package fr.formation;

import fr.formation.services.Calcul;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Calcul calcul = new Calcul();

        int res = calcul.somme(2, 3);

        System.out.println("Resultat: " + res);
    }

        
}
