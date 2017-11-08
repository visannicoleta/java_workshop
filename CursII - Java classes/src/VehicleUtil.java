
public class VehicleUtil {
	//clasa helper - UTIL
	
	public static String generateNumberPlate(){
		
		return "B - " + String.valueOf(Math.random()*10000).substring(0,4);
	}
	
}
