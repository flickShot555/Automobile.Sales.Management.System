import javax.swing.*;

class SUV extends SUVandcrossoverandCar {

    SUV() {
    }

    public String Toyota[] = {"Select the SUV","Landcruiser", "Fortuner"};
    public String Nissan[] = {"Select the SUV","petrol"};
    public String Hyundai[] = {"Select the SUV","tucson"};
    public String Changan[] = {"Select the SUV","oshan X7"};
    public String DFSK[] = {"Select the SUV","Glory 580", "Glory 580 pro"};
    public String MG[] = {"Select the SUV","HS", "ZS"};
    public String Kia[] = {"Select the SUV","Sportage"};

    public static String Suv[] = {"Select Make", "Toyota", "Nissan", "Hyundai", "Changan", "DFSK", "MG", "Kia"};

    public void toCmbobox(JComboBox a, String array[]){
        for(String text: array){
            a.addItem(text);
        }
    }

}
