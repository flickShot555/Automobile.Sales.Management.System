import javax.swing.*;

class Car extends SUVandcrossoverandCar {
    public int a;

    Car() {
    }

    public String Toyota[] = {"Select Car","Corolla", "Camry", "Prius", "Yaris", "fielder", "probox"};
    public String Honda_Atlas[] = {"Select Car","Civic", "City", "Accord", "Crossroad"};
    public String PAK_Suzuki[] = {"Select Car","Mehran", "Cultus", "Wagon R", "Swift", "Baleno", "Ciaz", "Stingray"};
    public String AL_HajFAW[] = {"Select Car","V2", "X-PV", "Carrier", "Sirius", "Junpai D60"};
    public String Regal_Automobile[] = {"Select Car","Prince Pearl"};
    public String KIA_Pak[] = {"Select Car","Picanto", "Sportage", "Carnival", "Cerato"};
    public String Nissan[] = {"Select Car","bluebird", "note", "juke"};
    public String Mercedes_Pak[] = {"Select Car","A-Class", "C-Class", "E-Class", "S-Class", "GLA", "GLC", "GLE"};
    public String Audi_Pak[] = {"Select Car","A3", "A4", "A5", "A6", "A7"};
    public String Hyundai[] = {"Select Car","Santro", "Tucson", "Elantra", "Sonata", "Grand Starex"};
    public String Proton[] = {"Select Car","Saga", "Persona"};
    public String Changan[] = {"Select Car","Alsvin", "Karvaan", "M9"};

    public static String Cars[] = {"Select Make", "Proton", "Audi_Pak", "Mercedes_Pak", "Toyota", "Nissan", "Honda_Atlas", "Hyundai", "Changan", "PAK_Suzuki", "AL_HajFAW", "KIA_Pak", "Regal_Automobile"};

    public void toCmbobox(JComboBox a, String array[]){
        for(String text: array){
            a.addItem(text);
        }
    }
}
