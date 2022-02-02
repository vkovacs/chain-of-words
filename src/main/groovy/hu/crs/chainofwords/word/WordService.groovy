package hu.crs.chainofwords.word

class WordService {

    final Random random = new Random()
    final Map<String, List<String>> dictionary

    WordService(List<String> words) {
        dictionary = words.groupBy {
            if (it.startsWith("dzs")) {
                return it.substring(0,3)
            }
            if (it.startsWith("cs") || it.startsWith("dz") || it.startsWith("gy") || it.startsWith("ly") || it.startsWith("ny") || it.startsWith("sz") || it.startsWith("ty") || it.startsWith("zs")) {
                return it.substring(0,2)
            }
            return it.substring(0,1)
        }
    }

    String next(String letter) {
        def size = dictionary[letter].size()
        return dictionary[random.nextInt(size)]
    }
}
