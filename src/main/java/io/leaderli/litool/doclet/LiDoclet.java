package io.leaderli.litool.doclet;

import com.sun.javadoc.*;

import java.util.Collections;
import java.util.Set;

public class LiDoclet extends Doclet {


    public static boolean start(RootDoc root) {
        ClassDoc[] classes = root.classes();
        for (ClassDoc cls : classes) {

            for (FieldDoc field : cls.fields(false)) {

                System.out.println(field.name() + " " + field);
                String x = field.containingClass().qualifiedName();
                System.out.println(x);
                try {
                    System.out.println(Class.forName(x).getDeclaredField(field.name()).getGenericType());
                } catch (ClassNotFoundException | NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("--------------------------------------------------------------------------------------------------");
        }
        return true;
    }

    public static int optionLength(String option) {
        if (option.equals("-d")) {
            return 2;
        }
        return 1;
    }

    public static String getName() {
        return "MyDoclet";
    }

    public static Set<LanguageVersion> getSupportedLanguageVersions() {
        return Collections.singleton(LanguageVersion.JAVA_1_5);
    }

    public static String[][] getOptions() {
        return new String[][]{
                {"-d", "Specify the output directory for generated files"},
        };
    }
}
