package Homework02;

public class Findlist {
    public int find(int[] lista,int a){
        int b = -1;
        for (int i = 0; i < lista.length; i++) {
            if(a == lista[i])
                b = i;
        }
        return b;
    }
}
