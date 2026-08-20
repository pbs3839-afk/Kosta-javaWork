package ex0811.board;

public class UploadBoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println(super.getClass().getSimpleName() + "의 insert call..");
		System.out.println("전달된 board =" + board);
		return 0;
	}

	@Override
	public boolean update(Board board) {
		System.out.println(super.getClass().getSimpleName() + "의 Update call..");
		System.out.println("전달된 board =" + board);
		return true;
	}

	@Override
	public Board selectByNo(int no) {
		System.out.println(super.getClass().getSimpleName() + "의 selectByNo call..");
		System.out.println("전달된 no =" + no);
		return new UploadBoard(no, "파일첨부", "삼순", "이쁜이미지" , "a.jpg");
	}
}
