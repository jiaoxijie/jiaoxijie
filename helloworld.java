package helloworld;
import java.util.Scanner;

public class helloworld {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Helloworld();
	}
	
    public static String Helloworld()
	{
		Scanner in = new Scanner(System.in);
		int i,n;
		n = in.nextInt();
		for(i=0; i<n; i++)
		{
			if(i % 2 == 0)
				System.out.println("helloworld");
			else 
				System.out.println("hellojava");
		}
		return null;
	}
}
/*public class helloworld {
	public static String main() {
		// TODO Auto-generated method stub
		return("helloworld_1");
	}
}

class add_helloworld
{
	public static String main() {
		// TODO Auto-generated method stub
		return("helloworld");
	}
}
*/