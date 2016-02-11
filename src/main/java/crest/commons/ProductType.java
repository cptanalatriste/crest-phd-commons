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
}
