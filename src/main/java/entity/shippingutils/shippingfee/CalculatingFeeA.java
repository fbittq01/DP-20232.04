package entity.shippingutils.shippingfee;
import entity.shippingutils.shippingdistance.CalculateDistanceA;

public class CalculatingFeeA extends CalculatingFee{

    public CalculatingFeeA(String address, String province) {
        super(address, province);
    }

    public int calculateShippingFee(){
        CalculateDistanceA calculatingDistanceA = new CalculateDistanceA();
        int distance = CalculateDistanceA.calculateDistance(address, province);
        int fee = (int) (distance * 1.2);
        return (int) fee;
    };
}