let title = document.getElementById('title');
let author = document.getElementById('author');
let message = document.getElementById('message');
let addBtn = document.getElementById('addBtn');
let imgPath = document.getElementById('imgPath');
addBtn.onclick = function () {
    if (title.value.trim() === "") {
        alert('标题不能为空！');
        title.focus();
        return false;
    }
    if (author.value.trim() === "") {
        alert('作者不能为空！');
        author.focus();
        return false;
    }
    if (message.value.trim() === "") {
        alert('内容不能为空！');
        message.focus();
        return false;
    }
};