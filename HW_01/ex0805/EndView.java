package ex0805;

/**
  요청 결과를 출력할 view
*/
public class EndView{
   /**
     성공여부 메시지를 출력하는 메소드 
   */
   public static void printMessage(String message){ 
      System.out.println(message+"\n");
   }

   /**
     전체검색 결과를 출력하는 메소드
   */
   public static void printSelectAll(Goods [] arr){//service에 있는 주소가 전달되었다.
	   System.out.printf("***상품의 정보 (%d)개*****%n" , GoodsService.count);
		for(int i=0; i < GoodsService.count ; i++) {
			System.out.printf("코드 : %s | 이름 : %s | 가격 : %d  | 설명 : %s%n",
					arr[i].getCode(),arr[i].getName(),arr[i].getPrice(),arr[i].getExplain());
		}

   }

   /**
     상품코드에 해당하는 상세정보 출력하는 메소드 
   */
   public static void printSelectByCode(Goods goods){
		System.out.printf("%s코드의 기본 정보%n" , goods.getCode());
		System.out.printf("이름 : %s | 가격 : %d | 설명 : %s%n",goods.getName(),goods.getPrice(),goods.getExplain());
	
   }


}