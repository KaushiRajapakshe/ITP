package itp.java.payment;

public class FactoryProducer {
	
	public static AbstractFactory getFactory(String choice){
		
		if(choice.equalsIgnoreCase("PAYMENT")){
			return new PaymentFactory();
		}
		else{
			return null;
		}
	}
}
