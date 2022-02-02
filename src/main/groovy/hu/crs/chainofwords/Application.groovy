package hu.crs.chainofwords

import hu.crs.chainofwords.word.WordService

class Application {
    static void main(String[] args) {
        String filename = args.size() > 0 ? args[0] : "src/main/resources/words.txt"

        WordService wordService = new WordService(load(filename))
        String word = ""
        while (word != "bye") {
            word = System.in.newReader().readLine()
            def firstLetter = wordService.firstletter(word)
            println wordService.next(firstLetter)
        }
        //wordService.dictionary.each {println( it.key)}
    }

    static List<String> load(String filename) {
        new File(filename).readLines()
    }
}
