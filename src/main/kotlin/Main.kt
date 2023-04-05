fun main(args: Array<String>) {
    with(MinimumTimeToCompleteTripsTests(MinimumTimeToCompleteTripsSolution2())) {
        test1()
        test2()
    }

    with(KokoEatingBananasTests(KokoEatingBananasSolution1())) {
        test1()
        test2()
        test3()
        test4()
    }

    with(LongestSubstringWithoutRepeatingCharactersTests(LongestSubstringWithoutRepeatingCharactersSolution1())) {
        test1()
        test2()
        test3()
    }

    with(LongestPalindromicSubstringTests(LongestPalindromicSubstringSolution2())) {
        test1()
        test2()
        test3()
        test4()
        test5()
    }

    with(MergeKSortedListsTests(MergeKSortedListsSolution1())) {
        test1()
        test2()
        test3()
        test4()
    }

    with(GenerateParenthesesTests(GenerateParenthesesSolution1())) {
        test1()
        test2()
        test3()
    }

    with(ValidAnagramTests(AnagramsSolution3())) {
        test1()
        test2()
    }

    with(Search2DMatrixTests(Search2DMatrixSolution1())) {
        test1()
        test2()
    }

    with(TwoSumTests(TwoSumSolution2())) {
        test1()
        test2()
        test3()
    }

    with(ValidParenthesesTests(ValidParenthesesSolution1())) {
        test1()
        test2()
        test3()
        test4()
        test5()
    }

    with(NumberOfIslandsTests(NumberOfIslandsSolution1())) {
        test1()
        test2()
    }

    with(MergeIntervalsTests(MergeIntervalsSolution1())) {
        test1()
        test2()
        test3()
    }

    with(TopKFrequentWordsTests(TopKFrequentWordsSolution2())) {
        test1()
        test2()
    }

    with(PartitionLabelsTests(PartitionLabelsSolution1())) {
        test1()
        test2()
        test3()
        test4()
    }

    with(LongestRepeatingCharacterReplacementTests(LongestRepeatingCharacterReplacementSolution1())) {
        test1()
        test2()
    }

    with(RotateImageTests(RotateImageSolution1())) {
        test1()
        test2()
    }
}


fun assertEquals(actual: Array<IntArray>?, expected: Array<IntArray>?) {
    if (!actual.contentDeepEquals(expected)) throw AssertionError("Expected $expected, but actual $actual")
}

fun assertEquals(actual: IntArray?, expected: IntArray?) {
    if (!actual.contentEquals(expected)) throw AssertionError("Expected $expected, but actual $actual")
}

fun assertEquals(actual: Any?, expected: Any?) {
    if (actual != expected) throw AssertionError("Expected $expected, but actual $actual")
}
