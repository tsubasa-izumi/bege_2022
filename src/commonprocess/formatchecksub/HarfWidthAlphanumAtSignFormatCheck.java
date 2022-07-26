package commonprocess.formatchecksub;

import commonprocess.FormatCheck;

public class HarfWidthAlphanumAtSignFormatCheck extends FormatCheck{
	public HarfWidthAlphanumAtSignFormatCheck() {
		super("^[0-9A-Za-z@._-]+$");
	}
}
