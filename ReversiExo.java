package Melange_tableau;

import java.util.Random;

public class ReversiExo {
    public static int nbrAlea(int min , int max){
        int intervalle = (max-min);
        return (int) (Math.random()*intervalle) + min;
    }

    

    public static void melangeTab(int[] tab , int N){
       for (int i = 0; i < N-1; i++){
           int j = nbrAlea(i,N); // [i,N[

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

    public static void main(String[] args) {
        int N = 9;
        int[] tab = initTab(N);
    }
}
