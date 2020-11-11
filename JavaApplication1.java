
package javaapplication1;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class JavaApplication1 {
    public static void main(String[] args) throws Exception  {
        bank sbi=new bank();
        atm sbi_atm=new atm(sbi,94134446);
        //sbi.close();
    }
    
}


class withdraw extends JFrame
{
    private JTextField amount=new JTextField();
    private final JButton withdraw=new JButton("withdraw");
    private JLabel warning=new JLabel("");
    private final JLabel guide=new JLabel("enter the amount here");
    private final JButton exit=new JButton("exit transaction");
    
    withdraw(bank sbi,long balance,int i)
    {
        guide.setBounds(100,70,190,30);
        amount.setBounds(100, 100, 190, 25);
        withdraw.setBounds(130,130,100,25);
        warning.setBounds(100,160,300,30);
        exit.setBounds(250, 300, 140, 25);
        
        exit.addActionListener((ActionEvent ae)->{
            new atm(sbi,balance);
            dispose();
        });
        withdraw.addActionListener((ActionEvent ae)->{
            int res=sbi.withdraw(Integer. parseInt(amount.getText()),i);
            if(res==0)
            {
                if(balance>Integer. parseInt(amount.getText()))
                {
                    new show(sbi,balance-Integer. parseInt(amount.getText()),i);
                    dispose();
                }
                else
                {
                    warning.setText("Not enough money in ATM");
                }
            }
            if(res==-1)
            {
                warning.setText("Least denomination is 100 INR so please enter accordingly");
            }
        });
        
        add(guide);
        add(amount);
        add(withdraw);
        add(warning);
        add(exit);
        
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class show extends JFrame
{
    private final JLabel name=new JLabel("name");
    private final JLabel phone=new JLabel("Phone number ");
    private final JLabel balance=new JLabel("Your balance");
    private final JLabel account_number=new JLabel("Account number");
    private JLabel Name=new JLabel("");
    private JLabel Phone=new JLabel("");
    private JLabel Balance=new JLabel("");
    private JLabel Account_number=new JLabel("");
    JButton exit=new JButton("exit transaction");
    show(bank sbi,long bal,int i)
    {
        Name.setText(" : "+sbi.get_name(i));
        Phone.setText(" : "+sbi.get_phone(i));
        Balance.setText(" : "+sbi.get_balance(i));
        Account_number.setText(" : "+sbi.get_account(i));
        
        name.setBounds(50,50,100,30);
        Name.setBounds(150,50,100,25);
        account_number.setBounds(50,80,100,30);
        Account_number.setBounds(150,80,100,25);
        balance.setBounds(50, 110, 100, 30);
        Balance.setBounds(150, 110, 100, 25);
        phone.setBounds(50, 140, 100, 30);
        Phone.setBounds(150, 140, 100, 25);
        exit.setBounds(130, 200, 140, 25);
        
        add(name);
        add(Name);
        add(phone);
        add(Phone);
        add(balance);
        add(Balance);
        add(account_number);
        add(Account_number);
        add(exit);
        
        exit.addActionListener((ActionEvent ae)->{
            new atm(sbi,bal);
            dispose();
        });
        
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class deposit extends JFrame
{
    private JTextField amount=new JTextField();
    private JButton deposit=new JButton("deposit");
    private JLabel warning=new JLabel("");
    private JLabel guide=new JLabel("enter the amount here");
    JButton exit=new JButton("exit transaction");
    deposit(bank sbi,long balance,int i)
    {
        guide.setBounds(100,70,190,30);
        amount.setBounds(100, 100, 190, 25);
        deposit.setBounds(130,130,100,25);
        warning.setBounds(100,160,300,30);
        exit.setBounds(250, 300, 140, 25);
        
        add(guide);
        add(amount);
        add(deposit);
        add(warning);
        add(exit);
        
        exit.addActionListener((ActionEvent ae)->{
            new atm(sbi,balance);
            dispose();
        });
        deposit.addActionListener((ActionEvent ae)->{
            int res=sbi.deposit(Integer. parseInt(amount.getText()),i);
            if(res==0)
            {
                new show(sbi,balance+Integer. parseInt(amount.getText()),i);
                dispose();
            }
            if(res==-1)
            {
                warning.setText("Least denomination is 100 INR so please enter accordingly");
            }
        });
        
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class Helper extends TimerTask 
{ 
    public static int num = 0; 
    public static bank sbi;
    @Override
    public void run() 
    { 
        try {
            sbi.block(num);
        } catch (IOException ex) {
            System.out.println("failed");
        }
    } 
    public static void set(bank b)
    {
        sbi=b;
    }
} 

class transfer extends JFrame
{
    JLabel heading =new JLabel ("Enter the details of the account you want to send money");
    JLabel account=new JLabel("account number");
    JTextField acc=new JTextField ();
    JLabel ifsc_code=new JLabel("IFSC code");
    JTextField ifsc=new JTextField ();
    JLabel amount=new JLabel("Transfer amount");
    JTextField cash=new JTextField();
    JButton transfer=new JButton("transfer");
    JLabel warning=new JLabel("");
    JButton exit=new JButton("exit transaction");
    transfer(bank sbi,long balance,int i)
    {
        heading.setBounds(50,100,200,40);
        account.setBounds(80,130,100,25);
        acc.setBounds(180,130,100,25);
        ifsc_code.setBounds(80,160,100,25);
        ifsc.setBounds(180,160,100,25);
        amount.setBounds(80,190,100,25);
        cash.setBounds(180,190,100,25);
        transfer.setBounds(100,220,100,25);
        warning.setBounds(80,250,200,25);
        exit.setBounds(250, 300, 140, 25);
        
        add(heading);
        add(account);
        add(acc);
        add(ifsc_code);
        add(ifsc);
        add(amount);
        add(cash);
        add(transfer);
        add(warning);
        add(exit);
        
        exit.addActionListener((ActionEvent ae)->{
            new atm(sbi,balance);
            dispose();
        });
        transfer.addActionListener((ActionEvent ae)->{
            boolean a=sbi.withdraw(Integer.parseInt(cash.getText()), i,0);
            if(a)
            {
                int j=sbi.find_account(Integer.parseInt(acc.getText()));
                if(j!=-1)
                {
                    sbi.deposit(Integer.parseInt(cash.getText()), j);
                    new atm(sbi,balance);
                    this.dispose();
                }
                else
                    warning.setText("invalid account number");
            }
            else
            {
                warning.setText("Not enough cash");
            }
        });
        
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class menu extends JFrame
{
    JLabel welcome=new JLabel("");
    JLabel with_draw=new JLabel("To with draw cash click here");
    JButton withdraw=new JButton("withdraw");
    JLabel show_balance=new JLabel("To see balance click here");
    JButton show=new JButton("see balance");
    JLabel depo=new JLabel("To deposit money click here");
    JButton deposit=new JButton("deposit money");
    JLabel info=new JLabel("to block the card after (min)");
    JButton block=new JButton("block");
    JTextField min=new JTextField();
    JLabel transfer=new JLabel("For account transfer");
    JButton send=new JButton("send");
    JButton exit=new JButton("exit transaction");
    menu(bank sbi,long balance,int i)
    {
        welcome.setBounds(50,30,200,40);
        with_draw.setBounds(80,80,200,25);
        withdraw.setBounds(80,110,100,25);
        show_balance.setBounds(80, 150, 200, 25);
        show.setBounds(80,180, 120, 25);
        depo.setBounds(80,210, 200, 25);
        deposit.setBounds(80,240, 120, 25);
        info.setBounds(80,270,200,25);
        min.setBounds(250, 270, 100, 25);
        block.setBounds(80, 300, 120, 25);
        transfer.setBounds(80,330,120,25);
        send.setBounds(80,360,100,25);
        exit.setBounds(190, 420, 150, 25);
        
        welcome.setText("welcome to SBI "+sbi.get_name(i));
        
        add(welcome);
        add(with_draw);
        add(withdraw);
        add(show_balance);
        add(show);
        add(depo);
        add(deposit);
        add(info);
        add(min);
        add(block);
        add(transfer);
        add(send);
        add(exit);
        
        exit.addActionListener((ActionEvent ae)->{
            new atm(sbi,balance);
            dispose();
        });
        send.addActionListener((ActionEvent ae)->{
            new transfer(sbi,balance,i);
            this.dispose();
        });
        block.addActionListener((ActionEvent ae)->{
            Timer timer = new Timer(); 
        TimerTask task = new Helper(); 
          Helper.num=i;
          Helper.set(sbi);
          long dely=(long)(60000*Integer.parseInt(min.getText()));//convertiong min to milli seconds
        timer.schedule(task,dely); 
        new atm(sbi,balance);
            dispose();
        });
        withdraw.addActionListener((ActionEvent ae) ->{
            new withdraw(sbi,balance,i);
            dispose();
        });
        show.addActionListener((ActionEvent ae) ->{
            new show(sbi,balance,i);
            dispose();
        });
        deposit.addActionListener((ActionEvent ae) -> {
            new deposit(sbi,balance,i);
            dispose();
        });
        
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class otp extends JFrame
{
    private long otp,count=5;
    Random rand = new Random();
    JLabel enter=new JLabel("enter the otp here");
    JTextField value=new JTextField();
    JButton submit=new JButton("submit");
    JLabel warning=new JLabel("");
    otp(bank sbi, long balance_in_atm, int i) {
        this.generate();
        enter.setBounds(155,150,200,25);
        value.setBounds(155, 180, 250, 25);
        submit.setBounds(200,220,80,25);
        warning.setBounds(50,250 , 200, 30);
        
        add(enter);
        add(value);
        add(submit);
        add(warning);
        
        submit.addActionListener((ActionEvent ae)->{
            if(count>0)
            {
                if(otp==Integer.parseInt(value.getText()))
                {
                    new menu(sbi,balance_in_atm,i);
                    this.dispose();
                }
                else
                {
                    count--;
                    warning.setText("you have "+count+" chances left");
                }
            }
            else
            {
                new atm(sbi,balance_in_atm);
            }
        });
        
        setLayout(null);
        setVisible(true);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void generate()
    {
        long temp=rand.nextInt(1000000);
        while(temp<100000)
        {
            temp=rand.nextInt(1000000);
        }
        otp=temp;
        //sending to console instead of mobile
        System.out.println(otp);
    }
    
}


class atm extends JFrame
{
    private int count=5;
    private long balance_in_atm=99999999;
    JLabel welcome=new JLabel("WELCOME TO SBI");
    JLabel userLabel=new JLabel("Account number");
    JLabel passwordLabel=new JLabel("pin number");
    JLabel warning=new JLabel("");
    JTextField accountnum=new JTextField(20);
    JPasswordField password=new JPasswordField();
    JButton login=new JButton("Login");
    atm(bank sbi,long balance)
    {
        balance_in_atm=balance;
        welcome.setBounds(150,90,200,40);
        userLabel.setBounds(50,150,100,25);
        accountnum.setBounds(155, 150, 250, 25);
        passwordLabel.setBounds(50,180,100,25);
        password.setBounds(155, 180, 250, 25);
        login.setBounds(200,220,80,25);
        warning.setBounds(50,250 , 200, 30);
        
        add(welcome);
        add(userLabel);
        add(accountnum);
        add(passwordLabel);
        add(password);
        add(login);
        add(warning);
        
        login.addActionListener((ActionEvent ae) -> {
            //using lambda exprestion insted of annonymus object
            if(count==0)
            {
                System.exit(-1);
            }
               boolean flag=sbi.check(Integer. parseInt(accountnum.getText()),Integer. parseInt(password.getText()));
               if(flag==true)
               {
                   //new menu(sbi,balance_in_atm,sbi.find_account(Integer. parseInt(accountnum.getText())));
                   new otp(sbi,balance_in_atm,sbi.find_account(Integer. parseInt(accountnum.getText())));
                   this.dispose();
               }
               else
               {
                   count--;
                   warning.setText("you have "+count+" chances left");
               }
        });
        
        setLayout(null);
        setVisible(true);
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class bank
{
    int i;
    ArrayList<account>customers=new ArrayList<>(); 
    bank() throws Exception
    {
        this.open();
//        customers[0]=new account("James",96385,85214,"1234567890",843256);
//        customers[1]=new account("John",28904,42269,"1761038383",142546);
//        customers[2]=new account("Robert",69129,83070,"2023680792",796519);
//        customers[3]=new account("Mary",76913,35751,"959689955",959419);
//        customers[4]=new account("Patricia",10524,90470,"1401773919",617120);
//        customers[5]=new account("Jennifer",64927,42215,"862600682", 23744);
    }
    private void open() throws Exception
    {
        File myfile=new File("accounts.txt");
        Scanner file=new Scanner(myfile);
        while(file.hasNextLine())
        {
            String name=file.nextLine();
            int acc_num= Integer. parseInt(file.nextLine());
            int password= Integer. parseInt(file.nextLine());
            String phone=file.nextLine();
            int balance= Integer. parseInt(file.nextLine());
            customers.add(new account(name,acc_num,password,phone,balance));
        }
    }
    boolean check(int accountnum,int password)
    {
        for(i=0;i<customers.size();i++)
        {
            if(customers.get(i).check_account_number(accountnum))
            {
                if(customers.get(i).check_password(password))
                {
                    return true;
                }
            }
        }
        return false;
    }
    int deposit(int amount,int i)
    {
        if(amount%100==0)
        {
            customers.get(i).deposit(amount);
            return 0;
        }
        return -1;
    }
    int withdraw(int amount,int i)
    {
        if(amount%100==0)
        {
            customers.get(i).withdraw(amount);
            return 0;
        }
        return -1;
    }
    boolean withdraw(int amount,int i,int a)
    {
        return customers.get(i).withdraw(amount);
    }
    int find_account(int accountnum)
    {
        for(i=0;i<customers.size();i++)
        {
            if(customers.get(i).check_account_number(accountnum))
            {
                return i;
            }
        }
        return -1;
    }
    String get_name(int i)
    {
        return customers.get(i).get_name();
    }
    String get_phone(int i)
    {
        return customers.get(i).get_phone();
    }
    int get_balance(int i)
    {
        return customers.get(i).get_balance();
    }
    int get_account(int i)
    {
        return customers.get(i).get_account();
    }
    
    void block(int i) throws IOException
    {
        customers.remove(i);
        this.close();
    }
    
    void close() throws IOException {
        FileWriter myWriter = new FileWriter("accounts.txt");
        for (int i = 0; i < customers.size(); i++) { 
  
            myWriter.write(customers.get(i).get_name()+"\n");
            myWriter.write(customers.get(i).get_account()+"\n");
            myWriter.write(customers.get(i).get_pass()+"\n");
            myWriter.write(customers.get(i).get_phone()+"\n");
            if(i+1!=customers.size())
            myWriter.write(customers.get(i).get_balance()+"\n");
            else
                myWriter.write(customers.get(i).get_balance()+"\n");
        } 
        myWriter.close();
    }
}

class account
{
    private final String name;
    private final int account_number;
    private final int password;
    private final String phone_number;
    private int balance;
    
    account(String name,int acc_num,int password,String phone,int balance)
    {
        this.name=name;
        this.account_number=acc_num;
        this.password=password;
        this.phone_number=phone;
        this.balance=balance;
    }
    
    boolean check_password(int pass)
    {
        return pass==password;
    }
    boolean check_account_number(int num)
    {
        return num==account_number;
    }
    int get_balance()
    {
        return balance;
    }
    String get_name()
    {
        return name;
    }
    int get_account()
    {
        return account_number;
    }
    String get_phone()
    {
        return phone_number;
    }
    int get_pass()
    {
        return password;
    }
    boolean withdraw(int cash)
    {
        if(cash+1000>balance)
        {
            System.out.println("Not enough cash");
            return false;
        }
        else
        {
            balance-=cash;
            return true;
        }
    }
    void deposit(int amount)
    {
        balance+=amount;
    }
}
