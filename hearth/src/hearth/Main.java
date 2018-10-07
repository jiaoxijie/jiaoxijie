package hearth;


import java.util.Scanner;


public class Main {
	
	public static class Player{
		
		int [] Summon = new int [8];
	    int hero;
	    int [] Attack = new int [8];
	    int num;
	    
	    public void attack(int thisSide, int attack)
	    {
	    	Summon[thisSide] -= attack;
	    }
	    
	    public void Print() {
			
			int j;
			System.out.print(hero);
			System.out.print('\n');
			System.out.print(num);
			System.out.print(' ');
			for(j=1; j<=num; j++)
			{
				System.out.print(Summon[j]);
				System.out.print(' ');
			}
		}
	    
	    public void InsertSummon(int health, int attack, int i) { 
	    	
	    	int j;
	    	num++;
	    	for(j=num; j>i; j--)
			{
				Summon[j] = Summon[j-1];
				Attack[j] = Attack[j-1];
			}
			Summon[i] = health;
			Attack[i] = attack;
	    }
	    
	    public void DeleteSummon(int i) {
	    	int j;
	    	for(j=i; j<=num; j++)
			{
				Summon[j] = Summon[j+1];
				Attack[j] = Attack[j+1];
			}
	    }
	}
	
	public static class Offensive extends Player{
		
	    public Offensive() {
	    	hero = 30;
	    	num = 0;
	    }
	}
	
	public static class Defensive extends Player{

		public Defensive() {
	    	hero = 30;
	    	num = 0;
	    }
	}

	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		Offensive player_1 = new Offensive();
		Defensive player_2 = new Defensive();
		int flag = 1;
		int n;
		n = in.nextInt();
		String s;
		int i;
		int position, attack, health;
		int attacker, defender;
		for(i=0; i<n; i++)
		{
			s = in.next();
			switch(s)
			{
			case "summon":
				position = in.nextInt();
				attack = in.nextInt();
				health = in.nextInt();
				if(flag == 1)
					player_1.InsertSummon(health, attack, position);
				else
					player_2.InsertSummon(health, attack, position);
				break;
				
			case "attack":
				attacker = in.nextInt();
				defender = in.nextInt();
				System.out.print("What do you want to do, fight or run?");
				s = in.next();
				if(s == "fight")
				{
					if(flag == 1)
					{
						if(defender!=0)
						{
							player_1.attack(attacker, player_2.Attack[defender]);
							player_2.attack(defender, player_1.Attack[attacker]);
							if(player_2.Summon[defender] <= 0)
							{
								player_2.num--;
								player_2.DeleteSummon(defender);
							}
							if(player_1.Summon[attacker] <= 0)
							{
								player_1.num--;
								player_1.DeleteSummon(attacker);
							}
						}
						else
						{
							player_2.hero -= player_1.Attack[attacker];
							if(player_2.hero <= 0)
							{
								System.out.print("1");
								System.out.print("\n");
								player_1.Print();
								System.out.print("\n");
								player_2.Print();
								return;
							}
						}
					}
					if(flag == -1)
					{
						if(defender!=0)
						{
							player_1.Summon[defender] -= player_2.Attack[attacker];
							player_2.Summon[attacker] -= player_1.Attack[defender];
							if(player_1.Summon[defender] <= 0)
							{
								player_1.num--;
								player_1.DeleteSummon(defender);
							}
							if(player_2.Summon[attacker] <= 0)
							{
								player_2.num--;
								player_2.DeleteSummon(attacker);
							}
						}
						else
						{
							player_1.hero -= player_2.Attack[attacker];
							if(player_1.hero <= 0)
							{
								System.out.print("-1");
								System.out.print("\n");
								player_1.Print();
								System.out.print("\n");
								player_2.Print();
								return;
							}
						}
					}
				}
				else
				{
					if(flag == 1)
					{
						player_2.hero -= 5;
						player_2.Summon[defender] -= 2;
						player_2.Attack[attacker] += 1;
					}
					else
					{
						player_1.hero -= 5;
						player_1.Summon[defender] -= 2;
						player_1.Attack[attacker] += 1;
					}
				}
				break;
				
			case "end":
				flag *= -1;
				break;
			}
		}
		System.out.print("0");
		System.out.print("\n");
		player_1.Print();
		System.out.print("\n");
		player_2.Print();
		return;
	}
}