package board;

public class Pagination {
	/*
	//변수 -> 정보의 저장, 처리X
	//변수는 저장하는 역활
	//메서드 -> 정보를 처리하는 역할
	int currentPageNo = 1;
	int pageCountPerBlock = 5;
	int itemCountPerPage = 3;
	int currentBlockNo = (int)Math.ceil(currentPageNo / (double)pageCountPerBlock);
	int startPageNoInBlock = pageCountPerBlock * (currentBlockNo - 1) + 1;
	int endPageNoInBlock = startPageNoInBlock + pageCountPerBlock - 1;
	int startIdx = itemCountPerPage * (currentPageNo - 1);
	int endIdx = startIdx + itemCountPerPage;
	//class만들때 변수 선언 하면서 계산식을 만들면 처음에 선언하여 만들어 질때만 계산 되고 그 이후부터는 계산X
			
	//메서드로 만들어야 한다 -> 계속적 계산이 가능해진다.
	*/
	
	// 변수 -> 정보의 저장. 처리X
		int currentPageNo = 1;
		int pageCountPerBlock = 5;
		int itemCountPerPage = 3;

		// 메서드 -> 정보의 처리
		public int getCurrentBlockNo() {
			return (int)Math.ceil(currentPageNo / (double)pageCountPerBlock);
		}

		public int getStartPageNoInBlock() {
			return pageCountPerBlock * (getCurrentBlockNo() - 1) + 1;
		}

		public int getEndPageNoInBlock() {
			return getStartPageNoInBlock() + pageCountPerBlock - 1;
		}

		public int getStartIdx() {
			return itemCountPerPage * (currentPageNo - 1);
		}

		public int getEndIdx() {
			return getStartIdx() + itemCountPerPage;
		}

	
	
}
