
public class MainApp {

	public static void main(String[] args) {
		
//		Vehicle vehicle = new Vehicle (2,2,"Blue",4,2);
//		
//		vehicle.numberOfPass = 4;
//		vehicle.seats = 2;
//		vehicle.weight = 2;
//		vehicle.numberOfWheels = 2;
//		vehicle.color = "Blue";
//		
//		vehicle.Start();
//		vehicle.Stop();
		
		//polimorfism
		//Late biding - imi apeleaza metodele din AutoVehicle, desi este de tip Vehicle
		Vehicle auto = new AutoVehicle(4, 2, "Red", 5, 3, 100, "GPL", "Dacia", "1310");
		auto.start();
		auto.stop();
		
		AutoVehicle auto2 = new AutoVehicle(4, 2, "Red", 5, 3, 100, "GPL", "Dacia", "1310");
		auto2.start();
		auto2.stop();
		
		auto.toString();
		
		auto.setNumberPlate(VehicleUtil.generateNumberPlate());
		System.out.println(auto.getNumberPlate());

		
	}

}
