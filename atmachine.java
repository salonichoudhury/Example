//atm system
import java.util.Scanner;

class bankaccount
{
	String name;
	String userName;
	String password;
	String accountno;
	float balance=100000f;
	int transaction=0;
	String transactionhistory="";
	
	public void register()
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("\nenter your name: ");
		this.name=sc.nextLine();
		System.out.print("\nenter your username: ");
		this.userName=sc.nextLine();
		System.out.print("\nenter your password: ");
		this.password=sc.nextLine();
		System.out.print("\n enter your account number: ");
		this.accountno=sc.nextLine();
		System.out.print("registation completed ..kindly login ");
	}
	public boolean login()
	{
		boolean islogin=false;
		Scanner sc=new Scanner(System.in);
		while(!islogin)
		{
			System.out.print("\nenter your username: ");
			String username=sc.nextLine();
			if(username.equals(userName))
			{
				while(!islogin)
				{
					System.out.print("\nenter your password: ");
					String Password=sc.nextLine();
					if(Password.equals(password))
					{
						System.out.print("\nlogin successfully!!");
						islogin=true;
					}
					else
					{
						System.out.println("incorrect password");
					}
				}
			}
			else{
				System.out.println("\n user name not found");
			}
		}
		return islogin;
	}
	public void withdraw()
	{
		System.out.println("\n enter the amount to withdraw-");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try{
			if (balance>=amount)
			{
				transaction++;
				balance -= amount;
				System.out.println("\n withdraw successfully!");
				String str=amount +"Rs withdrawed\n";
				transactionhistory=transactionhistory.concat(str);
			}
			else{
				System.out.println("\n insufficient balance");
			}
		}
		catch(Exception e){
		}
	}
	public void deposite()
	{
		System.out.println("\n Enter amount to deposite");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try{
			if (amount<=100000f)
			{
				transaction++;
				balance+=amount;
				System.out.println("\n successfully deposited!");
				String str=amount +"deposited\n";
			}
			else{
				System.out.println("\n sorry limit is 100000.00!");
			}
		}
		catch(Exception e){
		}
	}
	public void transfer()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\n enter receipents name-");
		String receipent=sc.nextLine();
		System.out.println("\n enter amount to transfer");
		float amount=sc.nextFloat();
		try{
			if(balance>=amount)
			{
				if(amount<=50000f)
				{
					transaction++;
					balance -=amount;
					System.out.println("\n successfully transfered");
					String str=amount +"transfered to"+receipent +"\n";
					transactionhistory=transactionhistory.concat(str);
				}
				else{
					System.out.println("\n sorry limit is 50000.00!");
				}
			}
			else{
				System.out.println("\n ensufficient balance");
			}
		}
		catch(Exception e){
		}
	}
	public void checkbalance()
	{
		System.out.println("\n" +balance +"Rs");
	}
	public void transhistory()
	{
		if(transaction==0)
		{
			System.out.println("\n empty");
		}
		else{
			System.out.println("\n" +transactionhistory);
		}
	}
}
public class atmachine
{
	public static int takeIntegerInput(int limit)
	{
		int input=0;
		boolean flag=false;
		
		while(!flag)
		{
			try{
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				
				if(flag && input > limit || input<1)
				{
					System.out.println("\n choose a number between 1 to "+limit);
					flag=false;
				}
			}		
			catch(Exception e)
			{
				System.out.println("\n enter only interger value");
				flag=false;
			}
		}
		return input;
	}
	public static void main(String[] args)
	{
		System.out.println("\n **************WELCOME TO ATM SYSTEM****************");
		System.out.println("1.Register \n 2.exit");
		System.out.println("\n enter your choice-");
		int choice=takeIntegerInput(2);
		
		if (choice==1)
		{
			bankaccount b=new bankaccount();
			b.register();
			while(true)
			{
				System.out.println("1.Login \n 2.exit");
				System.out.println("enter your choice-");
				int ch=takeIntegerInput(2);
				if(ch==1)
				{
					if(b.login())
					{
						System.out.println("\n\n************WELCOME BACK" +b.name +"**************\n");
						boolean isFinished=false;
						while(!isFinished)
						{
							System.out.println("\n1.withdraw \n2.deposite \n3.transfer \n4.check balance \n5.transactionhistory \n6.exit");
							System.out.println("\n enter your choice-");
							int c=takeIntegerInput(6);
							switch(c)
							{
								case 1:
								b.withdraw();
								break;
								case 2:
								b.deposite();
								break;
								case 3:
								b.transfer();
								break;
								case 4:
								b.checkbalance();
								break;
								case 5:
								b.transhistory();
								break;
								case 6:
								System.out.println("Please enter your correct choice");
								break;
							}
						}
					}
				}
				else{
					System.exit(0);
				}
			}
		}
		else{
			System.exit(0);
		}
	}
}

