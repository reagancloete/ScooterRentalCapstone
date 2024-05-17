package za.ac.cput.factory;
//Luyolo Skoma
import za.ac.cput.domain.PaymentInfo;
import za.ac.cput.util.Helper;

public class PaymentInfoFactory {
    public static PaymentInfo createPaymentInfo(String rentalDuration, String insuranceFee, String rentalDescription, String scooterId) {
        if (Helper.isNullOrEmpty(rentalDuration) || Helper.isNullOrEmpty(insuranceFee) || Helper.isNullOrEmpty(rentalDescription) || Helper.isNullOrEmpty(scooterId)) {
            return null;
        }

        String paymentInfoId = Helper.generateId();

        return new PaymentInfo.Builder()
                .setPaymentInfoId(paymentInfoId)
                .setRentalDuration(rentalDuration)
                .setInsuranceFee(insuranceFee)
                .setRentalDescription(rentalDescription)
                .setScooterId(scooterId)
                .build();
    }
}
