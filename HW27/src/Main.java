import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {

    private static final String VALID_PATTERN_REGEX = "^[a-zA-Z0-9_]+$";

    public static void main(String[] args) {
        try {
            System.out.println(confirmPassword("alehфф", "qwZX12_", "qwZX12_" ));
        } catch (WrongLoginException e) {
            System.out.println(e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

    }

    public static boolean confirmPassword(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (validateLoginPassword(login)) {
            throw new WrongLoginException("\"Login is incorrect\"");
        }
        if ((validateLoginPassword(password)) || (!password.equals(confirmPassword))) {
            throw new WrongPasswordException("\"Password is incorrect\"");
        }
        return true;
    }

    public static boolean validateLoginPassword(String loginPassword) {
        return !loginPassword.matches(VALID_PATTERN_REGEX) || loginPassword.length() >= 20;
    }
}