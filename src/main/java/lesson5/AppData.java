package lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {
    private String[] header;
    private Integer[][] data;

    public Integer[][] getData() {
        return data;
    }

    public void setData(Integer[][] data) {
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    private <T> String rowString (T[] row){
        String results = " ";
        for (int i =0; i < row.length; i++){
            results = results + row[i].toString();
            if (i != row.length -1){
                results = results + ";";
            }
        }
        results = results + "\n";
        return results;
    }


    private Integer[] stringToRowData (String string){
        String[] strings = string.split(";");

        Integer[] integers = new Integer[strings.length];
        for (int i =0; i < strings.length; i++){
            integers[i] = Integer.parseInt(strings[i]);
        }
        return integers;
    }

    public void saveFile (String nameFile){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameFile))) {
            bufferedWriter.write(rowString(header));

            for (Integer[] row : data) {
                bufferedWriter.write(rowString(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void load(String nameFile){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(nameFile))){
            header = bufferedReader.readLine().split(";");
            ArrayList<Integer[]> datalist = new ArrayList<>();
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null){
                datalist.add(stringToRowData(tempString));
            }
            data = datalist.toArray(new Integer[][]{{}});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
