package commonprocess.formatchecksub;

import commonprocess.FormatCheck;

public class MailFormatCheck extends FormatCheck {

	public MailFormatCheck() {
		super("^(([0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+(\\.[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+)*)|(\"[^\"]*\"))"
                + "@[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+"
                + "(\\.[0-9a-zA-Z!#\\$%&'\\*\\+\\-/=\\?\\^_`\\{\\}\\|~]+)*$");
	}

}
