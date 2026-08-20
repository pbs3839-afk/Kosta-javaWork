package ex0806.enumex;
/**
 * enum은 열거형으로 안에 정의된 정보는 static final = 상수이다.
 * */
public enum Grade {
	BASIC("일반",100,5),
	SILVER("우수고객",200,10),
	GOLD("최우수고객",300,30);
	
	private final String kind;
	private final int point;
	private final int role;
	
	Grade(String kind, int point, int role) {
		this.kind=kind;
		this.point=point;
		this.role=role;
	}

	public String getKind() {
		return kind;
	}

	public int getPoint() {
		return point;
	}

	public int getRole() {
		return role;
	}
	
	
}


//static final Stirng BASIC="일반,100,5" ;
//static final Stirng BASIC_KIND="일반" ;
//static final int BASIC_POINT=100 ;
//static final int BASIC_ROLE=5 ;
//
//
//static final Stirng SILVER="일반,100,5" ;
//static final Stirng SILVER_KIND="일반" ;
//static final int SILVER_POINT=100 ;
//static final int SILVER_ROLE=5 ;

