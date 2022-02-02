package hu.crs.chainofwords

import hu.crs.chainofwords.word.WordService

class Application {
    static void main(String[] args) {
        String filename = args.size() > 0 ? args[0] : "src/main/resources/words.txt"

        WordService wordService = new WordService(load(filename))
        wordService.dictionary.each {println( it.key)}
    }

    static List<String> load(String filename) {
        new File(filename).readLines()
    }
}
