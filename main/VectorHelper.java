
package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class VectorHelper {
	static Scanner input = new Scanner(System.in);
/**
     * Cette fonction permet la lecure d'un entier entr� au clavier
     *
     * @param prompt message diffus� qui permet � l'utilisateur de comprendre ce qu'il doit faire
     * @return entier qui represente le nombre lu � partir du clavier
     */
    public static int getInt(String prompt) {
        System.out.print(prompt + " ");
        int entier = input.nextInt();
        input.nextLine(); // Se d�barrasser de cette ligne
        return entier;
    }

    /**
     * Cette fonction permet le remplissage d'un tableau de n elements � partir du clavier
     *
     * @param n la taille du tableau � remplir
     * @return tab[] le tableau remplie � parti rdu clavier
     */
    public static int [ ]  RemplirTab(int n) {
        int i;
        int[ ] tab = new int[n];
        for (i = 0; i < tab.length; i++) {
            tab[i] = getInt("       Entr�e n�" + (i + 1));
        }
        return tab;
    }

    /**
     * cette fonction affiche le contenu d'un tableau donn� en entr�e le contenu est affich� sur une meme ligne 
     * tous les elements du tableau sont separ� l'un de l'autre par un |
     *
     * @param tab le tableau � afficher
     */
    public static void AfficherTab(int tab[]) {
        System.out.print("| ");
        for (int i = 0; i < tab.length; ++i) {
            System.out.print(tab[i] + " | ");
        }
        System.out.println("");
        System.out.println("");
    }

    /**
     * Cette fonction donne le tableau inverse d'un tableau donn� en entr�e par
     * exemple si on prend le tableau |5|19|7|32|1| le resultat de son inversion
     * est |1|32|7|19|5|
     *
     * @param tab le tableau � inverser
     * @return sab[] le tableau resulatant de l'operation d'inversion
     */
    public static int[] InverserTab(int tab[]) {
        int n = tab.length;
        int[] sab = new int[n];
        for (int i = 0; i < tab.length; i++) {
            sab[i] = tab[n - 1];
            n--;
        }
        return sab;
    }

    /**
     * Cette fonction effectue un tri � bulle � un tableau donn� en entr�e Son
     * principe : L'algorithme parcourt le tableau et compare les �l�ments
     * cons�cutifs. Lorsque deux �l�ments cons�cutifs ne sont pas dans l'ordre,
     * ils sont �chang�s. Et ansi de suite jusqu'� ce que tous les elements du
     * tableau sont dans l'ordre.
     *
     * @param tab le tableau � trier
     * @return tab le tableau tri�
     */
    public static int[] TriBulles(int tab[]) {
        boolean tab_in_order = false;
        int taille, temp;
        taille = tab.length;
        while (!tab_in_order) {
            tab_in_order = true;
            for (int i = 0; i < taille - 1; i++) {
                if (tab[i] > tab[i + 1]) {
                    temp = tab[i];
                    tab[i] = tab[i + 1];
                    tab[i + 1] = temp;
                    tab_in_order = false;
                }
            }
            taille--;
        }
        return tab;
    }

    /**
     * Cette fonction calcule la somme de deux tableaux de m�me taille.
     * Exemple : soient T[1,5,7,19,6,14] et S[7,29,35,13,91,2] le resultat est R[8,34,42,32,97,16]
     *Si les 2 tableaux ne sont pas de m�me taille une exception est gener�e et un message d'erreur est affich�.
     * 
     * @param T le premier tableau qui sera sommer
     * @param S le deuxieme tableau pour effectuer l'operation de la somme
     * @return R[] le taleau resulatant de la somme des deux tableaux T et S
     * @throws tp1.Tai_Dif_Exception
     */
    public static int[] SomVector(int T[], int S[]) throws Tai_Dif_Exception  {
        int n = T.length, m = S.length;
        int[] R = new int[n];
        
        try {
            if (n == m) {
                for (int i = 0; i < n; i++) {
                    R[i] = T[i] + S[i];
                }
            }else
                throw new Tai_Dif_Exception();
        }catch (Tai_Dif_Exception e){
        
        }

        return R;
    }

    /**
     * Cette fonction calcule en m�me temps le min et le max d'un tableau donn� en entr�e
     * Exemple : soit T[5,17,3,35] le min de ce tableau est 3 et le max est 35
     * 
     * @param tab le tableau � traiter
     */
    public static void MaxMin(int tab[]) {
        int min, max, n = tab.length;
        int[] S = new int[n];
        S = TriBulles(tab);
        min = S[0];
        System.out.println("Le minimum de ce tableau est : " + min);
        max = S[n - 1];
        System.out.println("La maximum de ce tableau est : " + max);
    }


     
    /**
     * Cette fonction represente un menu d'excution Ce menu rend notre execution
     * bien organis�e et plus lisible
     *
     * @throws java.io.IOException
     * @throws tp1.Tai_Dif_Exception
     */
    public static void gestion_menu() throws IOException, Tai_Dif_Exception {
        int cas, n, m,s;
        int[] tab;
        int[] sab;
        BufferedReader syl1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1-Tri des �l�ments d�un vecteur");
        System.out.println("2-La somme de deux vecteurs");
        System.out.println("3-Inverser les �l�ments d'un vecteur");
        System.out.println("4-Max, Min d'un vecteur");
        System.out.println("5-La Multiplication du vecteur par un nombre ");
        System.out.println("6-Quitter");
        System.out.println("");
        System.out.println("");
        System.out.print("        Veuillez entrer votre choix :      ");
        cas = Integer.parseInt(syl1.readLine());
        switch (cas) {
            case 1: {
                System.out.println("*----------------------*");
                System.out.println("    Tri d'un vecteur");
                System.out.println("*----------------------*");
                System.out.println();
                n = getInt("Donnez le nombre d'�l�ments de vecteur :");
                tab = new int[n];
                tab = RemplirTab(n);
                AfficherTab(TriBulles(tab));
                gestion_menu();
            }
            break;
            case 2: {
                System.out.println("*------------------------*");
                System.out.println("La somme des deux vecteurs");
                System.out.println("*------------------------*");
                n = getInt("Donnez le nombre d'�l�ments du premier vecteur :");
                tab = new int[n];
                tab = RemplirTab(n);
                m = getInt("Donnez le nombre d'�l�ments de deuxiemme vecteur :");
                sab = new int[m];
                sab = RemplirTab(m);
                System.out.println("Le vecteur resultant est : ");
                tab = SomVector(tab, sab);
                if(m==n) AfficherTab(tab);
                gestion_menu();
            }
            break;
            case 3: {
                System.out.println("*---------------------------------*");
                System.out.println("Inverser les elements d'un vecteur");
                System.out.println("*---------------------------------*");
                System.out.println("");
                System.out.println("");
                n = getInt("Donnez le nombre d'�l�ments du vecteur :");
                tab = new int[n];
                tab = RemplirTab(n);
                AfficherTab(InverserTab(tab));
                gestion_menu();
            }
            break;
            case 4: {
                System.out.println("*---------------------------------*");
                System.out.println("Le Min et le Max d'un vecteur");
                System.out.println("*---------------------------------*");
                System.out.println("");
                System.out.println("");
                n = getInt("Donnez le nombre d'entr�es du vecteur :");
                tab = new int[n];
                tab = RemplirTab(n);
                System.out.println("*--------------------------------------*");
                MaxMin(tab);
                System.out.println("*--------------------------------------*");
                gestion_menu();
            }
            break;
            case 5: {
                System.out.println("*------------------------*");
                System.out.println("La Multiplication du vecteur par un nombre ");
                System.out.println("*------------------------*");
                n = getInt("Donnez le nombre d'entr�es du vecteur :");
                tab = new int[n];
                tab = RemplirTab(n);
                s = getInt("Donner Le nombre :");           
                System.out.println("Le vecteur resultant est : ");
                tab = MulVector(tab,s);
                AfficherTab(tab);
                gestion_menu();
            }
            break;
            case 6: {
                System.out.println("Merci d'avoir utiliser mon programme !");
            }
        }
    }
}