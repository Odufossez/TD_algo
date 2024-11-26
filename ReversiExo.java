package manipTableaux;
import java.util.Scanner;

public class ReversiExo {
    public static int nbrAlea(int min , int max){
        int intervalle = (max-min);
        return (int) (Math.random()*intervalle) + min;
    }

    public static void echanger(int[] tab , int i , int j){
        int tmp = tab[i];
        tab[i] = tab[j];
        tab[j] = tmp;
    }

    public static void melangeTab(int[] tab , int N){
       for (int i = 0; i < N-1; i++){
           int j = nbrAlea(i,N); // [i,N[
           echanger(tab, i , j);
       }
    }

    public static int[] initTab(int N){
        int[] tab = new int[N];
        for (int i = 0; i < N; i++) {
            tab[i] = i+1;
        }

        //mélange
        melangeTab(tab,N);

        return tab;
    }

    public static void inverse(int[] tab, int index , int pas){
        for(int i = index - pas , j=0 ; i < index - Math.ceil(pas/2) ; i++ , j++){ //prise de valeur la + grande sur la div
            echanger(tab , i , index-j-1);
        }
    }

    static void afficherTab(int[] tab){
        for(int i :tab){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static boolean estTrie(int[] tab){
        for (int i = 0; i < tab.length-1; i++) {
            if (tab[i] > tab[i+1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 9;
        int i = 0;
        int p = 0;
        int numTours = 0;
        int[] tab = initTab(N);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            afficherTab(tab);

            System.out.println("Veuillez entrer le nombre index pour " + "inverser de 2 à " + N +
                    ". Entrer 99 pour quitter.");

            i = scanner.nextInt();

            if (i == 99){
                break;
            }
            System.out.println("Veuillez entrer le nombre de pas entre " + "2 et " + i + ". Entrer 99 pour quitter.");
            p = scanner.nextInt();

            if(p == 99){
                break;
            }

            if(i<2 || i > N){
                System.out.println("Entrée invalide !");
            }
            else if(p < 2 || p > i ){
                System.out.println("Entrée invalide !");
            }
            else {
                numTours++;
                inverse(tab, i, p);
                if(estTrie(tab)){
                    System.out.println("GG, en :" + numTours);
                    break;
                }

            }
        }
    }
}
