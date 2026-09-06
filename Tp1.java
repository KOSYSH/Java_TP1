import java.util.Scanner;

public class Tp1 {

    public static void main(String[] args) {
        Scanner it = new Scanner(System.in);
        int choix;

        do {
            System.out.println("----- Menu -----");
            System.out.println("1. Trouver la parite d'un nombre");
            System.out.println("2. Trouver le nombre le plus grand");
            System.out.println("3. Trouver le nombre le plus petit");
            System.out.println("4. Trouver le reste d'une division");
            System.out.println("0. Quitter");

            choix = lireEntier(it, "Choisissez une option : ");

            while (choix < 0 || choix > 4) {
                System.out.println("Option invalide, choisissez entre 0 et 4");
                choix = lireEntier(it, "Choisissez une option : ");
            }

            switch (choix) {
                case 1:
                    int nbr = lireEntier(it, "Entrez un nombre : ");
                    System.out.println(pair(nbr));
                    break;

                case 2:
                    int n = lireEntier(it, "Entrez le nombre d'elements : ");

                    while (n <= 0) {
                        System.out.println("Le nombre d'elements doit etre plus grand que 0");
                        n = lireEntier(it, "Entrez le nombre d'elements : ");
                    }

                    int[] nbrmx = new int[n];

                    for (int i = 0; i < n; i++) {
                        nbrmx[i] = lireEntier(it, "Entrez l'element " + (i + 1) + " : ");
                    }

                    System.out.println("Le nombre le plus grand est : " + max(nbrmx));
                    break;

                case 3:
                    int m = lireEntier(it, "Entrez le nombre d'elements : ");

                    while (m <= 0) {
                        System.out.println("Le nombre d'elements doit etre plus grand que 0");
                        m = lireEntier(it, "Entrez le nombre d'elements : ");
                    }

                    int[] nbrmn = new int[m];

                    for (int i = 0; i < m; i++) {
                        nbrmn[i] = lireEntier(it, "Entrez l'element " + (i + 1) + " : ");
                    }

                    System.out.println("Le nombre le plus petit est : " + min(nbrmn));
                    break;

                case 4:
                    int nbr1 = lireEntier(it, "Entrez le premier nombre : ");
                    int nbr2 = lireEntier(it, "Entrez le deuxieme nombre : ");
                    System.out.println(rest(nbr1, nbr2));
                    break;

                case 0:
                    System.out.println("Bye");
                    break;
            }

        } while (choix != 0);

    }

    public static int lireEntier(Scanner sc, String message) {
        System.out.print(message);

        while (!sc.hasNextInt()) {
            System.out.println("Erreur : veuillez entrer un nombre entier");
            sc.next();
            System.out.print(message);
        }

        return sc.nextInt();
    }

    public static String pair(int nbr) {
        if (nbr % 2 == 0) {
            return "Le nombre " + nbr + " est pair";
        } else {
            return "Le nombre " + nbr + " est impair";
        }
    }

    public static int min(int... nbrmn) {
        int min = nbrmn[0];

        for (int i : nbrmn) {
            if (i < min) {
                min = i;
            }
        }

        return min;
    }

    public static int max(int... nbrmx) {
        int max = nbrmx[0];

        for (int i : nbrmx) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    public static String rest(int nbr1, int nbr2) {
        if (nbr2 == 0) {
            return "Erreur : division par zero";
        }

        return "Le reste de la division de " + nbr1 + " par " + nbr2
                + " est : " + (nbr1 % nbr2);
    }
}