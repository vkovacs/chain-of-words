package hu.crs.chainofwords.word

class WordService {

    final Map<Character, List<String>> dictionary

    WordService(List<String> words) {
        dictionary = words.groupBy {it.charAt(0)}
    }
}
