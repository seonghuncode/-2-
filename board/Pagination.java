package board;

public class Pagination {
	
	//페이지 정보/ 필요한 정보를 Board에서 가지고 온다.
	
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
		int totalItemCount = 0;

		public Pagination(int totalItemCount) {
			this.totalItemCount = totalItemCount;
		}

		// 메서드 -> 정보의 처리
		public int getCurrentBlockNo() {
			return (int)Math.ceil(currentPageNo / (double)pageCountPerBlock);
		}

		public int getStartPageNoInBlock() {
			return pageCountPerBlock * (getCurrentBlockNo() - 1) + 1;
		}

		public int getEndPageNoInBlock() {
			int endPageNo = getStartPageNoInBlock() + pageCountPerBlock - 1;

			if(endPageNo > getLastPageNo()) {
				endPageNo = getLastPageNo();
			}

			return endPageNo;
		}

		public int getStartIdx() {
			return itemCountPerPage * (currentPageNo - 1);
		}

		public int getEndIdx() {
			int endIdx = getStartIdx() + itemCountPerPage;
			if(endIdx > totalItemCount) {
				endIdx = totalItemCount;
			}

			return endIdx;
		}
		public int getLastPageNo() {
			// 게시물 30개 -> 페이지당 3개씩 보여준다 -> 30 / 3 = 10;
			// 게시물 31개 -> 페이지당 3개씩 보여준다 -> 31 / 3 = 10.xxx;
			// 총페이지 개수(마지막 페이지 번호) => 올림(전체 게시물 수 / 페이지당 게시물 수)		
			return (int)Math.ceil((double)totalItemCount / itemCountPerPage);

		}

	
	
}
