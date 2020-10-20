package pe.gob.munisantanita.Website.Web.News.Model;

public class Category {
	private String id;
	private String nombre;
	private String slug;
	//private String usuario;
	//private String fecha;
	//private String estado;
	//private String usuario_id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSlug() {
		return slug;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
}
