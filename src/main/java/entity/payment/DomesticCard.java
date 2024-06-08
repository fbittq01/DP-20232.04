package entity.payment;

/**
 * @author
 */
public class DomesticCard {

    private String issuingBank;
    private String validFromDate;

    public DomesticCard(String cardCode, String owner, String issuingBank, String validFromDate) {
        super(cardCode, owner);
        this.issuingBank = issuingBank;
        this.validFromDate = validFromDate;
    }
}