package Model;

   
public class Books {
	    private int bid;
	    private String book_name;
	    private String book_publisher;
	    private String book_edition;
	    public int getBid() {
			return bid;
		}
		public void setBid(int bid) {
			this.bid = bid;
		}
	    public String getBook_name() {
			return book_name;
		}
		public void setBook_name(String book_name) {
			this.book_name = book_name;
		}
		public String getBook_publisher() {
			return book_publisher;
		}
		public void setBook_publisher(String book_publisher) {
			this.book_publisher = book_publisher;
		}
		public String getBook_edition() {
			return book_edition;
		}
		public void setBook_edition(String book_edition) {
			this.book_edition = book_edition;
		}
}
