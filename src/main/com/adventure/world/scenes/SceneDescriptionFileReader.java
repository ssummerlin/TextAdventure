package main.com.adventure.world.scenes;

// CHECKSTYLE:OFF

import java.io.*;
import java.nio.charset.StandardCharsets;

// CHECKSTYLE:ON

public class SceneDescriptionFileReader {

    /**
     * The purpose of this function is to put the contents of a file into a string, and return the string.
     *
     * This function has a parameter that's of class BufferedReader. BufferedReader stores the contents
     * of a file and can read one line of the content at a time. You can get the next line by
     * using the method readLine(). The BufferedReader does not know how many lines it has,
     * so you need keep calling readLine until it returns null. Make sure you save off
     * the contents of each readLine call, because you can't go backwards, only forwards.
     *
     * For example, let's say the file contains the following:
     *
     *          Roses are red
     *          Violets are blue
     *          Unexpected bracket
     *          On line 32
     *
     * Then the first readLine() call will return "Roses are red", the second call "Violets are blue", etc.
     * On the fifth call, readLine() will return null, which means it's the end of the file.
     *
     * Your job in this method is use a while loop to append each line of the file to a string.
     * You will also need to add a new line escape character ("\n") after each line. The last line can omit
     * the new line escape character.
     *
     * @param br - BufferedReader
     * @return the string of content read from the BufferedReader.
     * @throws IOException - File probably couldn't be found or read
     */

    private String produceTextFromBufferedReader(BufferedReader br) throws IOException {
        //remove this line
        throw new IOException();
    }

    ////// DO NOT CHANGE ANYTHING BELOW THIS LINE /////

    /**
     * Returns a string from the given filename.
     * @param filename - The filename to pull the text from
     * @return - the text from the file
     * @throws IOException - the file couldn't be found or read.
     */
    public String printTextFromFile(String filename) throws IOException {
        ClassLoader loader = getClass().getClassLoader();
        File file = new File(loader.getResource(filename).getFile());
        FileInputStream inputStream = new FileInputStream(file);

        String result;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            result = produceTextFromBufferedReader(br);
        }
        return result;
    }

}
