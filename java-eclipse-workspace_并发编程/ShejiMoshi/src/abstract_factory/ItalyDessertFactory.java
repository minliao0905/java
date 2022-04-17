package abstract_factory;

public class ItalyDessertFactory implements DessertFactory{
 
	public coffee createcoffee() {
	 return new LatteCoffee();
 }

     @Override
   public Dessert createDessert() {
 	return  new Trimisu();
   }
 
}
