package OOD;

public class Card implements Comparable<Card> {
	public enum Suit {
		SPADE(1), HEART(2), FLOWER(3), DIAMOND(4);
		int order;

		private Suit(int order) {
			this.order = order;
		}
	};

	private int number;
	private Suit suit;

	public Card(int num, Suit suit) {
		this.number = num;
		this.suit = suit;
	}

	public int number() {
		return number;
	}

	public Suit suit() {
		return suit;
	}

	@Override
	public int compareTo(Card c2) {
		return (suit.order * 100 + number) - (c2.suit().order * 100 + c2.number());
	}

}
