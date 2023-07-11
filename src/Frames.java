import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Frames { //example of inheritance
//    String mainframe_type, mainframe_make, mainframe_name, mainframe_prod_year, mainframe_VIN, mainframe_price;
    JLabel error, incorrect_error;
    JFrame first_frame, second_frame, third_frame, main_frame, searchdb, delete;
    String credentialarray[] = new String[2];
    //jlabels for main_frame\\search_through_databse\\search button.
    JLabel slbl1,slbl7,slbl6,slbl5,slbl2,slbl4,slbl14,slbl8,slbl9,slbl10,slbl11,slbl12,slbl13;
    JTextField stxt1;
    public int option;
    public void first_frame() {
        first_frame = new JFrame("Login/Sign Up");
        //logo;
        first_frame.setLayout(null);
        first_frame.setBounds(350, 100, 400, 470);
        first_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        first_frame.setResizable(false);
        first_frame.setVisible(true);
        Image icon2 = Toolkit.getDefaultToolkit().getImage("logo design.png");
        first_frame.setIconImage(icon2);


        ImageIcon img = new ImageIcon("logo design.png");
        JLabel pictest = new JLabel(img);
        pictest.setBounds(66, 46, 250, 220);
        pictest.setVisible(true);
        first_frame.add(pictest);


        JButton lgn = new JButton("Login");
        lgn.setBounds(66, 370, 100, 30);
        lgn.setVisible(true);
        lgn.setBackground(Color.LIGHT_GRAY);
        lgn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second_frame();
                first_frame.setVisible(false);
            }
        });
        first_frame.add(lgn);

        JButton snp = new JButton("Sign-up");
        snp.setBounds(217, 370, 100, 30);
        snp.setVisible(true);
        snp.setBackground(Color.LIGHT_GRAY);
        snp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                first_frame.setVisible(false);
                third_frame();
            }
        });
        first_frame.add(snp);
    }
    public void second_frame() {


        second_frame = new JFrame("Login");
        second_frame.setBounds(350, 100, 400, 470);
        second_frame.setLayout(null);
        second_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        second_frame.setResizable(false);
        second_frame.setVisible(true);
        Image icon2 = Toolkit.getDefaultToolkit().getImage("logo design.png");
        second_frame.setIconImage(icon2);


        ImageIcon img = new ImageIcon("logo design.png");
        JLabel pictest = new JLabel(img);
        pictest.setBounds(66, 46, 250, 220);
        pictest.setVisible(true);
        second_frame.add(pictest);

        JLabel usrnm = new JLabel("Username:");
        usrnm.setBounds(20, 310, 70, 25);
        usrnm.setVisible(true);
        second_frame.add(usrnm);

        JLabel pwrd = new JLabel("Password:");
        pwrd.setBounds(20, 345, 70, 25);
        pwrd.setVisible(true);
        second_frame.add(pwrd);

        TextField t_usrnm = new TextField();
        t_usrnm.setBounds(120, 308, 230, 27);
        t_usrnm.setVisible(true);
        second_frame.add(t_usrnm);

        JPasswordField t_pwrd = new JPasswordField();
        t_pwrd.setBounds(120, 342, 230, 27);
        t_pwrd.setEchoChar('*');
        t_pwrd.setVisible(true);
        second_frame.add(t_pwrd);

        JButton Login = new JButton("Enter");
        Login.setBounds(217, 385, 100, 30);
        Login.setVisible(true);
        Login.setBackground(Color.LIGHT_GRAY);
        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*String username = null;
                String password = null;*/
                String username = t_usrnm.getText();
                System.out.println("login page: username value taken!");
                String password = t_pwrd.getText();
                System.out.println("login page: password value taken!");
                System.out.println(username + password);
                Credentials login = new Credentials("Login"); //example of container-ship.
                /*login.displayCredentials();
                String test = login.getUsername();
                String test2 = login.getPassword(test);
                System.out.println(test + " " + test2);*/
                if ((username.isEmpty()) || (password.isEmpty())) {
                    error = new JLabel("NO TEXT-FIELD SHOULD REMAIN EMPTY!");
                    error.setBounds(158, 220, 204, 20);
                    error.setForeground(Color.RED);
                    error.setVisible(false);
                    error.setFont(new Font("Times New Roman", Font.PLAIN, 9));
                    second_frame.add(error);

                    error.setVisible(true);

                    Timer bomb = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            error.setVisible(false);
                        }
                    });
                    bomb.setRepeats(false);
                    bomb.start();
                } else {
                    //boolean check = login.verify(username, password);
                    if (login.verify(username, password)) {
                        //further application
                        credentialarray[0] = username;
                        credentialarray[1] = password;
                        System.out.println("Successful login!");
                        second_frame.dispose();
                        main_frame();
                    } else {
                        incorrect_error = new JLabel("Invalid username or password!");
                        incorrect_error.setForeground(Color.RED);
                        incorrect_error.setBounds(173, 220, 200, 20);
                        incorrect_error.setVisible(false);
                        second_frame.add(incorrect_error);


                        incorrect_error.setVisible(true);
                        Timer clock = new Timer(2000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                incorrect_error.setVisible(false);
                            }
                        });
                        clock.setRepeats(false);
                        clock.start();
                    }
                }
                /*username = null;
                password = null;*/
            }
        });
        second_frame.add(Login);

        JButton back = new JButton("Back");
        back.setBounds(66, 385, 100, 30);
        back.setVisible(true);
        back.setBackground(Color.LIGHT_GRAY);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                second_frame.dispose();
                first_frame.setVisible(true);
            }
        });
        second_frame.add(back);

    }
    public void third_frame() {
        third_frame = new JFrame("Sign-up");
        third_frame.setBounds(350, 100, 400, 470);
        //logo
        third_frame.setLayout(null);
        third_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        third_frame.setResizable(false);
        third_frame.setVisible(true);
        Image icon2 = Toolkit.getDefaultToolkit().getImage("logo design.png");
        third_frame.setIconImage(icon2);


        ImageIcon img = new ImageIcon("logo design.png");
        JLabel pictest = new JLabel(img);
        pictest.setBounds(66, 46, 250, 220);
        pictest.setVisible(true);
        third_frame.add(pictest);

        JLabel usrnm = new JLabel("Username:");
        usrnm.setBounds(20, 310, 70, 25);
        usrnm.setVisible(true);
        third_frame.add(usrnm);

        JLabel pwrd = new JLabel("Password:");
        pwrd.setBounds(20, 345, 70, 25);
        pwrd.setVisible(true);
        third_frame.add(pwrd);

        TextField t_usrnm = new TextField();
        t_usrnm.setBounds(120, 308, 230, 27);
        t_usrnm.setVisible(true);
        third_frame.add(t_usrnm);

        JPasswordField t_pwrd = new JPasswordField();
        t_pwrd.setBounds(120, 342, 230, 27);
        t_pwrd.setVisible(true);
        t_pwrd.setEchoChar('*');
        third_frame.add(t_pwrd);

        JButton signup = new JButton("Enter");
        signup.setBounds(217, 385, 100, 30);
        signup.setVisible(true);
        signup.setBackground(Color.LIGHT_GRAY);
        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valueofUsername = t_usrnm.getText();
                System.out.println(valueofUsername);
                String valueofPassword = t_pwrd.getText();
                System.out.println(valueofPassword);
                if ((valueofUsername.isEmpty()) || (valueofPassword.isEmpty())) {
                    error = new JLabel("NO TEXT-FIELD SHOULD REMAIN EMPTY!");
                    error.setBounds(158, 220, 204, 20);
                    error.setForeground(Color.RED);
                    error.setVisible(false);
                    error.setFont(new Font("Times New Roman", Font.PLAIN, 9));
                    third_frame.add(error);

                    error.setVisible(true);

                    Timer timer = new Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            error.setVisible(false);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                } else {
                    System.out.println("ELSE block has run!");
                    Credentials inputs = new Credentials(valueofUsername);// example of containership
                    inputs.setUsername(valueofUsername);
                    inputs.setPassword(valueofPassword);
                    inputs.WriteToFile();
                    System.out.println("reached to write to file!");
                    try {
                        Date currentDate = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mmm-yyy");
                        String formattedDate = dateFormat.format(currentDate);
                        System.out.println(formattedDate);
                        File fle = new File("D:\\java files\\Automobile Sales Management System\\" +
                                "a\\b\\c\\d\\e\\" + valueofUsername + ".csv");
                        fle.createNewFile();
                        PrintWriter pen = new PrintWriter(fle);
                        String p,q,r,s,t,u,v;
                        p = "Vehicle Type";q="Vehicle Make";r="Vehicle Name";s="Production Year";t="V.I.N";u="Price";v="date";
                        pen.printf("%s,%s,%s,%s,%s,%s,%s\n",p,q,r,s,t,u,v);
                        //
                        pen.close();
                        Portals prt = new Portals(valueofUsername); //example of has-a relationship
                    } catch (IOException err) {
                        String errorvalue = String.valueOf(err.getStackTrace());
                        Errors er = new Errors(errorvalue);
                    }

                    second_frame();
                    third_frame.dispose();
                }
                System.out.println(valueofPassword + " " + valueofUsername);
            }
        });
        third_frame.add(signup);

        JButton back = new JButton("Back");
        back.setBounds(66, 385, 100, 30);
        back.setVisible(true);
        back.setBackground(Color.LIGHT_GRAY);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                third_frame.dispose();
                first_frame.setVisible(true);
            }
        });
        third_frame.add(back);


    }
    public void main_frame() {
        //example of polymorphism
        SUVandcrossoverandCar forCar = new Car();
        SUVandcrossoverandCar forCrossover = new Crossovers();
        SUVandcrossoverandCar forSUV = new SUV();

        JComboBox company = new JComboBox();
        JComboBox name = new JComboBox();
        name.addItem("Select Name!");
        JComboBox year = new JComboBox();

        //String[] refresher = {"Select Vehicle Type", "Select Make", "Select Name", "Select Production Year: YYYY"};
        String[] entry = new String[4];
        String[] searcharray = new String[6];
        String[] deletearray = new String[6];
        main_frame = new JFrame("Automobile Management System");
        main_frame.setBounds(150, 20, 1000, 700);
        main_frame.setLayout(null);
        main_frame.setVisible(true);
        main_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Image icon2 = Toolkit.getDefaultToolkit().getImage("logo design.png");
        main_frame.setIconImage(icon2);
        main_frame.setResizable(false);

        JLabel welcome = new JLabel("WELCOME!");
        welcome.setFont(new Font("Times new Roman", Font.CENTER_BASELINE, 49));
        welcome.setVisible(true);
        welcome.setBounds(340, 30, 290, 50);
        main_frame.add(welcome);

        JLabel asms = new JLabel("AutoMobile Sales Management System");
        asms.setFont(new Font("Times new Roman", Font.PLAIN, 40));
        asms.setVisible(true);
        asms.setBounds(170, 90, 650, 43);
        main_frame.add(asms);

        JLabel hline = new JLabel("_________________________________________________________________________" +
                "_____________________________________________________________");
        hline.setBounds(20, 140, 950, 19);
        hline.setVisible(true);
        main_frame.add(hline);

        JLabel right = new JLabel();
        right.setText("Enter to Database here:");
        right.setFont(new Font("times new roman", Font.PLAIN, 20));
        right.setBounds(55, 170, 200, 30);
        right.setVisible(true);
        main_frame.add(right);

        JComboBox<String> vehicle = new JComboBox<>();
        vehicle.setVisible(false);
        for (String a : SUVandcrossoverandCar.vehicletypes) {
            vehicle.addItem(a);
        }
        vehicle.setBounds(90, 210, 200, 30);
        vehicle.setBackground(Color.LIGHT_GRAY);
        vehicle.setVisible(true);
        vehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String test = String.valueOf(((JComboBox)e.getSource()).getSelectedItem());
                if (!test.equals("Select Vehicle Type")) {
                    /*company.removeAllItems();
                    name.removeAllItems();
                    year.removeAllItems();*/
                    /*company.addItem("Select company!");
                    name.addItem("Select Name!");
                    year.addItem("Select Production Year: YYYY");*/
                    entry[0] = test;
                    System.out.println("the selection is " + test);
                    switch (test){
                        case "SUV":
                            /*name.removeAllItems();
                            name.addItem("Select Name!");*/
                            company.removeAllItems();
                            for(String a: SUV.Suv){
                                company.addItem(a);
                            }
                            option = 1;
                            break;
                        case "Car":
                            /*name.removeAllItems();
                            name.addItem("Select Name!");*/
                            company.removeAllItems();
                            for(String a: Car.Cars){
                                company.addItem(a);
                            }
                            option = 2;
                            break;
                        case "Crossover":
                            /*name.removeAllItems();
                            name.addItem("Select Name!");*/
                            company.removeAllItems();
                            for(String a: Crossovers.Crossovers){
                                company.addItem(a);
                            }
                            option = 3;
                            break;
                    }
                }
                /*else{
                    name.addItem("Select Name");
                }*/
            }
        });
        main_frame.add(vehicle);

        company.setVisible(false);
        company.setBounds(90, 270, 200, 30);
        company.setBackground(Color.LIGHT_GRAY);
        company.setVisible(true);
        company.addItem("Select company!");
        company.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String test = String.valueOf(((JComboBox) e.getSource()).getSelectedItem());
                SUV one= new SUV();
                Car two = new Car();
                Crossovers three = new Crossovers();
                if (!test.equals("Select Vehicle Type")) {
                    //name.removeAllItems();
                    year.removeAllItems();
                    //name.addItem("Select Name!");
                    year.addItem("Select Production Year: YYYY");

                    entry[1] = test;
                    System.out.println(entry[1]);
                }
                else name.addItem("Select Name");
                switch(option){
                    case 1:
                        //name.removeAllItems();
                        switch(test){
                            case "Toyota":
                                name.removeAllItems();
                                forSUV.toCmbobox(name,one.Toyota);
                                break;
                            case "Nissan":
                                name.removeAllItems();
                                forSUV.toCmbobox(name, one.Nissan);
                                break;
                            case "Hyundai":
                                name.removeAllItems();
                                forSUV.toCmbobox(name,one.Hyundai);
                                break;
                            case "Changan":
                                name.removeAllItems();
                                forSUV.toCmbobox(name,one.Changan);
                                break;
                            case "DFSK":
                                name.removeAllItems();
                                forSUV.toCmbobox(name,one.DFSK);
                                break;
                            case "MG":
                                name.removeAllItems();
                                forSUV.toCmbobox(name,one.MG);
                                break;
                            case "Kia":
                                name.removeAllItems();
                                forSUV.toCmbobox(name,one.Kia);
                                break;
                        }
                        break;
                    case 2:
                        //name.removeAllItems();
                        switch(test){
                            case "Proton":
                                name.removeAllItems();
                                forCar.toCmbobox(name,two.Proton);
                                break;
                            case "Audi_Pak":
                                name.removeAllItems();
                                forCar.toCmbobox(name,two.Audi_Pak);
                                break;
                            case "Mercedes_Pak":
                                name.removeAllItems();
                                forCar.toCmbobox(name,two.Mercedes_Pak);
                                break;
                            case "Toyota":
                                name.removeAllItems();
                                forCar.toCmbobox(name,two.Toyota);
                                break;
                            case "Nissan":
                                name.removeAllItems();
                                forCar.toCmbobox(name,two.Nissan);
                                break;
                            case "Honda_Atlas":
                                name.removeAllItems();
                                forCar.toCmbobox(name,two.Honda_Atlas);
                                break;
                            case "Hyundai":
                                name.removeAllItems();
                                forCar.toCmbobox(name,two.Hyundai);
                                break;
                            case "Changan":
                                name.removeAllItems();
                                forCar.toCmbobox(name,two.Changan);
                                break;
                            case "AL_HajFAW":
                                name.removeAllItems();
                                forCar.toCmbobox(name,two.AL_HajFAW);
                                break;
                            case "KIA_Pak":
                                name.removeAllItems();
                                forCar.toCmbobox(name,two.KIA_Pak);
                                break;
                            case "Regal_Automobile":
                                name.removeAllItems();
                                forCar.toCmbobox(name,two.Regal_Automobile);
                                break;
                            case "PAK_Suzuki":
                                name.removeAllItems();
                                forCar.toCmbobox(name,two.PAK_Suzuki);
                                break;
                        }
                        break;
                    case 3:
                        //name.removeAllItems();
                        switch (test){
                            case "Toyota":
                                name.removeAllItems();
                                forCrossover.toCmbobox(name,three.Toyota);
                                break;
                            case "Honda":
                                name.removeAllItems();
                                forCrossover.toCmbobox(name,three.Honda);
                                break;
                            case "Hyundai":
                                name.removeAllItems();
                                forCrossover.toCmbobox(name,three.Hyundai);
                                break;
                            case "Kia":
                                name.removeAllItems();
                                forCrossover.toCmbobox(name,three.Kia);
                                break;
                        }
                        break;
                }
            }
        });
        main_frame.add(company);


        name.setVisible(false);
        name.setBounds(90, 330, 200, 30);
        name.setBackground(Color.LIGHT_GRAY);
        name.addItem("Select Name!");
        name.setVisible(true);
        name.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                year.removeAllItems();
                year.addItem("Select Production Year: YYYY");
                String test = String.valueOf(((JComboBox)e.getSource()).getSelectedItem());
                if((!test.equals("Select Car"))||(!test.equals("Select the SUV"))||(!test.equals("Select the Crossover")))
                {
                    entry[2] = test;
                    for(int a: SUVandcrossoverandCar.year){
                        year.addItem(a);
                    }
                }
            }
        });
        main_frame.add(name);


        year.setVisible(false);
        year.setBounds(90, 390, 200, 30);
        year.setBackground(Color.LIGHT_GRAY);
        year.setVisible(true);
        year.addItem("Select Production Year: YYYY");
        year.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String test = String.valueOf(((JComboBox)e.getSource()).getSelectedItem());
                if(!test.equals("Select Production Year: YYYY"))
                {
                    entry[3] = test;
                }
            }
        });
        main_frame.add(year);


        JLabel vin = new JLabel();
        vin.setVisible(false);
        vin.setText("Enter the V.I.N");
        vin.setBounds(90,430,200,20);
        vin.setVisible(true);
        main_frame.add(vin);

        JTextField txt = new JTextField(20);
        txt.setBounds(90,450,200,30);
        txt.setBackground(Color.LIGHT_GRAY);
        txt.setVisible(true);
        main_frame.add(txt);

        JLabel price = new JLabel();
        price.setVisible(false);
        price.setText("Enter price");
        price.setBounds(90,490,200,20);
        price.setVisible(true);
        main_frame.add(price);

        JTextField txtprice = new JTextField(20);
        txtprice.setBounds(90,510,200,30);
        txtprice.setBackground(Color.LIGHT_GRAY);
        txtprice.setVisible(true);
        main_frame.add(txtprice);

        JButton enter = new JButton("Enter");
        enter.setBounds(140,575,100,30);
        enter.setBackground(Color.LIGHT_GRAY);
        enter.setVisible(true);
        main_frame.add(enter);
        enter.addActionListener(new ActionListener() {
            //String[] entry = {"Select Vehicle Type", "Select Make", "Select Name", "Select Production Year"};
            public void actionPerformed(ActionEvent e) {
                if(!entry[0].equals("Select Vehicle Type"))
                {
                    if(!entry[1].equals("Select Make"))
                    {
                        if(!entry[2].equals("Select Name"))
                        {
                            if(!entry[3].equals("Select Production Year: YYYY"))
                            {
                                String a = txt.getText();
                                System.out.println("text value of VIN is:"+a);
                                if(!a.isEmpty())
                                {
                                    String b = txtprice.getText();
                                    System.out.println("Text value of price is:"+b);
                                    if(!b.isEmpty())
                                    {
                                        String type,make,names,pyear,vin,price;
                                        type = entry[0];make = entry[1];names = entry[2];pyear = entry[3];vin = a;price = b;
                                        Writer pen = new Writer(type,make,names,pyear,vin,price,credentialarray[0]);
                                        for(int i=0;i<4;i++)
                                            entry[i] = "";
                                        vehicle.removeAllItems();
                                        company.removeAllItems();
                                        name.removeAllItems();
                                        year.removeAllItems();
                                        for(String q: SUVandcrossoverandCar.vehicletypes){
                                            vehicle.addItem(q);
                                        }
                                        //wh
                                        company.addItem("Select Company");
                                        name.addItem("Select Name");
                                        year.addItem("Select Production Year: YYYY");
                                        txt.setText(null);
                                        txtprice.setText(null);
                                        main_frame.validate();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });

        JLabel left = new JLabel();
        left.setVisible(false);
        left.setText("Handle Database here:");
        left.setFont(new Font("times new roman", Font.PLAIN, 20));
        left.setBounds(625, 170, 200, 30);
        left.setVisible(true);
        main_frame.add(left);

        JButton clear = new JButton("Clear Records");
        clear.setBounds(660, 210, 200, 30);
        clear.setBackground(Color.LIGHT_GRAY);
        clear.setVisible(true);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    PrintWriter fle = new PrintWriter("D:\\java files\\Automobile sales Management System\\a\\b\\c\\d\\e\\"+credentialarray[0]+".csv");
                    fle.write("");
                    String p,q,r,s,t,u,v;
                    p = "Vehicle Type";q="Vehicle Make";r="Vehicle Name";s="Production Year";t="V.I.N";u="Price";v="Date";
                    fle.printf("%s,%s,%s,%s,%s,%s,%s\n",p,q,r,s,t,u,v);
                    fle.close();
                }catch(IOException o){
                    String a = String.valueOf(o.getStackTrace());
                    Errors p =new Errors(a);
                }
            }
        });
        main_frame.add(clear);

        JButton open = new JButton("Open Records");
        open.setVisible(false);
        open.setBounds(660, 280, 200, 30);
        open.setBackground(Color.LIGHT_GRAY);
        open.setVisible(true);
        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    File fle = new File("D:\\java files\\Automobile Sales Management System\\a\\b\\c\\d\\e\\"+credentialarray[0]+".csv");
                    String path = fle.getAbsolutePath();
                    System.out.println(path);
                    if(Desktop.isDesktopSupported())
                    {
                        Desktop.getDesktop().open(fle);
                        System.out.println("if block has run!!");
                    }
                }catch(IOException r){
                    String  q = String.valueOf(r.getStackTrace());
                    Errors er = new Errors(q);
                }
            }
        });
        main_frame.add(open);

        JButton search = new JButton("Search through Database");
        search.setVisible(false);
        search.setBounds(660, 355, 200, 30);
        search.setBackground(Color.LIGHT_GRAY);
        search.setVisible(true);
        search.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JButton sclose, srch,clear;

                searchdb  = new JFrame("Search");
                searchdb.setBounds(300,150,510,400);
                searchdb.setVisible(true);
                searchdb.setLayout(null);

                /*Image icon2 = Toolkit.getDefaultToolkit().getImage("new logo.jpeg");
                search.setIconImage(icon2);*/

                slbl1 = new JLabel("Enter V.I.N: ");
                slbl1.setBounds(20,23,180,15);
                slbl1.setFont(new Font("Times New Roman",Font.PLAIN,20));
                slbl1.setVisible(true);
                searchdb.add(slbl1);

                stxt1 = new JTextField();
                stxt1.setBounds(200,15,200,30);
                stxt1.setVisible(true);
                searchdb.add(stxt1);

                slbl7 = new JLabel("DETAILS:");
                slbl7.setFont(new Font("Times New Roman",Font.PLAIN,30));
                slbl7.setBounds(20,50,300,40);
                slbl7.setVisible(true);
                searchdb.add(slbl7);

                slbl6 = new JLabel("Vehicle Type: ");
                slbl6.setBounds(20,100,150,15);
                slbl6.setVisible(true);
                searchdb.add(slbl6);

                slbl2 = new JLabel("Vehicle Make:");
                slbl2.setBounds(20,130,150,15);
                slbl2.setVisible(true);
                searchdb.add(slbl2);

                /*slbl3 = new JLabel("Car company:");
                slbl3.setBounds(5,140,150,15);
                slbl3.setVisible(true);
                search.add(slbl3);*/

                slbl4 = new JLabel("Vehicle Name:");
                slbl4.setBounds(20,160,150,15);
                slbl4.setVisible(true);
                searchdb.add(slbl4);

                slbl5 = new JLabel("Production Year:");
                slbl5.setBounds(20,190,150,15);
                slbl5.setVisible(true);
                searchdb.add(slbl5);

                slbl13 = new JLabel("V.I.N:");
                slbl13.setBounds(20,220,150,15);
                slbl13.setVisible(true);
                searchdb.add(slbl13);

                slbl14 = new JLabel("Price:");
                slbl14.setBounds(20,250,150,15);
                slbl14.setVisible(true);
                searchdb.add(slbl14);

                sclose = new JButton("CLOSE");
                sclose.setBounds(195,300,80,25);
                sclose.setBackground(Color.LIGHT_GRAY);
                sclose.setVisible(true);
                sclose.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        searchdb.dispose();
                    }
                });
                searchdb.add(sclose);

                srch = new JButton("Search");
                srch.setBounds(280,300,80,25);
                srch.setBackground(Color.LIGHT_GRAY);
                srch.setVisible(true);
                srch.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        /*slbl8.setText("");
                        slbl9.setText("");
                        slbl10.setText("");
                        slbl11.setText("");
                        slbl12.setText("");
                        slbl13.setText("");*/


                        String code = stxt1.getText();
                        System.out.println(code);
                        String line , check;
                        try{
                            //File fle = new File("Records.csv");
                            String path = "D:\\java files\\Automobile Sales Management System\\a\\b\\c\\d\\e\\"+credentialarray[0]+".csv";
                            //fle.getAbsolutePath();
                            BufferedReader br = new BufferedReader(new FileReader(path));
                            //System.out.println(path);
                            while((line = br.readLine()) != null){
                                String[] values = line.split(",");
                                check = values[4];
                                if(check.equals("REGISTRATION NUMBER")){
                                    System.out.println(values[0]);
                                    continue;}
                                if(check.equals(code)){
                                    searcharray[0] = values[0];
                                    searcharray[1]= values[1];
                                    searcharray[2] = values[2];
                                    searcharray[3] = values[3];
                                    searcharray[4]= values[4];
                                    searcharray[5]= values[5];

                                    System.out.println(searcharray[0]);
                                    System.out.println(searcharray[1]);
                                    System.out.println(searcharray[2]);
                                    System.out.println(searcharray[3]);
                                    System.out.println(searcharray[4]);
                                    System.out.println(searcharray[5]);
                                    break;
                                }
                            }br.close();

                        } catch (IOException f){
                            String test = String.valueOf(f.getStackTrace());
                            Errors er = new Errors(test);
                        }
                        String zero,one = searcharray[1],two =searcharray[2],three =searcharray[3],four=searcharray[4],five=searcharray[5];
                        zero = searcharray[0];
                        slbl8 = new JLabel();
                        slbl8.setText(zero);
                        slbl8.setBounds(200,100,100,15);//5,100,150,15
                        searchdb.add(slbl8);
                        slbl8.setVisible(false);

                        slbl9 = new JLabel();
                        slbl9.setText(one);
                        slbl9.setBounds(200,130,100,15);
                        searchdb.add(slbl9);
                        slbl9.setVisible(false);

                        slbl10 = new JLabel();
                        slbl10.setText(two);
                        slbl10.setBounds(200,160,100,15);
                        searchdb.add(slbl10);
                        slbl10.setVisible(false);

                        slbl11 = new JLabel();
                        slbl11.setText(three);
                        slbl11.setBounds(200,190,100,15);
                        searchdb.add(slbl11);
                        slbl11.setVisible(false);

                        slbl12 = new JLabel();
                        slbl12.setText(four);
                        slbl12.setBounds(200,220,100,15);
                        searchdb.add(slbl12);
                        slbl12.setVisible(false);

                        slbl13 = new JLabel();
                        slbl13.setText(five);
                        slbl13.setBounds(200,250,100,15);
                        searchdb.add(slbl13);
                        slbl13.setVisible(false);

                        slbl8.setVisible(true);
                        slbl9.setVisible(true);
                        slbl10.setVisible(true);
                        slbl11.setVisible(true);
                        slbl12.setVisible(true);
                        slbl13.setVisible(true);
                        stxt1.setText("");
                        code = "";
                    }
                });
                searchdb.add(srch);

                clear = new JButton("CLEAR");
                clear.setBounds(110,300,80,25);
                clear.setVisible(true);
                clear.setBackground(Color.LIGHT_GRAY);
                clear.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                         slbl8.setText("");
                         slbl9.setText("");
                        slbl10.setText("");
                        slbl11.setText("");
                        slbl12.setText("");
                        slbl13.setText("");
                        stxt1.setText("");
                        for(int i = 0; i <5;i++){
                            searcharray[i] = "";

                        }                    }
                });
                searchdb.add(clear);

            }
        });
        main_frame.add(search);


        JButton calc = new JButton("Calculate Stats");
        calc.setVisible(false);
        calc.setBackground(Color.LIGHT_GRAY);
        calc.setBounds(660,430,200,30);
        calc.setVisible(true);
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ttl_salses,ttl;
                JLabel frst, scnd, best, better, good, average;
                //String vlu
                JFrame calculate  = new JFrame("Statistics");
                calculate.setBounds(300,150,510,400);
                calculate.setVisible(true);
                calculate.setLayout(null);

                JButton close = new  JButton("Close");
                close.setVisible(true);
                close.setBackground(Color.LIGHT_GRAY);
                close.setBounds(350,310,100,30);
                close.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        calculate.dispose();
                    }
                });
                calculate.add(close);

                JLabel ttlsales = new JLabel("Total Sales: ");
                ttlsales.setFont(new Font("Times New Roman",Font.PLAIN,20));
                ttlsales.setBounds(10,20,130,30);
                ttlsales.setVisible(true);
                calculate.add(ttlsales);

                JLabel lstmnthsales = new JLabel("Last Month Sales: ");
                lstmnthsales.setFont(new Font("Times New Roman",Font.PLAIN,20));
                lstmnthsales.setBounds(10,70,165,30);
                lstmnthsales.setVisible(true);
                calculate.add(lstmnthsales);

                JLabel makessales = new JLabel("Trending Makes: ");
                makessales.setFont(new Font("Times New Roman",Font.PLAIN,20));
                makessales.setBounds(10,120,200,30);
                makessales.setVisible(true);
                calculate.add(makessales);

                best = new JLabel("Toyota");
                best.setFont(new Font("Times New Roman",Font.PLAIN,20));
                best.setBounds(160,160,200,30);
                best.setVisible(true);
                calculate.add(best);

                better = new JLabel("Honda");
                better.setFont(new Font("Times New Roman",Font.PLAIN,20));
                better.setBounds(160,200,200,30);
                better.setVisible(true);
                calculate.add(better);

                good = new JLabel("Suzuki");
                good.setFont(new Font("Times New Roman",Font.PLAIN,20));
                good.setBounds(160,240,200,30);
                good.setVisible(true);
                calculate.add(good);

                average = new JLabel("Kia");
                average.setFont(new Font("Times New Roman",Font.PLAIN,20));
                average.setBounds(160,280,200,30);
                average.setVisible(true);
                calculate.add(average);

                try{
                    File fle = new File("D:\\java files\\Automobile Sales Management System\\a\\b\\c\\d\\e\\"+credentialarray[0]+".csv");
                    BufferedReader br = new BufferedReader(new FileReader(fle));
                    ArrayList<Integer> mnth = new ArrayList<>();
                    String line, check;
                    int sum = 0;
                    while((line = br.readLine())!=null){
                        System.out.println(line);
                        String read[] = line.split(",");
                        if(read[0].equals("Vehicle Type"))
                            continue;
                        sum = sum+1; // help to maintain a count of all the entries made so far;
                        /*String date = read[6]; //takes input the date value
                        int month = date.charAt(6); //reads the exact number that represents the month value
                        int safe = month;
                        System.out.println(safe); // to check whether the month is recorded pr not?*/

                    }
                    ttl_salses= String.valueOf(sum);ttl = String.valueOf(sum);
                    frst = new JLabel(ttl_salses);
                    frst.setVisible(true);
                    frst.setFont(new Font("Times New Roman",Font.PLAIN,20));
                    frst.setBounds(160,20,130,30);
                    calculate.add(frst);

                    scnd = new JLabel(ttl);
                    scnd.setVisible(true);
                    scnd.setFont(new Font("Times New Roman",Font.PLAIN,20));
                    scnd.setBounds(160,70,180,30);
                    calculate.add(scnd);


                }catch(IOException t){
                    String a = String.valueOf(t.getStackTrace());
                    Errors er = new Errors(a);
                }
            }
        });
        main_frame.add(calc);

        JButton lgout = new JButton("log Out");
        lgout.setVisible(false);
        lgout.setBackground(Color.LIGHT_GRAY);
        lgout.setBounds(660,510,200,30);
        lgout.setVisible(true);
        lgout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                first_frame();
                main_frame.dispose();
            }
        });
        main_frame.add(lgout);

        JButton close = new JButton("Close");
        close.setBounds(710,575,100,30);
        close.setBackground(Color.LIGHT_GRAY);
        close.setVisible(true);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        main_frame.add(close);





    }
}
/* JTextField txtprice = new JTextField(20);
        txtprice.setBounds(90,510,200,30);
        txtprice.setBackground(Color.LIGHT_GRAY);
        txtprice.setVisible(true);
        main_frame.add(txtprice);


        JButton enter = new JButton("Enter");
        enter.setBounds(140,575,100,30);
        enter.setBackground(Color.LIGHT_GRAY);
        enter.setVisible(true);
        main_frame.add(enter);*/
