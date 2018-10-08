package by.en.service.util.parser;

import java.io.File;

class RootPath {
    private static final String SRC = "src";
    private static final String MAIN = "main";
    private static final String RESOURCES = "resources";
    static final File PATH = new File(SRC + File.separator + MAIN + File.separator + RESOURCES);
    static final String MURPHY_TXT = "murphy.txt";
    static final String NEW_MURPHY_TXT = "new-murphy.txt";
}
