package Test;

public class Main {

    static void incPos(int[] pos, int[] move){
        for (int i = 0; i < pos.length; i++) {
            pos[i] += move[i];
        }
    }

    static void fillArr(int[][] src){
        //не будем проверять, что во всех строках матрицы одинаковое количество столбцов и вообще там что-то есть
        //но если бы захотели то сделали бы это здесь

        int sizeY = src.length;
        int sizeX = src[0].length;

        //Массив движений
        int[][] moves = {{0,1},{1,0},{0,-1},{-1,0}};

        //Длины
        int[] srcLens = {sizeX, sizeY - 1};

        //координаты курсора
        int[] pos = {0,-1};

        int size = sizeX * sizeY;

        int lenIndex = 0;
        int i = 0;
        while (i < size){
            for (int j = 0; j < moves.length; j++) {
                for (int k = 0; k < srcLens[lenIndex]; k++) {
                    incPos(pos, moves[j]);
                    src[pos[0]][pos[1]] = ++i;
                }
                srcLens[lenIndex]--;
                if(++lenIndex == srcLens.length) lenIndex = 0;
            }
        }
    }
    
    static public void main(String[] args){
        int[][] arr = new int[7][10];
        fillArr(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%2d ",arr[i][j]);
            }
            System.out.println();
        }
    }
}
