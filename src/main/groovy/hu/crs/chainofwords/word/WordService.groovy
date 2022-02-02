package hu.crs.chainofwords.word

class WordService {

    final Random random = new Random()
    final Map<String, List<String>> dictionary

    WordService(List<String> words) {
        dictionary = words.groupBy {
            firstletter(it)
        }
    }

    String firstletter(String word) {
        if (word.startsWith("dzs")) {
            return word.substring(0,3)
        }
        if (word.startsWith("cs") || word.startsWith("dz") || word.startsWith("gy") || word.startsWith("ly") || word.startsWith("ny") || word.startsWith("sz") || word.startsWith("ty") || word.startsWith("zs")) {
            return word.substring(0,2)
        }
        return word.substring(0,1)
    }

    String next(String letter) {
        def size = dictionary[letter].size()
        return dictionary[letter][random.nextInt(size)]
    }
}
