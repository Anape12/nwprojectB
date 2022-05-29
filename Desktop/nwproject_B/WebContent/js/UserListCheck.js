function checkForm(){
	console.log("document.form1.userId.value:" + document.form1.radiobutton.value);
	var checkNo =document.form1.radiobutton.value;
    if(checkNo == null || checkNo == "" ){
        alert("更新対象を選択してください");
        return false;
    } else {
    	return true;
    }
}
function checkUserInfo() {
    var userId =document.form1.editID.value;
    var userPass =document.form1.editPass.value;
    var userPerm =document.form1.editPermission.value;
    $.ajax({
        // HTTP通信の種類にGETを設定
        type: "GET",
        // リクエスト先URL
        // Javaのサーブレットを指定する
        url: "http://localhost:8080/nwproject_B/EditUserView?userId=" + userId + "&" + "userPass=" + userPass + "&" + "userPerm=" + userPerm,
        // サーバから返されるデータの型を指定
        // 今回はただの文字列
        dataType: "text"
    })
    // 通信成功の場合の処理
    .done(
        // dataでout.print(ret);の値を受け取る
        function (data) {
        	if(data === "0"){
        		event.preventDefault();
        		event.stopPropagation();
        		event.stopImmediatePropagation();
        		alert("値を更新してください")
        		return false;
        	}
        	else if(data === "1") {
        		return true;
        	}
        }
    );
}