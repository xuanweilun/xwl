//增
function saveVue(url,vue,callback) {
    url = '/save' + url;
    $.ajax({
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        data: JSON.stringify(vue._data),
        success: function(data){
            if(data.success){
                layer.msg(data.msg, {icon: 1,time: 1000}, callback);
            }else{
                layer.msg(data.msg, {icon: 2,time: 700},);
            }
        },
        err: function(data){
            layer.msg('保存失败！', { icon: 1 });
        }
    });
}
//删
function delVue(url,callback) {
    url = '/del' + url;
    $.ajax({
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        success: function(data){
            if(data.success){
                layer.msg(data.msg, {icon: 1,time: 1000}, callback);
            }else{
                layer.msg(data.msg, {icon: 2,time: 700},);
            }
        },
        err: function(data){
            layer.msg('删除失败！请稍后重试！', { icon: 1 });
        }
    });
}
//批量删除
function delTable(objectName,$table,callback) {
    //获取选中行
    let rows = $table.bootstrapTable('getSelections');
    console.log(rows);
    if(rows.length == 0){
        layer.msg("请选择要删除的行！", {icon: 2,time: 500});
        return ;
    }
    //询问框
    layer.confirm('确定删除选中数据?', {
        title: '提示',
        btn: ['确定', '取消'],
    }, function (index) {
        let url = '/del/' + objectName + '/inBatch';
        let arrays = new Array();
        $(rows).each(function () {
            arrays.push(this.id);
        });
        $.ajax({
            type: 'post',
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(arrays),
            url: url,
            success: function(data){
                if(data.success){
                    layer.msg(data.message, {icon: 1},function(){
                        $table.bootstrapTable('refresh');
                    });
                    layer.close(index);
                }else{
                    layer.msg(data.message, {icon: 2});
                    layer.close(index);
                }
            },
            err: function(data){
                layer.msg("系统繁忙~ 请稍后再试！ ", {icon: 2});
                layer.close(index);
            }
        });

    });

}
//修改
function editVue(url,vue,callback) {
    url = '/update' + url;
    $.ajax({
        type: 'POST',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        data: JSON.stringify(vue._data),
        success: function(data){
            if(data.success){
                layer.msg(data.msg, {icon: 1,time: 1000}, callback);
            }else{
                layer.msg(data.msg, {icon: 2,time: 700},);
            }
        },
        err: function(data){
            layer.msg('编辑失败！', { icon: 1 });
        }
    });
}
//查询
function checkVue(url,vue,callback) {
    $.ajax({
        type: 'get',
        dataType: 'json',
        contentType: 'application/json',
        url: url,
        success: function(data){
            if(data.success){
                Object.assign(vue,data.data);
                if (callback && typeof callback == 'function') {
                    callback()
                }
            }else{
                layer.msg(data.msg, {icon: 2,time: 700},);
            }
        },
        err: function(data){
            layer.msg('查询失败！', { icon: 1 });
        }
    });
}