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

    public static int joueur(char[] emplacement , int joueur){
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
        return indice;
    }
    public static void afficheGrille(char[] emplacement){
        System.out.println("\t" + emplacement[0] + "\t|\t" +emplacement[1] +"\t|\t" + emplacement[2]);
        System.out.println("\t_\t+\t_\t+\t_");
        System.out.println("\t" + emplacement[3] + "\t|\t" +emplacement[4] +"\t|\t" + emplacement[5]);
        System.out.println("\t_\t+\t_\t+\t_");
        System.out.println("\t" + emplacement[6] + "\t|\t" +emplacement[7] +"\t|\t" + emplacement[8]);
    }

    public static boolean verifGagne(char[] emplacement , int joueur , int lastIndice){

        switch (lastIndice){
            case 0 :
                //Vérif ligne puis colonne puis diag
                if ((emplacement[0] == emplacement[1] && emplacement[0] == emplacement[2]
                    && emplacement[1] == emplacement[2]) ||
                    (emplacement[0] == emplacement[3] && emplacement[0] == emplacement[6]
                    && emplacement[3] == emplacement[6]) ||
                    (emplacement[0] == emplacement[4] && emplacement[0] == emplacement[8]
                    && emplacement[4] == emplacement[8])){
                    System.out.print("Félicitations joueur " + joueur + " a gagné !");
                    return true;
                }
                else {
                    return false;
                }


            case 1:
                //Vérif ligne puis colonne
                if ((emplacement[1] == emplacement[0] && emplacement[1] == emplacement[2]
                    && emplacement[0] == emplacement[2]) ||
                    (emplacement[1] == emplacement[4] && emplacement[1] == emplacement[7]
                    && emplacement[4] == emplacement[7])){
                    System.out.print("Félicitations joueur " + joueur + " a gagné !");
                    return true;

                }
                else {
                    return false;
                }

            case 2:
                //Vérif ligne puis colonne puis diag
                if ((emplacement[2] == emplacement[1] && emplacement[0] == emplacement[2]
                    && emplacement[1] == emplacement[0]) ||
                    (emplacement[2] == emplacement[5] && emplacement[2] == emplacement[8]
                    && emplacement[5] == emplacement[8]) ||
                    (emplacement[2] == emplacement[4] && emplacement[2] == emplacement[6]
                    && emplacement[4] == emplacement[6])){
                    System.out.print("Félicitations joueur " + joueur + " a gagné !");
                    return true;
                }
                else {
                    return false;
                }


            case 3:
                //Vérif ligne puis colonne
                if ((emplacement[3] == emplacement[4] && emplacement[3] == emplacement[5]
                    && emplacement[4] == emplacement[5]) ||
                    (emplacement[3] == emplacement[0] && emplacement[3] == emplacement[6]
                    && emplacement[0] == emplacement[6])){
                    System.out.print("Félicitations joueur " + joueur + " a gagné !");
                    return true;

                }
                else {
                    return false;
                }

            case 4:
                if ((emplacement[4] == emplacement[3] && emplacement[4] == emplacement[5] &&
                    emplacement[3] == emplacement[5] ||
                    emplacement[4] == emplacement[1] && emplacement[4] == emplacement[7] &&
                    emplacement[1] == emplacement[7] ||
                    emplacement[4] == emplacement[6] && emplacement[4] == emplacement[2] &&
                    emplacement[2] == emplacement[6] ||
                    emplacement[4] == emplacement[0] && emplacement[4] == emplacement[8] &&
                    emplacement[8] == emplacement[0])){
                    System.out.print("Félicitations joueur " + joueur + " a gagné !");
                    return true;

                }
                else {
                    return false;
                }

            case 5:
                //Vérif ligne puis colonne
                if ((emplacement[5] == emplacement[4] && emplacement[3] == emplacement[5]
                && emplacement[4] == emplacement[5]) ||
                (emplacement[5] == emplacement[2] && emplacement[5] == emplacement[8]
                && emplacement[2] == emplacement[8])){
                    System.out.print("Félicitations joueur " + joueur + " a gagné !");
                    return true;

                }
                else {
                    return false;
                }

            case 6:
                //Vérif ligne puis colonne puis diag
                if ((emplacement[6] == emplacement[7] && emplacement[6] == emplacement[8]
                && emplacement[7] == emplacement[8]) ||
                (emplacement[6] == emplacement[3] && emplacement[6] == emplacement[0]
                && emplacement[3] == emplacement[0]) ||
                (emplacement[6] == emplacement[4] && emplacement[2] == emplacement[6]
                && emplacement[4] == emplacement[2])){
                    System.out.print("Félicitations joueur " + joueur + " a gagné !");
                    return true;
                }
                else {
                    return false;
                }


            case 7:
                //Vérif ligne puis colonne
                if ((emplacement[7] == emplacement[6] && emplacement[7] == emplacement[8]
                && emplacement[8] == emplacement[6]) ||
                (emplacement[7] == emplacement[4] && emplacement[7] == emplacement[1]
                && emplacement[4] == emplacement[1])){
                    System.out.print("Félicitations joueur " + joueur + " a gagné !");
                    return true;

                }
                else {
                    return false;
                }

            case 8:
                //Vérif ligne puis colonne puis diag
                if ((emplacement[6] == emplacement[7] && emplacement[6] == emplacement[8]
                && emplacement[7] == emplacement[8]) ||
                (emplacement[8] == emplacement[5] && emplacement[8] == emplacement[2]
                && emplacement[5] == emplacement[2]) ||
                (emplacement[8] == emplacement[4] && emplacement[8] == emplacement[0]
                && emplacement[4] == emplacement[0])){
                    System.out.print("Félicitations joueur " + joueur + " a gagné !");
                    return true;
                }
                else {
                    return false;
                }


            default:
                System.out.println("Erreur de gagne : " + joueur);
                System.exit(0);
        }
        return false;
    }

    public static void main(String[] args) {

        char[] emplacement = {' ',' ',' ',' ',' ',' ',' ',' ',' '};
        afficheGrille(emplacement);

        for(int i=0 ; i<4 ; i++){ //9 tours
            int lastIndice;
            boolean partieTerminee;

            lastIndice = joueur(emplacement , 1);
            afficheGrille(emplacement);
            partieTerminee = verifGagne(emplacement, 1 , lastIndice);

            if (partieTerminee){
                System.out.println("Partie terminee");
                System.exit(0);
            }

            lastIndice = joueur(emplacement , 2);
            afficheGrille(emplacement);
            partieTerminee = verifGagne(emplacement, 2 , lastIndice);

            if (partieTerminee){
                System.out.println("Partie terminee");
                System.exit(0);
            }
        }

        System.out.println("Match Nul");
        System.exit(0);
    }
}