/* JButton del = new JButton("Delete");
        del.setVisible(false);
        del.setBounds(660, 390, 200, 30);
        del.setBackground(Color.LIGHT_GRAY);
        del.setVisible(true);
        del.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {


                    JButton deletebutton, srch,sclose;

                    delete  = new JFrame("Search");
                    delete.setBounds(300,150,510,400);
                    delete.setVisible(true);
                    delete.setLayout(null);

                */
/*Image icon2 = Toolkit.getDefaultToolkit().getImage("new logo.jpeg");
                search.setIconImage(icon2);*/
/*

                    slbl1 = new JLabel("Enter V.I.N: ");
                    slbl1.setBounds(20,20,180,15);
                    slbl1.setFont(new Font("Times New Roman",Font.PLAIN,20));
                    slbl1.setVisible(true);
                delete.add(slbl1);

                    stxt1 = new JTextField();
                    stxt1.setBounds(200,20,200,30);
                    stxt1.setVisible(true);
                delete.add(stxt1);

                    slbl7 = new JLabel("DETAILS:");
                    slbl7.setFont(new Font("Times New Roman",Font.PLAIN,30));
                    slbl7.setBounds(20,50,300,40);
                    slbl7.setVisible(true);
                delete.add(slbl7);

                    slbl6 = new JLabel("Vehicle Type: ");
                    slbl6.setBounds(20,100,150,15);
                    slbl6.setVisible(true);
                delete.add(slbl6);

                    slbl2 = new JLabel("Vehicle Make:");
                    slbl2.setBounds(20,130,150,15);
                    slbl2.setVisible(true);
                delete.add(slbl2);

                */
