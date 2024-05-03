package pojos.PetStore;

public class Category{
	public Category() {
	}

	public Category(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	private String name;
	private Integer id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"Category{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}
