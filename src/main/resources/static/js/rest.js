// 查询
function setVue(vue,url,id,callback) {
    axios.get(url+'/'+id)
        .then(function e(res){
            let ajaxRes = res.data;
            if(ajaxRes.success){
                Object.assign(vue,ajaxRes.data);
                if (callback && typeof callback == 'function') {
                    callback()
                }
            }else {
                layer.msg(ajaxRes.msg, {icon: 2,time: 700},);
            }
        })
        .catch(function (error) { // 请求失败处理
            console.log(error);
        });
};
// 增加
function saveVue(vue,url,callback) {
    axios.post(url,vue._data)
        .then(function (res) {
            let ajaxRes = res.data;
            if(ajaxRes.success){
                layer.msg(ajaxRes.msg, {icon: 1,time: 1000},callback);
            }else{
                layer.msg(ajaxRes.msg, {icon: 2,time: 700},);
            }
        })
        .catch(function (error) { // 请求失败处理
            console.log(error);
        });
};
// 修改
function updateVue(vue,url,id,callback) {
    let idUrl = url + '/' + id;
    axios.put(idUrl,vue._data,"application/json")
        .then(function (res) {
            let ajaxRes = res.data;
            if(ajaxRes.success){
                layer.msg(ajaxRes.msg, {icon: 1,time: 1000},callback);
            }else{
                layer.msg(ajaxRes.msg, {icon: 2,time: 700},);
            }
        })
        .catch(function (error) { // 请求失败处理
            console.log(error);
        });
};
// 删除
function delVue(url,id,callback) {
    let idUrl = url + '/' + id;
    axios.delete(idUrl)
        .then(function (res) {
            var ajaxRes = res.data;
            if(ajaxRes.success){
                layer.msg(ajaxRes.msg, {icon: 1,time: 1000},callback);
            }else{
                layer.msg(ajaxRes.msg, {icon: 2,time: 700},);
            }
        })
        .catch(function (error) { // 请求失败处理
            console.log(error);
        });
}