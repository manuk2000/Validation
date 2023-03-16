import java.time.LocalDate;

public class DateValid {
    LocalDate localDateString = LocalDate.now();

    int minDate = 1900;

    // option for the first

    // format date "2000-08-08"
    // Obtains an instance of LocalDate from a text string using a specific
    // formatter.
    // The text is parsed using the formatter, returning a date.

    // Parameters:
    // text - the text to parse, not null
    // formatter - the formatter to use, not null
    // Returns:
    // the parsed local date, not null

    // try{
    // localDateString = LocalDate.parse(date);
    // return true;
    // }catch(Exception e){
    // System.out.println(e);
    // return false;
    // }

    // option for the second

    public boolean dateValid(String date) {

        if (date == null) {
            return false;
        }
        int localDate = Integer.parseInt(String.valueOf(localDateString).substring(0, 4));
        System.out.println(localDate);
        String[] str = date.split("-");
        int year = Integer.parseUnsignedInt(str[0]);
        int amis = Integer.parseUnsignedInt(str[1]);
        int day = Integer.parseUnsignedInt(str[2]);

        if (year < minDate || year > localDate) {
            return false;
        }
        boolean condination = switch (amis) {
            case 1, 3, 5, 7, 8, 10, 12 -> (day <= 31 && day > 0);
            case 4, 6, 9, 11 -> (day <= 30 && day > 0);
            case 2 -> (year % 4 == 0) ? (day <= 29 && day > 0) : (day <= 38 && day > 0);
            default -> false;
        };
        return condination;
    }
}
