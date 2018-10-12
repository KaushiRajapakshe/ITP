package itp.java.payment;

public class PaymentFactory extends AbstractFactory{

		@Override
		public Payment getPay(String type) {
			
			if(type == null){
				return null;
			}
			else if(type.equalsIgnoreCase("CASH")){
				return new Cash();
			}
			else if(type.equalsIgnoreCase("CHEQUE")){
				return new Cheque();
			}
			else{
				return null;
			}
		}	

}
