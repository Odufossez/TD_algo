package manipTableaux; //seulement si besoin

public class rupture {

    public static void afficheTab(int[] tab){
        for(int i=0; i<tab.length; i++){
            System.out.print(tab[i]+" ");
        }
        System.out.println();
    }

    public static int[] ajoutElemt(int[] tab , int element){
        int[] tabElement = null;

        if (tab == null){
            tabElement = new int[1];
            tabElement[0] = element;
        }
        else{
            tabElement = new int[tab.length+1];
            for(int i=0; i<tab.length; i++){
                tabElement[i] = tab[i];
            }
            tabElement[tab.length] = element;
        }

        return tabElement;
    }

    public static int[] ruptureFct(int[] tab){
        int[] tabOut= null;
        tabOut = ajoutElemt(tabOut , 0);

        for (int i=0; i<tab.length-1; i++){
            if (tab[i+1] <= tab[i]){
                tabOut = ajoutElemt(tabOut , i+1);
            }
        }

        return tabOut;
    }

    public static void afficheTab2D(int[][] tab){
        for (int i=0; i<tab.length; i++){
            for (int j=0; j<tab[i].length; j++){
                System.out.print(tab[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] returnSeq(int[] tab , int[] ruptureTab){
        int[][] tabOut = new int[ruptureTab.length][];
        int tailleCol;
        for (int i=0; i<tabOut.length; i++){
            if(i < tabOut.length-1){
                tailleCol = ruptureTab[i+1] - ruptureTab[i];
                tabOut[i] = new int[tailleCol]; //ajoute une colonne sur la ligne i
            }
            else{
                tailleCol = tab.length - ruptureTab[i];
                tabOut[i] = new int[tailleCol];
            }
            for(int j=0; j<tailleCol; j++){
                tabOut[i][j] = tab[ruptureTab[i]+j];
            }
        }
        return tabOut;
    }

    public static void main(String[] args) {
        int[] tab = {1 ,2, 5, 7, 2, 6, 0, 5, 2, 4, 6, 7, 8, 9, 3, 4, 6, 1, 2, 7, 8, 9, 4, 2, 3, 1, 5, 9, 7, 1, 6, 6, 3};

        //afficheTab(tab);

        int[] tabRup = ruptureFct(tab);
        afficheTab(tabRup);

        int[][] tabSeq = returnSeq(tab , tabRup);

        afficheTab2D(tabSeq);

    }
}
