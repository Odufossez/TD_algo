public class TriSelection{
    public static void main(String[] args){
        int[] tabRand = new int[20];
        for(int i = 0 ; i < tabRand.length ; i++) tabRand[i] = (int)(Math.random() * 100); // Synthaxe compliqué juste pour un tabl° avec des val°s random
        System.out.println("Tableau de départ : ");
        for(int elem : tabRand) System.out.print(elem + " ");
        tri_selection(tabRand);
        System.out.println("\nTableau de sortie : ");
        for(int elem : tabRand) System.out.print(elem + " " );

    }

    /**
     * Renvoie le tableau passé en argument ordonné dans l'ordre croissant
     * @param tab un tableau de type int[]
     */
    public static void tri_selection(int[] tab){
        int n = tab.length;
        for(int i = 0 ; i < n-1 ; i++){
            int min = tab[i];
            int minIndex = i;
            for(int j = i+1 ; j < n ; j++){
                if(tab[j] < min){
                    min = tab[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                tab[minIndex] =  tab[i];
                tab[i] = min;
            }
        }
    }
}