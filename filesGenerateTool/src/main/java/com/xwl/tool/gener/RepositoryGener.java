package com.xwl.tool.gener;

import com.xwl.tool.ClazzUtils;
import com.xwl.tool.EasyFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class RepositoryGener {

    private static String repoPath = "C:\\Users\\86187\\xuanweilun\\filesGenerateTool\\src\\main\\java\\com\\xwl";
    private static String  packageName = "com.xwl.service.tool.entity";
    private static String templatePath = "C:\\Users\\86187\\xuanweilun\\filesGenerateTool\\src\\main\\java\\com\\xwl\\service\\tool\\RepositoryTemplate";

    public static void main(String[] args) {
        List<Class<?>> classes = ClazzUtils.getClasses(packageName);
        String contents = EasyFile.readContentsFromFile(new File(templatePath));
        RepositoryGener repositoryGener = new RepositoryGener();
        for (Class<?> aClass : classes) {
            repositoryGener.getContents(aClass,contents);
        }

    }

    StringBuffer getContents(Class<?> clazz,String contents){
        StringBuffer sb = new StringBuffer();
        StringBuffer path = new StringBuffer(repoPath);
        contents = this.replacePackage(repoPath,contents);
        contents = contents.replace("${entityName}", clazz.getSimpleName());
        contents = contents.replace("${entity}", clazz.getName());
        contents = contents.replace("${time}", time);
        contents = contents.replace("${creator}", "xaunweilun");
        path.append("\\");
        path.append(clazz.getSimpleName() + "Repository");
        path.append(".java");
        File file = new File(path.toString());
        EasyFile.writeContentsToFile(file,contents.toString());
        return sb;
    }

    String replacePackage(String path,String contents){
        String packageName = EasyFile.getPackageNameByPath(path.toString());
        String packageContent = contents.replace("${package}", packageName);
        return packageContent;
    }

    private static final String dateTime = new SimpleDateFormat("yyyy年MM月dd日 下午HH:mm:SS").format(new Date());
    private static final String time = dateTime.substring(0,dateTime.length()-1);

}
