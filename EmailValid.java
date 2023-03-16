import java.net.URL;
import java.util.ArrayList;

public class EmailValid {
    ArrayList<String> nameDomain = new ArrayList<String>();

    private void initNameDomain() {
        nameDomain.add("gmail.com");
        nameDomain.add("mail.ru");
    }

    // implements mail validation
    public boolean validEmail(String email) {
        initNameDomain();
        try {
            if (!isHaveUniqAt(email)) {
                throw new Exception("Noտ '@' or double '@");
            } else if (!isCorrectionDomain(email)) {
                throw new Exception("Not fund Domain");
            } else if (!isCorrectionLocalArea(email)) {
                throw new Exception("Sintax error in local area");
            }
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // checks wether the symbol "@" unique
    private boolean isHaveUniqAt(String email) {
        if (email.contains("@")) {
            return (email.lastIndexOf('@') == email.indexOf('@'));
        }
        return false;
    }

    // checks domain coresspondance
    private boolean isCorrectionDomain(String email) {
        int indexAt = email.indexOf("@");

        for (int i = 0; i < nameDomain.size(); ++i) {
            if (email.regionMatches(false, indexAt + 1, nameDomain.get(i), 0, nameDomain.get(i).length() - 1)) {
                return true;
            }
        }
        return false;
    }

    // checks local syntax (until "@")
    private boolean isCorrectionLocalArea(String email) {
        email = email.substring(0, email.indexOf('@'));
        for (int i = 0; i < email.length(); ++i) {
            if (!isRightSintaxChar(email.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    // specifically checks characters' coresspondance
    boolean isRightSintaxChar(char ch) {
        if (ch == '!' || (ch >= '#' && ch <= 39) || ch == '*' || ch == '+' || (ch >= '-' && ch < '9') || ch == '='
                || ch == '?' || (ch >= 'A' && ch <= 'Z') | (ch >= 'a' && ch <= 'z') || ch == '^' || ch == '_'
                || ch == '`'
                || (ch >= '{' && ch <= '~')) {
            return true;
        }
        return false;
    }

}
