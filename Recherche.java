import java.util.Scanner;

public class Recherche {
    static int rechercheSequentielle(int[] tab, int id){
        for(int i = 0; i<tab.length;i++){
            if(tab[i] == id){
                return i;
            }
        }
        return -1; //La fonction s'arrète sur l'autre return i si il trouve. Donc pas de -1 au final
    }

    static int rechercheDicho(int[] tab, int id){
        int low = 0;
        int high = tab.length-1;

        while(high >= low){
            int milieu = (low+high)/2;
            if (id < tab[milieu]){
                high = milieu-1;
            } else if (id == tab[milieu]) {
                return milieu;
            }
            else{
                low = milieu+1;
            }
        }
        return (-low-1);
    }

    static int[] insererPosition(int[] tab, int index, int cle){ //création d'un nouveau tableau pcq on peut pas
        // modifier la taille d'un tableau
        int[] tab_n = new int[tab.length+1];
        
        for(int i = 0; i < tab_n.length ; i++){
            if (i < index){
                tab_n[i] = tab[i];
            }
            else if (i == index) {
                tab_n[i] = cle;
            }
            else {
                tab_n[i] = tab[i-1];
            }
        }
        return tab_n;
    }

    static void afficherTableau(String[] tabPrenoms, float[] notes , int pos){
        String message = "Prénom :" + tabPrenoms[pos] + " note :" + notes[pos];
        System.out.println(message);
    }

    public static void main(String[] args){
        int[] tabId = {2,4,7,10,11,45,50,59,60,66,69,70,79};
        String[] tabPrenoms = {"p1","p2","p3","p4","p5","p6","p7","p8","p9","p10","p11","p12","p13",};
        float[] tabNotes = {7.5f,12.f,14.5f,0,15,7.5f,12.5f,13.5f,0,15,13.5f,0,15};
        int id;

        System.out.println("Saisir un identifiant étudiant:");
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextInt();
        int index = rechercheDicho(tabId, id);

        if(index > -1){
           afficherTableau(tabPrenoms, tabNotes, index);
        }
        else{
            System.out.println("Etudiant introuvable !!!");
            int index_n = - (index + 1);
            int[] tab_id_n = insererPosition(tabId , index_n , id);

            System.out.println("Création d'un nouvel étudiant");

            for (int element : tab_id_n) {
                System.out.print(element + " ");
            }
        }
    }
}