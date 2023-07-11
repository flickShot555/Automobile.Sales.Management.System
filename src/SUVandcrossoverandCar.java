import javax.swing.*;

public class SUVandcrossoverandCar{
    private static int number_of_wheels = 4;
    public static String vehicletypes[] = {"Select Vehicle Type","SUV","Crossover","Car"};
    public static int year[] = {2015,2016,2017,2018,2019,2020,2021,2022,2023};

    public void toCmbobox(JComboBox a, String array[]){
        for(String text: array){
            a.addItem(text);
        }
    }
}
