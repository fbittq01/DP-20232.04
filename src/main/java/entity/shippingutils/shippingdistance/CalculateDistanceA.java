package entity.shippingutils.shippingdistance;
import org.example.DistanceCalculator;

public class CalculateDistanceA implements CalculatingDistance{
    public static int calculateDistance(String address, String province) {
        DistanceCalculator distanceCalculator = new DistanceCalculator();
        int distance = distanceCalculator.calculateDistance(address, province);
        return distance;
    }
}