package crest.commons;

public class ProductType {
	private final int id;
	private final int weight;
	
	public ProductType(int prodId, int prodWeight){
		id=prodId;
		weight=prodWeight;
	}
	
	public int getId(){
		return id;
	}
	
	public int getWeight(){
		return weight;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductType [id=" + id + ", weight=" + weight + "]";
	}
	
	
}
