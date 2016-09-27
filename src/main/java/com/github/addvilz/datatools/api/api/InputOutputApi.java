package com.github.addvilz.datatools.api.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputOutputApi {
    /**
     * Read file using Java stream API, line by line.
     *
     * @param file Path to the file, absolute or relative to current working directory
     * @return Line by line stream of the given file, serial by default
     * @throws IOException When file does not exist or is not readable
     */
    public Stream<String> fileStream(String file) throws IOException {
        return Files.lines(Paths.get(file));
    }

    /**
     * Get a PrintWriter instance to write output to file
     *
     * @param name Name of output file
     * @return instance of a new PrintWriter
     * @throws FileNotFoundException When OS failed to open or create file
     */
    public PrintWriter writer(String name) throws FileNotFoundException, UnsupportedEncodingException {
        return new PrintWriter(name, "UTF-8");
    }
}
