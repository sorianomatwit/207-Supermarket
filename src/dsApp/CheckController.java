package dsApp;
import java.util.ArrayList;

public class CheckController {

	
	private static ArrayList<Integer> data;
	public static void main(String[] args) {


        
		data = new ArrayList<Integer>();
        for(int x = 0; x < 10;x++)
        {
            data.add(0);
        }

        double sum = 50;
        data = getChangeK(sum, data);


        for(int x = 0; x < data.size();x++)
        {
        	
            System.out.println(data.get(x));
        } 
        
    }
	
	private int hundredbill = data.get(0);
	private int fiftybill = data.get(1);
    private int twentybill = data.get(2);
    private int tenbill = data.get(3);
    private int fivebill = data.get(4);
    private int onebill = data.get(5);
    private int quartercoin = data.get(6);
    private int dimecoin = data.get(7);
    private int nickelcoin = data.get(8);
    private int pennycoin = data.get(9);
    
		public int getHundredBill()
		{
			return hundredbill;
		}
		public int getfiftybill()
		{
			return fiftybill;
		}
		public int gettwentybill()
		{
			return twentybill;
		}
		public int gettenbill()
		{
			return tenbill;
		}
		public int getfivebill()
		{
			return fivebill;
		}
		public int getonebill()
		{
			return onebill;
		}
		public int getquatercoin()
		{
			return quartercoin;
		}
		public int getdimecoin()
		{
			return dimecoin;
		}
		public int getnickelcoin()
		{
			return nickelcoin;
		}
		public int getpennycoin()
		{
			return pennycoin;
		}

    private static ArrayList<Integer> getChangeK(Double sum, ArrayList<Integer> data)
    {

        if(sum < 0.01)
            return data;

        if(sum >= 100)
        {
            data.set(0,(int)(sum/100));
            sum = sum % 100;
        }
        else if(sum >= 50)
        {
            data.set(1,(int)(sum/50));
            sum = sum % 50;
        }
        else if(sum >= 20)
        {
            data.set(2,(int)(sum/20));
            sum = sum % 20;
        }
        else if(sum >= 10)
        {
            data.set(3,(int)(sum/10));
            sum = sum % 10;
        }
        else if(sum >= 5)
        {
            data.set(4,(int)(sum/5));
            sum = sum % 5;
        }
        else if(sum >= 1)
        {
            data.set(5,(int)(sum/1));
            sum = sum % 1;
        }
        else if(sum >= 0.25)
        {
            data.set(6,(int)(sum/0.25));
            sum = sum % 0.25;
        }
        else if(sum >= 0.10)
        {
            data.set(7,(int)(sum/0.10));
            sum = sum % 0.10 ;
        }
        else if(sum >= 0.05)
        {
            data.set(8,(int)(sum/0.05));
            sum = sum % 0.05;
        }
        else if(sum >= 0.01)
        {
            data.set(9,(int)(sum/0.01));
            sum = sum % 0.01;
        }
        return getChangeK(sum, data);
    }
}