/*slbl3 = new JLabel("Car company:");
                slbl3.setBounds(5,140,150,15);
                slbl3.setVisible(true);
                search.add(slbl3);*/
/*

                    slbl4 = new JLabel("Vehicle Name:");
                    slbl4.setBounds(20,160,150,15);
                    slbl4.setVisible(true);
                delete.add(slbl4);

                    slbl5 = new JLabel("Production Year:");
                    slbl5.setBounds(20,190,150,15);
                    slbl5.setVisible(true);
                delete.add(slbl5);

                    slbl13 = new JLabel("V.I.N:");
                    slbl13.setBounds(20,220,150,15);
                    slbl13.setVisible(true);
                delete.add(slbl13);

                    slbl14 = new JLabel("Price:");
                    slbl14.setBounds(20,250,150,15);
                    slbl14.setVisible(true);
                delete.add(slbl14);

                    sclose = new JButton("CLOSE");
                    sclose.setBounds(195,300,80,25);
                    sclose.setBackground(Color.LIGHT_GRAY);
                    sclose.setVisible(true);
                    sclose.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            delete.dispose();
                        }
                    });
                    delete.add(sclose);

                    srch = new JButton("Search");
                    srch.setBounds(280,300,80,25);
                    srch.setBackground(Color.LIGHT_GRAY);
                    srch.setVisible(true);
                    srch.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                           */
