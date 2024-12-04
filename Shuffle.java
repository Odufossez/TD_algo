package manipTableaux;
import java.util.Random;

public class Shuffle {

    static void initLoterie(int[] tab, int n){
        for(int i=0; i<n; i++){
            tab[i] = i + 1; //tableau de 1 à 42
        }
    }

    static void afficheTableau(int[] tab, int n){
        for(int i=0; i<n; i++){
            System.out.print(tab[i]+ " ");
        }
        System.out.println();
    }

    static int[] shuffle(int[] tab, int n){
        int[] tab_aux = new int[n];
        int indice_tab_aux = 0;
        

        while (tab.length != 0) { //tant que le tableau tab n'est pas vide (possible mettre aussi " indice_tab_aux < n")
            int num = new Random().nextInt(tab.length);    
            tab_aux[indice_tab_aux] = tab[num];
            tab = supprimerElement(tab, num, tab.length);
            indice_tab_aux++;
        }
        return tab_aux;
    }

    static void shuffle_yates(int[] tab, int n){
        //Variables
        int temp;
        
        for(int i=n-1; i>0 ; i--){
            //nextInt exclue la valeur à droite
            int j = new Random().nextInt(i+1);
            temp = tab[j];
            tab[j] = tab[i];
            tab[i] = temp;
        }
    }

    static int[] supprimerElement(int[] tab, int pos, int n){

        
        if(pos < 0 || pos >= n || tab == null){

            return tab;
        }

        int[] tab_aux = new int[n-1];
        
        for(int i = 0, k = 0 ; i<n ; i++){
            if(i == pos){
                continue;
            }
            tab_aux[k++] = tab[i]; //attribution de la valeur de tab[i] dans tab[k] PUIS j'augmente l'indice k

        }


        return tab_aux;

    }
    
    public static void main(String[] args) {
        int n = 7; //nombre de valeur dans le tableau
        int[] loterie = new int[n];
        
        initLoterie(loterie,n);
        afficheTableau(loterie,n);

        int[] tab_suffle = shuffle(loterie, n);
        afficheTableau(tab_suffle, n);

        loterie = new int[n];        
        initLoterie(loterie,n);
        shuffle_yates(loterie, n);
        afficheTableau(loterie, n);
    }

}
