import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginForm {
	public static void main(String[] args) throws IOException {
		validateLogin();
	}

	public static String validateEmail() throws IOException {

		System.out.println("Please enter your email:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String email = reader.readLine();

		String regex = "^(.+)@(.+).([a-z])$";

		Pattern pattern = Pattern.compile(regex);

		Matcher matcher = pattern.matcher(email);
		boolean isEmailValid = matcher.matches();
		if (!isEmailValid) {
			System.out.println(email
					+ " is not valid email format. Please try again");
			validateEmail();
		}
		return email;
	}

	private static String validatePassword() throws IOException {

		System.out.println("Please enter your password:");
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String password = reader.readLine();
		String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		boolean isPasswordValid = matcher.matches();
		if (!isPasswordValid) {
			System.out
					.println(password
							+ " is not valid password. Password should contain at least one upper case, lower case, number and character. Please try again");
			validatePassword();
		}
		return password;
	}

	private static void validateLogin() throws IOException {
		boolean isLoginSuccess = false;
		String username = validateEmail();
		String pwd = validatePassword();
		HashMap<String, String> cred = new HashMap<String, String>();

		// Add keys and values (Username, Password)
		cred.put("nona@gmail.com", "Qw123456$");
		cred.put("example@mail.ru", "Aa123456#");
		cred.put("test@yahoo.com", "password&");
		cred.put("hr@info.am", "Z123456A*");

		for (String i : cred.keySet()) {
			if (username.equals(i) && pwd.equals(cred.get(i))) {
				isLoginSuccess = true;
			}
		}

		if (isLoginSuccess) {
			System.out.println("You are successfully loged in");
		} else {
			System.out.println("Incorrect email or password");
			validateLogin();
		}
	}
}