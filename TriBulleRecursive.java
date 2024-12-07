public class TriBulleRecursive{   
    
    public static void main(String[] args) {
        int[] tab = {81,30,53,73,11};
        System.out.println("Tab de départ");
        for(int elem:tab) System.out.print(elem + " ");
        System.out.println("\nTab de sortie :");
        triBulleRec(tab,tab.length);
        for(int elem : tab) System.out.print(elem + " ");
        tab[(int) (Math.random() * tab.length)] = (int)(Math.random() * 100);
        System.out.println("\nTab Random :");
    } 
    

    /**
     * Renvoie un tableau trié avec le tri à bulles de façon récursive
     * @param tab un tableau de type int[]
     * @param n longeur du tableau
     */
    public static void triBulleRec(int[] tab, int n){
        if(n == 1) return;
        for (int i = 0; i < n-1; i++) {
            if(tab[i] > tab[i + 1]){
                int temp = tab[i];
                tab[i] = tab[i + 1];
                tab[i + 1] = temp;
            }
        }
        triBulleRec(tab, n-1);
    }

}
