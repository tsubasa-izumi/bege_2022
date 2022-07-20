package commonprocess;

public class LengthCheck {

	// メソッドの結果を示す。
	private boolean statusOK;


	/**
	 * このメソッドは呼び出し元のメソッドから渡されたパラメータに対して、最大入力桁数のチェックを行う。
	 * 真偽値を返す。
	 *
	 * @param checkParam チェックしたいパラメータ
	 * @param maxLengthSize チェックしたいパラメータの長さ
	 * @return
	 */
	public boolean isMaxStringLength(String checkParam, int maxLengthSize) {
		// 第一引数に対して、第二引数を用いて文字列の長さをチェックし、真偽値を返す。
		statusOK = true;

		int checkParamlength = checkParam.length();
		if (checkParamlength > maxLengthSize) {
			statusOK = false;
		}
		// trueは第一引数の文字列の長さが第二引数の長さ以下である事を示す。
		// falseは第一引数の文字列の長さが第二引数の長さ以下でない事を示す。
		return statusOK;
	}

	/**
	 * このメソッドは呼び出し元のメソッドから渡されたパラメータに対して、最低入力桁数のチェックを行う。
	 * 真偽値を返す。
	 *
	 * @param checkParam チェックしたいパラメータ
	 * @param minLengthSize チェックしたいパラメータの長さ
	 * @return
	 */
	public boolean isMinStringLength(String checkParam, int minLengthSize) {
		// 第一引数に対して、第二引数を用いて文字列の長さをチェックし、真偽値を返す。
		statusOK = true;

		int checkParamlength = String.valueOf(checkParam).length();
		if (checkParamlength < minLengthSize) {
			statusOK = false;
		}
		// trueは第一引数の文字列の長さが第二引数の長さ以上である事を示す。
		// falseは第一引数の文字列の長さが第二引数の長さ以上でない事を示す。
		return statusOK;
	}
}