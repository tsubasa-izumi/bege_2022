package commonprocess.errormessage;

import java.util.List;

public class ErrorMsg {

	/**
	 * 第一引数からエラーメッセージを取得し、第二引数でエラーメッセージを生成する。
	 * エラーメッセージを返す。
	 *
	 * @param key メッセージID
	 * @param replaceElement エラーメッセージに対して置換するべき要素
	 * @return
	 */
	public String returnErrorMsg(String key, String[] replaceElement) {
		// 第一引数を用いて、エラーメッセージを取得するメソッドからエラーメッセージを取得し、
		// 第二引数を用いて、取得したエラーメッセージの一部を置換し、エラーメッセージを完成させる。
		String errorMsg = LoadPropertyfile.getProperty(key);
		for (int i = 0; i < replaceElement.length; i++) {
			errorMsg = errorMsg.replace("{" + i + "}", replaceElement[i]);
		}
		// 完成したエラーメッセージを返す。
		return errorMsg;
	}

	/**
	 * 引数からエラーメッセージを取得し、エラーメッセージを返す。
	 *
	 * @param key メッセージID
	 * @return
	 */
	public String returnErrorMsg(String key) {
		// 引数を用いて、エラーメッセージを取得するメソッドからエラーメッセージを取得し、エラーメッセージを返す。
		String errorMsg = LoadPropertyfile.getProperty(key);
		return errorMsg;
	}

	/**
	 * このメソッドは第一引数がnullでない場合エラーリストに格納し、戻り値とする。
	 *
	 * @param errorMsg チェックしたいパラメータ
	 * @param errorMsgList 格納するエラーメッセージリスト
	 * @return エラーメッセージが追加されたエラーメッセージリスト
	 */
	public List<String> errorMsgNullCheck(String errorMsg, List<String> errorMsgList) {
		if (errorMsg != null) {
			// 第一引数がnullでない場合、第一引数を第二引数のリストに追加する。
			errorMsgList.add(errorMsg);
			// 追加されたリストを返す。
			return errorMsgList;
		}
		// 第一引数がnullの場合は、第二引数のエラーリストを戻り値とする。
		return errorMsgList;
	}

}
