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
        sb.append("{\n");
        for (Field declaredField : declaredFields) {
            sb.append("\t");
            sb.append(declaredField.getName());
            sb.append(": ");
            if(declaredField.getType().toString().equals("boolean")){
                sb.append("false");
            }else{
                sb.append("''");
            }
            sb.append(",\n");
        }
        sb.append("}}");
        System.out.println("var vueSave = new Vue({el: '#save',data:"+sb+" );");
        System.out.println("var vueCheck = new Vue({el: '#check',data: "+sb+");");
        System.out.println("var vueEdit = new Vue({el: '#edit',data: "+sb+");");

//        System.out.println(sb);
    }

    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
}
