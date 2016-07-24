package LeetCodeOJ;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.List;

public class WordLadder {

	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		wordList.add(endWord);
		HashMap<String, Integer> dict = new HashMap<String, Integer>();
		Queue<String> queue = new LinkedList<String>();
		dict.put(beginWord, 0);
		expand(dict, wordList, beginWord, 1, queue);
		int i = 0;
		while (!dict.containsKey(endWord) && !queue.isEmpty()) {
			String word = queue.poll();
			expand(dict, wordList, word, dict.get(word) + 1, queue);
			// ++i;
			// if (i > 1100)
			// break;
		}
		if (dict.containsKey(endWord))
			return dict.get(endWord) + 1;
		else
			return 0;
	}

	static void expand(HashMap<String, Integer> dict, Set<String> wordList, String word, Integer distant,
			Queue<String> queue) {
		for (int i = 0; i < word.length(); i++) {
			for (int j = 0; j < 26; j++) {
				String newWord = word.substring(0, i) + ((char) ('a' + j)) + word.substring(i + 1);
				if (wordList.contains(newWord) && !dict.containsKey(newWord)) {
					dict.put(newWord, distant);
					queue.add(newWord);
				}
			}
		}
	}

}
