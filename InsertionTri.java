package manipTableaux;

public class InsertionTri {

    public static int rechercheDichotomique(int[] tab , int cle , int low , int high){
        while (high >= low){
            int milieu = (low + high) / 2;
            if(cle < tab[milieu]){
                high = milieu - 1;
            }else if(cle == tab[milieu]){
                return milieu + 1;
            }else{
                low = milieu + 1;
            }
        }
        return low;
    }

    public static void triInsertionDichotomique(int[] tab){
        for (int i=1 ; i<tab.length ; i++){
            int cle = tab[i];
            int j = i-1;
            int position = rechercheDichotomique(tab , cle, 0 , j);
            while(j >= position){
                tab[j+1] = tab[j];
                j--;
            }
            tab[j+1] = cle;
        }
        afficheTab(tab);
    }

    public static void main(String[] args) {
        int[] tab = { 5,7,2,9,12,90,45,3,23,74};
        afficheTab(tab);
        //triInsertionTab(tab);
        triInsertionDichotomique(tab);
    }

    public static void afficheTab(int[] tab){
        for(int elem : tab) System.out.print(elem + " ");
        System.out.println();
    }

    public static void triInsertionTab(int[] tab){
        for(int i = 1; i < tab.length; i++){
            int cle = tab[i];
            int j = i-1;
            while(j >= 0 && tab[j] > cle){
                tab[j+1] = tab[j];
                j--;
            }
            tab[j+1] = cle;

        }
        afficheTab(tab);
    }
}
