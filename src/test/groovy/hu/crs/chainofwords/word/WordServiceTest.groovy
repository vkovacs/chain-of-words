package hu.crs.chainofwords.word

import hu.crs.chainofwords.word.WordService
import org.junit.jupiter.api.Test

class WordServiceTest {
    WordService underTest

    @Test
    void shouldReturnDictionary() {
        underTest = new WordService(["alma", "asztal", "bükk", "dió"])
        assert underTest.dictionary.size() == 3
        assert underTest.dictionary['a'].size() == 2
        assert underTest.dictionary['b'].size() == 1
        assert underTest.dictionary['d'].size() == 1
    }

    @Test
    void firstLetter() {
        underTest = new WordService([])
        assert underTest.firstletter("dzsidás") == "dzs"
        assert underTest.firstletter("csirke") == "cs"
        assert underTest.firstletter("óra") == "ó"

    }

    @Test
    void lastLetter() {
        underTest = new WordService([])
        assert underTest.lastLetter("almudzs") == "dzs"
        assert underTest.lastLetter("apacs") == "cs"
        assert underTest.lastLetter("dió") == "ó"

    }
}