package controller;


public class EntityController {
	
	private static EntityController instance = null;
	
	public static EntityController getInstance() {
		if (instance == null) {
			instance = new EntityController();
		}
		return instance;
	}
	private EntityController() {}

	public void addEntity() {
		//TODO: preraditi metodu da dodaje entitete
	}
	public void editEntity() {
		//TODO: preraditi metodu da menja entitete
	}
	public void removeEntity() {
		//TODO: preraditi metodu da brise entitete
	}
	public void searchEntity() {
		//TODO: preraditi metodu da trazi entitete
	}
}
