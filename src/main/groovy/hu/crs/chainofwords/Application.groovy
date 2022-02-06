package hu.crs.chainofwords

import hu.crs.chainofwords.word.WordService

class Application {
    static void main(String[] args) {
        String filename = args.size() > 0 ? args[0] : "src/main/resources/words.txt"

        WordService wordService = new WordService(load(filename))
        String word = ""
        Set<String> usedWords = []
        String previousReplyWord = ""
        println "Szia, kezdjük!"
        while (word != "bye") {
            word = System.in.newReader().readLine()
            if (previousReplyWord != "" && wordService.firstletter(word) != wordService.lastLetter(previousReplyWord)) {
                println error("Hibás keződbetű a beírt szóban!")
                continue
            }
            if (usedWords.contains(word)) {
                println error("Már mondtad ezt a szót! Mondj újat helyette!")
                continue
            }
            usedWords << word
            def firstLetter = wordService.firstletter(word)
            previousReplyWord = wordService.next(firstLetter)
            println(previousReplyWord)
        }
    }

    static String error(String text) {
        def red = "\u001B[31m"
        def normal = "\u001B[0m"
        red + text + normal
    }

    static List<String> load(String filename) {
        new File(filename).readLines()
    }
}
