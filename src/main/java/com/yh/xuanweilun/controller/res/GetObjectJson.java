package com.yh.xuanweilun.controller.res;

import java.lang.reflect.Field;

/**
 * generate init json object
 */
public class GetObjectJson {

    private static Class<?> myClass = Person.class;














    public static void main(String[] args) {
        Field[] declaredFields = myClass.getDeclaredFields();
        String name = toLowerCaseFirstOne(myClass.getSimpleName());
        StringBuffer sb = new StringBuffer();
//        sb.append("\n");
//        sb.append("let ");
//        sb.append(name);
//        sb.append(" = ");
        sb.append("{");
        for (Field declaredField : declaredFields) {
            sb.append(" ");
            sb.append(declaredField.getName());
            sb.append(": ");
            if(declaredField.getType().toString().equals("boolean")){
                sb.append("false");
            }else{
                sb.append("''");
            }
            sb.append(",");
        }
        sb.append("}}");
        System.out.println("");
        System.out.println("let vueSave = new Vue({el: '#save',data:"+sb+");");
        System.out.println("let vueEdit = new Vue({el: '#edit',data:"+sb+");");
        System.out.println("let vueCheck = new Vue({el: '#check',data:"+sb+");");
//        System.out.println();
//        String ob = "let url = " + "'/"+name+"';";
//        String idUrl = "let idUrl = url + '/' + id;";
//        System.out.println(ob);
//        System.out.println(idUrl);

        System.out.println("\n//保存");
        System.out.println("function save(id) {" +
                "\n\tlet url = '/" + name+"';"+
                "\n\t//layer.open" +
                "\n\tsaveVue(url,vueSave,layer.close(index));\n}");

        System.out.println("\n//查看");
        System.out.println("function check(id) {" +
                "\n\tlet url = '/" + name+"/'+id;"+
                "\n\tcheckVue(url,vueCheck,openCheck());" +
                "\n\tfunction openCheck(){" +
                "\n\t\t//layer.open" +
                "\n\t}" +
                "\n}");

        System.out.println("\n//编辑");
        System.out.println("function edit(id) {" +
                "\n\tlet url = '/" + name+"/'+id;"+
                "\n\tcheckVue(url,vueEdit,openEdit());" +
                "\n\tfunction openEdit(){" +
                "\n\t\t//layer.open" +
                "\n\t\teditVue(url,vueEdit,layer.close(index));\n\t}\n}");

        System.out.println("\n//删除");
        System.out.println("function del(id) {" +
                "\n\tlet url = '/" + name+"/'+id;"+
                "\n\t//layer.confirm" +
                "\n\tdelVue(url,layer.close(index))\n}");

    }

    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
