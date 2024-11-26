package manipTableaux;

import java.util.Scanner;

public class TicTacToe {

    public static boolean estPris(char[] emplacement , int joueur , int indice){
        boolean placePrise = false;

        if(emplacement[indice] != ' '){
            placePrise = true;
        }

        return placePrise;
    }

    public static char[] joueur(char[] emplacement , int joueur){
        Scanner scanner = new Scanner(System.in);
        int indice;
        boolean placePrise;

        switch (joueur){
            case 1:
                System.out.print("Joueur 1 : X ; entrer l'emplacement : ");
                break;
            case 2:
                System.out.print("Joueur 2 : O ; entrer l'emplacement : ");
                break;
            default:
                System.out.print("Erreur de numéro de joueur : " + joueur);
                System.exit(0);
        }

        indice = scanner.nextInt() - 1; //soustraction pour obtenir un indice de tableau
        placePrise = estPris(emplacement, joueur, indice);

        //Vérif emplacement vide
        while (placePrise){ //true = place prise
            System.out.print("Joueur " + joueur + " emplacement déjà pris. Entrer un autre emplacement");
            indice = scanner.nextInt() - 1;
            placePrise=estPris(emplacement, joueur, indice);
        }

        switch (joueur){
            case 1:
                emplacement[indice] = 'X';
                break;
            case 2:
                emplacement[indice] = 'O';
                break;
            default:
                System.out.print("Erreur de numéro de joueur : " + joueur);
                System.exit(0);
        }

        return emplacement;
    }

    public static void afficheGrille(char[] emplacement){
        System.out.println("\t" + emplacement[0] + "\t|\t" +emplacement[1] +"\t|\t" + emplacement[2]);
        System.out.println("\t_\t+\t_\t+\t_");
        System.out.println("\t" + emplacement[3] + "\t|\t" +emplacement[4] +"\t|\t" + emplacement[5]);
        System.out.println("\t_\t+\t_\t+\t_");
        System.out.println("\t" + emplacement[6] + "\t|\t" +emplacement[7] +"\t|\t" + emplacement[8]);
    }
    public static void main(String[] args) {

        char[] emplacement = {' ',' ',' ',' ',' ',' ',' ',' ',' '};
        afficheGrille(emplacement);

        for(int i=0 ; i<9 ; i++){ //9 tours

            joueur(emplacement , 1);
            afficheGrille(emplacement);
            joueur(emplacement , 2);
            afficheGrille(emplacement);

            for (char place : emplacement){
                System.out.print(place);
            }
        }


    }
}
