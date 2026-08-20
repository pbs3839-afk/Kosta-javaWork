package ex0812.exam02;

public class Product<K, M> {
	// 상품모델의 종류
	private K kind;

	// 상품모델 이름
	private M model;

	public K getKind() {
		return kind;
	}

	public void setKind(K kind) {
		this.kind = kind;
	}

	public M getModel() {
		return model;
	}

	public void setModel(M model) {
		this.model = model;
	}

}
