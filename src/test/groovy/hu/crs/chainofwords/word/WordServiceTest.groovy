package hu.crs.chainofwords.word

import hu.crs.chainofwords.word.WordService
import org.junit.jupiter.api.Test

class WordServiceTest {
    WordService underTest = new WordService()

    @Test
    void shouldReturnDictionary() {
        def dictionary = underTest.dictionary(["alma", "asztal", "bükk", "dió"])
        assert dictionary.size() == 3
        assert dictionary['a'].size() == 2
        assert dictionary['b'].size() == 1
        assert dictionary['d'].size() == 1
    }
}