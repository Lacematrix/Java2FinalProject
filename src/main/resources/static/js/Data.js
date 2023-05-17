document.write("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>");
function getData(type) {
    let respondData;
    $.ajax({
        url: '/api/Question/' + type,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function(response) {
            // 在控制台打印接收到的 JSON 数据
            console.log(response);
            respondData = response;
            // 在这里编写解析和处理 JSON 数据的代码
            // 可以使用 response 对象访问 JSON 数据的属性
        },
        error: function(error) {
            console.error(error);
        }
    });
    return respondData;
}

// function getPercentageOfQuestions() {
//     let respondData;
//     const xhr = new XMLHttpRequest();
//     xhr.open('GET', '/api/NoAnswer', false);
//     xhr.setRequestHeader('Content-Type', 'application/json');
//     xhr.onreadystatechange = function () {
//         if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
//             const responseJson = xhr.responseText;
//             respondData = JSON.parse(responseJson);
//         }
//     };
//     xhr.send();
//     return respondData;
// }