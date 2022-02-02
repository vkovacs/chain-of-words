package hu.crs.chainofwords

import hu.crs.chainofwords.word.WordService

class Application {
    static void main(String[] args) {
        String filename = args.size() > 0 ? args[0] : "words.txt"

        WordService wordService = new WordService(load(filename))
        wordService.dictionary.each {println( it.key)}

        println(wordService.next("b"))
    }


    static List<String> load(String filename) {
        new File("src/main/resources/$filename").readLines()
    }
}
