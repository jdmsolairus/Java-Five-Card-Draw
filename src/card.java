import java.awt.Image;


public class card implements Comparable<card>{
		private int value;
		private String suit;
		private String name;
		private String nickName;
		private Image img;
		String getName() {
			return name+ " of " +suit;
		}
		void setName(String name) {
			this.name = name;
		}
		int getValue() {
			return value;
		}
		void setValue(int value) {
			this.value = value;
		}
		String getSuit() {
			return suit;
		}
		void setSuit(String suit) {
			this.suit = suit;
		}
		public String toString()
			 {
			  return name+ " of " + suit;  
			 }
		@Override
		public int compareTo(card other) {
			if(this.getValue()>other.getValue())
			{
			return -1;
			}
			else if(this.getValue()<other.getValue())
			{
			return 1;
			}
			else 
			{
				return 0;
			}
			}
		public String getNickName() {
			return nickName;
		}
		public void setNickName(String nickName) {
			this.nickName = nickName;
		}
		public Image getImg() {
			return img;
		}
		public void setImg(Image img) {
			this.img = img;
		}
		}


