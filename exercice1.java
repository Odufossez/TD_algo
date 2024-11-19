package Melange_tableau;

import java.util.Scanner;

public class exercice1 {
    public static void main(String[] args){
        int[] tab = {3, 2 , 1 , 4};
        int tour = 0;

        for(int element : tab){
            System.out.print(element + " ");
        }
        System.out.println("\n");
        tour++;

        while (!tableauRange(tab)){
            System.out.println("Entrez un chiffre entre 1 et 4");
            Scanner scanner = new Scanner(System.in);
            int cle = scanner.nextInt();

            inversion(tab , cle);

            for(int element : tab){
                System.out.print(element + " ");
            }
        }

        System.out.println("Vous avez gagné en " + tour + " tours !");

    }

    static boolean tableauRange(int[] tab){
        boolean result = false;

        for(int i=0 ; i<tab.length-1 ; i++){

            if(tab[i] < tab[i+1]){
                result = true;
            }
            else{
                result = false;
            }
        }

        return result;
    }

    static void inversion(int[] tab, int cle){
        int temp; //valeur temporaire pour l'inversion
        int j = cle -1;

        for(int i = 0; i < cle/2; i++){
            temp = tab[i];
            tab[i] = tab[j];
            tab[j] = temp;

            j--;
        }
    }
}
