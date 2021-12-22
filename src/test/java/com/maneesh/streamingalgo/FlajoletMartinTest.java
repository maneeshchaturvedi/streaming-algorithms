package com.maneesh.streamingalgo;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

class FlajoletMartinTest {


    @org.junit.jupiter.api.Test
    void distinctElementsIntegerStream() {
        FlajoletMartin<String> flajoletMartin = new FlajoletMartin<>(13) ;
        Path path = Paths.get("src","test","resources","jungle_book.txt");
        try {
            Stream<String> lines = Files.lines(path);
            Stream<String> words = lines
                    .flatMap(line -> Stream.of(line.split("\\W+")));
//            long actual = words.distinct().count();
//            System.out.println("actual distinct= " + actual);
            long distinctElements  = flajoletMartin.countDistinct(words);
            System.out.println("distinctElements from FM =" + distinctElements);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}