
public abstract class Vehicle {
	
	public Vehicle(int numberOfWheels, int weight, String color, int numberOfPass, int seats) {
		super();
		this.numberOfWheels = numberOfWheels;
		this.weight = weight;
		this.color = color;
		this.numberOfPass = numberOfPass;
		this.seats = seats;
	}

	int numberOfWheels;
	int weight;
	String color;
	int numberOfPass;
	int seats;
	private String numberPlate;
	
	
	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	//abstract method - force sub-classes to implement this method
	abstract void start();
//	{
//		System.out.println("Vehicle with numberOfPassengers = " + this.numberOfPass +" is starting !");
//	} 
	
	void stop (){
		System.out.println("Vehicle is stoping !");
	}

	public int getNumberOfWheels() {
		return numberOfWheels;
	}

	public int getWeight() {
		return weight;
	}

	public String getColor() {
		return color;
	}

	public int getNumberOfPass() {
		return numberOfPass;
	}

	public int getSeats() {
		return seats;
	}
	
	//static methods - can be used without having an object, can be called using the class

}
