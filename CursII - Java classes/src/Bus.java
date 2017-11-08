
public class Bus extends AutoVehicle implements PublicTransportation, PassengerSeats{

	public Bus(int numberOfWheels, int weight, String color, int numberOfPass, int seats, int hp, String fuel,
			String brand, String model) {
		super(numberOfWheels, weight, color, numberOfPass, seats, hp, fuel, brand, model);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getNumberOfSeatsForPassengers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void chargeTicket() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
