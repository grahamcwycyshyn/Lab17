
public class Country {

	protected String name;
	protected int population;

	public Country() {}

	public Country(String name, int population) {
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setName(int population) {
		this.population = population;
	}
	
	public void toString(String name, int population) {
		System.out.println(name + ":" + population);
	}
}
