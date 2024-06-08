package entity.shippingutils.shippingfee;
import entity.shippingutils.shippingdistance.CalculateDistanceB;
import entity.shippingutils.shippingdistance.CalculatingDistanceB;

public class CalculatingFeeB extends CalculatingFee{
    private String address;
    private String province;
    private int length;
    private int width;
    private int height;

    public CalculatingFeeB(String address, String province, int length, int width, int height) {
        this.address = address;
        this.province = province;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int calculateShippingFee(){
        CalculateDistanceB calculatingDistanceB = new CalculateDistanceB();
        int distance = CalculateDistanceB.calculateDistance(address, province);
        int bulkiness = calculateBulkiness();
        int fee = distance + bulkiness * 10;
    };

    private int calculateBulkiness() {
        return (int) length * width * height / 6000;
    }
}