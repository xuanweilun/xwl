function getObject(target) {
    let idUrl = target.url + '/' + target.id;
    axios.get(idUrl)
        .then(function e(res){
            let ajxRes = res.data;
            if(ajxRes.success){
                layer.msg(ajxRes.msg, {icon: 1,time: 1000},);
                Object.assign(target,ajxRes.data);
            }else {
                layer.msg(ajxRes.msg, {icon: 2,time: 700},);
            }
        })
        .catch(function (error) { // 请求失败处理
            console.log(error);
        });
}
function addObject(target) {
    axios.post(target.url,target._data,"application/json")
        .then(function (res) {
            let ajaxRes = res.data;
            if(ajaxRes.success){
                alert("添加成功");
            }else{
                alert(ajaxRes.msg);
            }
        })
        .catch(function (error) { // 请求失败处理
            console.log(error);
        });
}
function editObject(target) {
    let idUrl = target.url + '/' + target.id;
    axios.put(idUrl,target._data,"application/json")
        .then(function (res) {
            let ajaxRes = res.data;
            if(ajaxRes.success){
                alert("修改成功");
            }else{
                alert(ajaxRes.msg);
            }
        })
        .catch(function (error) { // 请求失败处理
            console.log(error);
        });
}

function delObject(target) {
    let idUrl = target.url + '/' + target.id;
    axios.delete(idUrl)
        .then(function (res) {
            var ajaxRes = res.data;
            if(ajaxRes.success){
                alert("删除成功");
            }else{
                alert(ajaxRes.msg);
            }
        })
        .catch(function (error) { // 请求失败处理
            console.log(error);
        });
}