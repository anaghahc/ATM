import java.util.*;

class user {
    int balance;
    String name;
    String password;
    long account;
}

public class atm {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<user> obj = new ArrayList<user>();
        while (true) {
            System.out.println("Enter 1 for admin or 2 for customer or 0 to exit");

            int choice = Integer.parseInt(in.nextLine());
            if (choice == 0)
                System.exit(0);
            switch (choice) {
                
                case 1:             //admin page
                    int flag=-1;
                    user user = new user();
                    System.out.println("Enter new customer details");
                    System.out.println("Enter name");
                    user.name = in.nextLine();
                    System.out.println("Enter account number");
                    Long temp= Long.parseLong(in.nextLine());
                    for (int i = 0; i < obj.size(); i++) {
                        if( temp == obj.get(i).account){
                            System.out.println("Account number already exists!");
                            flag=1;
                            break;
                        }
                    }
                    if(flag == -1){
                    user.account = temp;
                    System.out.println("Set password");
                    user.password = in.nextLine();
                    System.out.println("Enter balance");
                    user.balance = Integer.parseInt(in.nextLine());
                    obj.add(user);                    
                    }
                    break;

                case 2:             //user page
                    System.out.println("Enter customer account number");
                    long account1 = Long.parseLong(in.nextLine());
                    System.out.println("Enter password");
                    String pass1 = in.nextLine();
                    for (int i = 0; i < obj.size(); i++) {
                        if (account1 == obj.get(i).account     &&   pass1.equals(obj.get(i).password)) {    //password validation
                            System.out.println("Welcome " + obj.get(i).name);
                            System.out.println("***************************************");

                            System.out.println("Enter 1 for new transaction or 2 for withdrawal or 3 for mini statement ");
                            int ch = Integer.parseInt(in.nextLine());

                            switch (ch) {
                                case 1:
                                    System.out.println("Enter account number to be transferred to");     //new transaction
                                    Long account2 = Long.parseLong(in.nextLine());
                                    for (int j = 0; j < obj.size(); j++) {
                                        if (account2 == obj.get(j).account) {
                                            System.out.println("Enter amount to be tranferred");
                                            int amount = Integer.parseInt(in.nextLine());
                                            obj.get(j).balance += amount;
                                            obj.get(i).balance -= amount;
                                            System.out.println("Successful!\nNew balance :" + obj.get(i).balance);
                                            System.out.println("***************************************");
                                            break;
                                        }
                                    }
                                    break;

                                case 2:
                                    System.out.println("Enter amount to be withdrawn");         //withdrawal
                                    int amount1 = Integer.parseInt(in.nextLine());

                                    {
                                    if (amount1 <= obj.get(i).balance) {
                                        obj.get(i).balance -= amount1;
                                        System.out.println("Successful\nNew balance :" + obj.get(i).balance);
                                        System.out.println("***************************************");
                                    }

                                    else 
                                        System.out.println("Not enough balance!");
                                }

                                    break;

                                case 3:
                                    System.out.println("Account statement:");
                                    System.out.println("Name: " + obj.get(i).name);
                                    System.out.println("Balance: " + obj.get(i).balance);
                                    break;

                                    default:
                                    System.out.println("Invalid option");
                                    break;

                            }
                            System.out.println("Successfully logged out!");
                            System.out.println("***************************************");
                            break;
                        }

                        else
                        System.out.println("Wrong password or account number");

                    }
                    break;
                    default:
                              System.out.println("Invalid option");
                              break;
                    

            }

        }

    }

}
