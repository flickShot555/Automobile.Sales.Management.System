import javax.swing.*;

class Crossovers extends SUVandcrossoverandCar {
    Crossovers() {
    }
    public String Toyota[] = {"Select the Crossover","Riaz"};
    public String Honda[] = {"Select the Crossover","Vezel", "BR-v", "HR-v", "CH-R"};
    public String Hyundai[] = {"Select the Crossover","tucson"};
    public String Kia[] = {"Select the Crossover","Sportage"};
    public static String Crossovers[] = {"Select Make", "Toyota", "Honda", "Hyundai", "Kia"};
    public void toCmbobox(JComboBox a, String array[]){
        for(String text: array){
            a.addItem(text);
        }
    }
}
