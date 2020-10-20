package pe.gob.munisantanita.Website.Web.Model;

public class Menu {
	private String name;
	private String module;
	private String section;
	private String panel;
	private String panelSection;
	// Meta Tags
	private String descripcion;
	private String keywords;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	public String getPanel() {
		return panel;
	}
	public void setPanel(String panel) {
		this.panel = panel; 
	}
	
	public String getPanelSection() {
		return panelSection;
	}
	public void setPanelSection(String panelSection) {
		this.panelSection = panelSection; 
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion; 
	}
	
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords; 
	}
	
}

