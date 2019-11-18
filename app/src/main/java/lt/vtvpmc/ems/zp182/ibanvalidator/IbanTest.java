package lt.vtvpmc.ems.zp182.ibanvalidator;

import java.math.BigInteger;

class IbanTest {

    public static final int IBANNUMBER_MIN_SIZE = 15;
    public static final int IBANNUMBER_MAX_SIZE = 34;
    public final BigInteger IBANNUMBER_MAGIC_NUMBER = new BigInteger("97");

    public boolean Iban(String userInputValue) {
        String newAccountNumber = userInputValue.trim();

        if (newAccountNumber.length() < IBANNUMBER_MIN_SIZE || newAccountNumber.length() > IBANNUMBER_MAX_SIZE) {
            return false;
        }

        newAccountNumber = newAccountNumber.substring(4) + newAccountNumber.substring(0, 4);

        StringBuilder numericAccountNumber = new StringBuilder();
        int numericValue;
        for (int i = 0; i < newAccountNumber.length(); i++) {
            numericValue = Character.getNumericValue(newAccountNumber.charAt(i));
            if (-1 >= numericValue) {
                return false;
            } else {
                numericAccountNumber.append(numericValue);
            }
        }

        BigInteger ibanNumber = new BigInteger(numericAccountNumber.toString());
        return ibanNumber.mod(IBANNUMBER_MAGIC_NUMBER).intValue() == 1;

    }
}