/* slbl8.setText("");
                            slbl9.setText("");
                            slbl10.setText("");
                            slbl11.setText("");
                            slbl12.setText("");
                            stxt1.setText("");*/
/*

                            String code = stxt1.getText();
                            String line , check;
                            try{
                                //File fle = new File("Records.csv");
                                String path = "D:\\java files\\Automobile Sales Management System\\a\\b\\c\\d\\e\\"+credentialarray[0]+".csv";
                                //fle.getAbsolutePath();
                                BufferedReader br = new BufferedReader(new FileReader(path));
                                //System.out.println(path);
                                while((line = br.readLine()) != null){
                                    String[] values = line.split(",");
                                    check = values[4];
                                    if(check.equals("V.I.N")){
                                        System.out.println(values[0]);
                                        continue;}
                                    if(check.equals(code)){
                                        deletearray[0] = values[0];
                                        deletearray[1]= values[1];
                                        deletearray[2] = values[2];
                                        deletearray[3] = values[3];
                                        deletearray[4]= values[4];
                                        deletearray[5]= values[5];
                                        break;
                                    }
                                }br.close();

                            } catch (IOException f){
                                String test = String.valueOf(f.getStackTrace());
                                Errors er = new Errors(test);
                            }

                            slbl8 = new JLabel();
                            slbl8.setText(deletearray[0]);
                            slbl8.setBounds(200,100,100,15);//5,100,150,15
                            delete.add(slbl8);
                            slbl8.setVisible(false);

                            slbl9 = new JLabel(deletearray[1]);
                            slbl9.setBounds(200,120,100,15);
                            delete.add(slbl9);
                            slbl9.setVisible(false);

                            slbl10 = new JLabel(deletearray[2]);
                            slbl10.setBounds(200,140,100,15);
                            delete.add(slbl10);
                            slbl10.setVisible(false);

                            slbl11 = new JLabel(deletearray[3]);
                            slbl11.setBounds(200,160,100,15);
                            delete.add(slbl11);
                            slbl11.setVisible(false);

                            slbl12 = new JLabel(deletearray[4]);
                            slbl12.setBounds(200,180,100,15);
                            delete.add(slbl12);
                            slbl12.setVisible(false);

                            slbl13 = new JLabel(deletearray[5]);
                            slbl13.setBounds(200,200,100,15);
                            delete.add(slbl13);
                            slbl13.setVisible(false);

                            slbl8.setVisible(true);
                            slbl9.setVisible(true);
                            slbl10.setVisible(true);
                            slbl11.setVisible(true);
                            slbl12.setVisible(true);
                            slbl13.setVisible(true);
                        }
                    });
                delete.add(srch);

                    deletebutton = new JButton("Delete");
                    deletebutton.setBounds(110,300,80,25);
                    deletebutton.setVisible(true);
                    deletebutton.setBackground(Color.LIGHT_GRAY);
                    deletebutton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            */
