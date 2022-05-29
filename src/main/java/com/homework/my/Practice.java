package com.homework.my;

public class Practice {
    public static void main(String[] args) {
        String[][] array =  new String[][]{
                {"1", "2", "3", "9"},
                {"2", "3", "1", "1"},
                {"3", "3", "2", "1"},
                {"1", "1", "2", "3"}
        };

        try {
            try {
                int result = heightWeightArray(array);
                System.out.println("Сумма равна: " +  result);
            } catch (MyArraySizeException e) {
                System.out.println("Размер массива превышен");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Значение массива неверно в ячейке: " + e.i + " * " + e.j);
        }
    }


    public static int heightWeightArray(String[][] array) throws MyArraySizeException ,MyArrayDataException{
        int count = 0;
        if (array.length != 4){
            throw new MyArraySizeException("Массив должен быть размером 4*4");
        }
        for (int i = 0; i < array.length; i++){
            if (array[i].length != 4){
                throw new MyArraySizeException("Массив должен быть размером 4*4");
            }
            for (int j = 0; j < array[i].length; j++){
                try {
                    count = count + Integer.parseInt(array [i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return count;
    }
}
