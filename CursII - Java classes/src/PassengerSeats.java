
public interface PassengerSeats {

	//Incepand cu Java 8, pot implementa metoda in Interfata
	//Nu ma mai obliga sa o implementez in clasa, ia default implementarea din Interfata
	default int getNumberOfSeatsForPassengers(){
		return 0;
	}
	
	default void chargeTicket(){
		System.out.println("Default charge for ticket.");
	}
	
}
