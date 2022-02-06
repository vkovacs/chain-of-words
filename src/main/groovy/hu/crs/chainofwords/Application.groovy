package hu.crs.chainofwords

import hu.crs.chainofwords.word.WordService

import java.nio.charset.Charset

class Application {
    static void main(String[] args) {
        String filename = args.size() > 0 ? args[0] : "src/main/resources/words.txt"

        WordService wordService = new WordService(load(filename))
        String word = ""
        Set<String> usedWords = []
        String replyWord = ""
        println "Szia, kezdjük!"

        main_loop:
        while (true) {
            word = System.in.newReader("UTF-8").readLine().toLowerCase()
            if (word == "bye") break main_loop

            if (replyWord != "" && wordService.firstletter(word) != wordService.lastLetter(replyWord)) {
                println error("Hibás keződbetű a beírt szóban! A várt kezdőbetű: ${wordService.lastLetter(replyWord)}")
                continue
            }
            if (usedWords.contains(word)) {
                println error("Már volt ez a szót! Mondj újat helyette!")
                continue
            }

            if (!wordService.known(word)) {
                println error("Nem ismerem ezt a szót, mondj mást!")
                continue
            }
            def lastLetter = wordService.lastLetter(word)

            replyWord = wordService.next(lastLetter)

            usedWords << word
            usedWords << replyWord

            println(replyWord)
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
