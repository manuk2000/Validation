import java.util.ArrayList;

public class PhoneNumberValid {
    // Checks a phonenumber's Validation

    String armenianReginCodePhone = "374";

    ArrayList<String> ArmeniaCodePhone = new ArrayList<String>();

    void addArmeniaCodePhone() {
        ArmeniaCodePhone.add("99");
        ArmeniaCodePhone.add("98");
        ArmeniaCodePhone.add("77");
        ArmeniaCodePhone.add("55");
        ArmeniaCodePhone.add("35");
        ArmeniaCodePhone.add("94");
        ArmeniaCodePhone.add("93");
        ArmeniaCodePhone.add("97");
    }

    ArrayList<String> formatPhoneNumber = new ArrayList<String>();

    void addFormatPhoneNumber() {
        formatPhoneNumber.add("\\d{8}");
        formatPhoneNumber.add("\\d{2} \\d{3} \\d{3}");
        formatPhoneNumber.add("\\d{2}-\\d{3}-\\d{3}");
        formatPhoneNumber.add("\\d{2} \\d{2} \\d{2} \\d{2}");
        formatPhoneNumber.add("\\d{2}-\\d{2}-\\d{2}-\\d{2}");
    }

    // inputs a phonenumber
    // precondition 1 - symbols of seperation are space and "-" signs
    // precondition 2 - first seperation symbol must be after RegionCodePhone
    // precondition 3 - separations signs may be two or three, but they can't be
    // different( eather "-" or "space")
    // in that is a phonenumber or not
    public boolean phoneNumberValid(String phone) {
        addFormatPhoneNumber();
        addArmeniaCodePhone();
        System.out.println(ArmeniaCodePhone.get(0));
        phone = phone.trim();
        if (phone.startsWith(armenianReginCodePhone)) {
            phone = "+" + phone;
        }
        if (phone.charAt(0) == '0') {
            return isInvalitSimboles(phone.substring(1)) && isTrueTypeFhone(phone.substring(1))
                    && isArmenianRegionCode(phone.substring(1));

        } else if (phone.startsWith("+374")) {
            return isInvalitSimboles(phone.substring(4)) &&
             isTrueTypeFhone(phone.substring(4))
                    && isArmenianRegionCode(phone.substring(4));

        } else
            return false;
    }

    // in the symbol is a number or not
    private boolean isNumber(char ch) {
        return (ch >= '0' && ch <= '9');
    }

    // in that's an Armenian phonenumber or not
    private boolean isArmenianRegionCode(String phoneRegionCode) {
        for (int i = 0; i < ArmeniaCodePhone.size(); ++i) {
            if (phoneRegionCode.startsWith(ArmeniaCodePhone.get(i))) {
                return true;
            }
        }
        return false;

    }

    // in phone number's syntax
    private boolean isTrueTypeFhone(String phone) {
        for (int i = 0; i < formatPhoneNumber.size(); ++i) {
            if (phone.matches(formatPhoneNumber.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean isInvalitSimboles(String phone) {
        phone = phone.replaceAll("[ -]", "");
        for (int i = 0; i < phone.length(); ++i) {
            if (isNumber(phone.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
