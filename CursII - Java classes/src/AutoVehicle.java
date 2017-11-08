
public class AutoVehicle extends Vehicle {

	public AutoVehicle(int numberOfWheels, int weight, String color, int numberOfPass, int seats,
			int hp, String fuel, String brand, String model) {
		super(numberOfWheels, weight, color, numberOfPass, seats);
		this.hp = hp;
		this.fuelType = fuel;
		this.brand = brand;
		this.model = model;	
	}
	
	int hp; //horse power
	String fuelType;
	String brand;
	String model;
	
	@Override
	void start(){
		System.out.println("AutoVehicle - start");
	}
	
	@Override
	void stop(){
		System.out.println("AutoVehicle - stop");
	}
	
	
	@Override
	public String toString() {
		System.out.println("AutoVehicle [hp=" + hp + ", fuelType=" + fuelType + ", brand=" + brand + ", model=" + model
				+ ", numberOfWheels=" + numberOfWheels + ", weight=" + weight + ", color=" + color + ", numberOfPass="
				+ numberOfPass + ", seats=" + seats + "]");
		return "AutoVehicle [hp=" + hp + ", fuelType=" + fuelType + ", brand=" + brand + ", model=" + model
				+ ", numberOfWheels=" + numberOfWheels + ", weight=" + weight + ", color=" + color + ", numberOfPass="
				+ numberOfPass + ", seats=" + seats + "]";
	}
	
	
}
