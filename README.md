ATM-Case Study 2

About

1)The software has a User Friendly GUI for easy use of the software
2)There are two main classes (bank & account).There are five more classes two show different frames for login(written with name atm),menu(it has withdraw,deposit,show balance options),withdraw,deposit ,show,otp,helper(block card) and transfer.
3)Most of the variables are declared with keywords private and final for extra safety
4)It is made sure that there is an override to cancel the transaction by user at any stage of the transaction.
5)The software is created with the assumption that least denomination that atm has is 100 INR
6)There are five chances given to the user for entering the correct password before the whole program closes for safety
7)Password text field is made using JPassword instead of JTextField so that other users can not see from behind
8)It is made sure that the software will not change any of the banks information by mistake using the keyword final
9)Each of the GUI class is an extension of the class JFrame there by implementing inheritance.Abstraction and encapsulation are achieved through GUI i.e user need not concern themself with implementation of the program
10)Action Listeners for buttons is implemented using lambda function(a advanced feature in new releases of java jdk to replace anonymous object(inner class concept)
11)It has two layer prtection password+otp type protection

Test Cases

Once you run the program you will see the login page.Once you enter the pre registered account number and password it will show the menu window

Input ->5 digit account number and password
for testing you can enter accno 96385 and pass 85214

It will show you three options namely withdraw,deposit and see balance
There is option to exit the transaction safely with exit transaction button at the bottom left corner

Case i	(you chose show balance)

It will show your Registered name,account number,balance and Registered phone number

Case ii	(you chose  deposit money)

It will direct you to deposit window where you have to enter the amount of money you want to deposit.Once the deposit is complete it will show you your balance.if you enter an invalid input that is if it is not possible to make with least denomination it will show a warning message

Case iii(you chose withdraw money)

It will direct you to withdraw window where you have to enter the amount of money you want to withdraw.Once the deposit is complete it will show you your balance.if you enter an invalid input that is if it is not possible to make with least denomination it will show a warning message.It will show warning message even when you do not have enough cash in your account or if there isn’t enough cash in the atm.In all these cases appropriate warning message is shown  

case iv (block the card)

you can enter the time after which you want to block or it will block the account instantaniously 

case v(account to account transfer)

you should enter the account number ,ifsc code and amount you want to send
