package Coins;

import java.util.HashMap;//散列表
import java.util.Scanner;
public class Coin {
  private HashMap<Integer,String> coinnames = new HashMap<Integer,String>();
  public Coin() {  // coin 构造器
//	  coinnames.put(key,value);
	  coinnames.put(1, "penny");
	  coinnames.put(2, "peny");
	  coinnames.put(3, "pny");
	  System.out.println(coinnames.keySet().size());
	  System.out.println(coinnames);
	
  }
  public String getName(int amount) {
	  return coinnames.get(amount);
  }
  public static void main(String[] args) {
	  Scanner in = new Scanner(System.in);
	  int amount = in.nextInt();
	  Coin coin = new Coin();
	  String name = coin.getName(amount);
	  System.out.println(name);
	  in.close();
  }
}
