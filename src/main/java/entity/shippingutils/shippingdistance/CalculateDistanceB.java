package entity.shippingutils.shippingdistance;
import org.example.AlternativeDistanceCalculator;

public class CalculateDistanceB implements CalculatingDistance{
    public static int calculateDistance(String address, String province) {
        AlternativeDistanceCalculator alternativeDistanceCalculator = new AlternativeDistanceCalculator();
        int distance = alternativeDistanceCalculator.calculateAlternativeDistance(address, province);
        return distance;
    }
}