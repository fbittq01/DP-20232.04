package entity.shippingutils.shippingfee;

public class CalculatingFee {
    private String address;
    private String province;

    public int calculateShippingFee(){

    };

    public CalculatingFee(String address, String province) {
        this.address = address;
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public setAddress(String address) {
        this.address = address;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}