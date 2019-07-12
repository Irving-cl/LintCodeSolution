
public class BinaryRepresentation {

    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
        double dbPart = Double.parseDouble(n.substring(n.indexOf('.')));
        String intstr = "";
        String dbstr = "";
        if (intPart == 0) intstr += '0';
        while (intPart > 0) {
            int c = intPart % 2;
            intstr = c + intstr;
            intPart = intPart / 2;
        }
        while (dbPart > 0.0) {
            if (dbstr.length() > 32) return "ERROR";
            double r = dbPart * 2;
            if (r >= 1.0) {
                dbstr += '1';
                dbPart = r - 1.0;
            } else {
                dbstr += '0';
                dbPart = r;
            }
        }
        return dbstr.length() > 0 ? intstr + "." + dbstr : intstr;
    }

    public static void main(String[] args) {

    }
}