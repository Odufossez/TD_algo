package Recherche_tableau;
import java.util.Scanner;

public class Recherche {
    static int recherche_seq(int[] tab, int id){
        for(int i=0 ; i<tab.length ; i++){
            if(tab[i] == id){
                return i;
            }
        }

        return -1;
    }

    static void afficher(String[] tab_prenoms , float[] notes , int pos){
        String message = "Prénom: " + tab_prenoms[pos] + " ,note : " + notes[pos];
        System.out.println(message);
    }
    public static void main(String[] args){
        int[] tab_ID = {2,4,7,10,11}; //identifiants des étudiants
        String[] tab_prenoms = {"P1","P2","P3","P4","P5"}; //Prénom des étudiants
        float[] tab_notes = {10.5f,15,3,16.25f};
        int id=0; //id étudiant
        

        System.out.println("Saisir ID d'un étudiant : ");


        Scanner scanner = new Scanner(System.in);
        id = scanner.nextInt();

        int index = recherche_seq(tab_ID, id);

        if (index > -1){
            afficher(tab_prenoms, tab_notes, index);
        }
        else{
            System.out.println("Etudiant " + id + " n'existe pas");
        }
    }
}
