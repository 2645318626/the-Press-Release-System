let submitformBtn = document.getElementById('submitformBtn');
let repUsername = document.getElementById('repUsername');
let repPassword = document.getElementById('repPassword');
let cfPassword = document.getElementById('cfPassword');

submitformBtn.onclick = function () {
    if (repUsername.value.trim() == "") {
        alert('用户名不能为空！');
        repUsername.focus();
        return false;
    }
    if (repPassword.value.trim() === "") {
        alert('密码不能为空！');
        repPassword.focus();
        return false;
    }
    if (cfPassword.value.trim() === "") {
        alert('密码不能为空！');
        cfPassword.focus();
        return false;
    }
    if (repPassword.value !== cfPassword.value) {
        alert('两次密码输入不同！');
        cfPassword.focus();
        return false;
    }
};