/*slbl8.setText("");
                            slbl9.setText("");
                            slbl10.setText("");
                            slbl11.setText("");
                            slbl12.setText("");
                            stxt1.setText("");
                            for(int i = 0; i <5;i++){
                                deletearray[i] = "";
                            }*/
/*
                            String line, check;
                            String code = stxt1.getText();
                            try{

                                String path = "D:\\java files\\Automobile Sales Management System\\a\\b\\c\\d\\e\\"+credentialarray[0]+".csv";
                                //fle.getAbsolutePath();
                                BufferedReader br = new BufferedReader(new FileReader(path));
                                //System.out.println(path);
                                while((line = br.readLine()) != null){
                                    String[] values = line.split(",");
                                    check = values[4];
                                    if(check.equals("V.I.N")){
                                        System.out.println(values[0]);
                                        continue;}
                                    if(check.equals(code)){
                                        System.out.println("done");
                                        Writer wr = new Writer("","","","","","",credentialarray[0]);
                                        */
/*deletearray[0] = values[0];
                                        deletearray[1]= values[1];
                                        deletearray[2] = values[2];
                                        deletearray[3] = values[3];
                                        deletearray[4]= values[4];
                                        deletearray[5]= values[5];*/
/*
                                        break;
                                    }
                                }br.close();

                            } catch (IOException f){
                                String test = String.valueOf(f.getStackTrace());
                                Errors er = new Errors(test);
                            }
                            }

                    });
                delete.add(deletebutton);


            }
        });
        main_frame.add(del);*/
