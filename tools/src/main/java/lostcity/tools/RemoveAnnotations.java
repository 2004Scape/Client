package lostcity.tools;

import lostcity.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class RemoveAnnotations {
    public static void main(String[] args) {
        // in order to build for ancient Java versions, iterate through every single .java file and remove the deob-annotations tags
        Collection<File> source = FileUtils.listFiles(new File("client/src/main/java"), new String[]{ "java" }, true);
        for (Iterator<File> iterator = source.iterator(); iterator.hasNext();) {
            File file = iterator.next();

            try {
                String contents = FileUtils.readFileToString(file);
                contents = contents.replaceAll("@OriginalArg\\(\\d+\\) ", "");
                contents = contents.replaceAll("@OriginalClass\\(.*\\)", "");
                contents = contents.replaceAll("@OriginalMember\\(.*\\)", "");
                contents = contents.replaceAll("@Pc\\(\\d+\\) ", "");
                contents = contents.replaceAll("import org\\.openrs2\\.deob\\.annotation\\..*;", "");
                FileUtils.writeStringToFile(file, contents);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // and then remove deob-annotations as a dependency from the build.gradle file
        // also update the build.gradle file to use a lower java version (make sure the runner is using a compatible JDK)
        Collection<File> build = FileUtils.listFiles(new File("."), new String[]{ "gradle" }, true);
        for (Iterator<File> iterator = build.iterator(); iterator.hasNext();) {
            File file = iterator.next();

            try {
                String contents = FileUtils.readFileToString(file);
                contents = contents.replaceAll("compileOnly project\\(':deob-annotations'\\)", "");
                contents = contents.replaceAll("sourceCompatibility = JavaVersion\\.VERSION_1_8", "sourceCompatibility = JavaVersion.VERSION_1_2");
                FileUtils.writeStringToFile(file, contents);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
