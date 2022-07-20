package commonprocess.errormessage;

public class ErrorIDConstants {

	//メッセージID
	//W000000={0}は{1}文字以内で入力してください。
	public static final String INPUT_MAX_LENGTH_ERROR_MESSAGE = "W000000";
	//W000001={0}は{1}文字以上で入力してください。
	public static final String INPUT_MIN_LENGTH_ERROR_MESSAGE = "W000001";
	//W000002={0}は半角数字で入力してください。
	public static final String HARF_WIDTH_NUM_ERROR_MESSAGE = "W000002";
	//W000003={0}は半角英数字で入力してください。
	public static final String HALFWIDTH_ALPHANUMERIC_ERROR_MESSAGE = "W000003";
	//W000004={0}は形式通りに入力してください。
	public static final String FORMAT_INPUT_ERROR_MESSAGE = "W000004";
	//W000005={0}は既に使われています。
	public static final String INPUT_DUPLICATE_ERROR_MESSAGE = "W000005";
	//W000006={0}が選択されていません。
	public static final String REQUIRED_SELECT_ERROR_MESSAGE = "W000006";
	//W000007=予期せぬエラーが発生しました。
	public static final String ERROR = "W000007";
	//W100001=メールアドレスまたはパスワードが間違っています。
	public static final String LOGIN_ERROR ="W100001";
}
