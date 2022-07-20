package commonprocess.formatchecksub;

import commonprocess.FormatCheck;

public class HarfWidthAlphanumFormatCheck extends FormatCheck{
	public HarfWidthAlphanumFormatCheck() {
		super("^[0-9A-Za-z]+$");
	}
}
