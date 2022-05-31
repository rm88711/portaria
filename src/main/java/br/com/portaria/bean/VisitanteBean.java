package br.com.portaria.bean;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.primefaces.model.file.UploadedFile;

import br.com.portaria.dao.VisitanteDao;
import br.com.portaria.model.Visitante;

@Named
@RequestScoped
public class VisitanteBean {

	private Visitante visitante = new Visitante();
	
	@Inject
	private VisitanteDao dao;
	
	private UploadedFile image;
	
	public String save() throws IOException {
		
		ServletContext servletContext = (ServletContext) FacesContext
											.getCurrentInstance()
											.getExternalContext()
											.getContext();
		String path = servletContext.getRealPath("/");
		
		FileOutputStream out = 
				new FileOutputStream(path + "\\images\\visitantes\\" + image.getFileName());
		out.write(image.getContent());
		out.close();
		
		visitante.setImagePath("\\images\\visitantes\\" + image.getFileName());
		dao.insert(visitante);
		
		mostrarMensagem("Visitante cadastrado com sucesso");
		
		return "visitantes?faces-redirect=true";
	}

	private void mostrarMensagem(String msg) {
		FacesContext
			.getCurrentInstance()
			.getExternalContext()
			.getFlash()
			.setKeepMessages(true);
		
		FacesContext
			.getCurrentInstance()
			.addMessage(null, new FacesMessage(msg));
	}
	
	public List<Visitante> getVisitantes(){
		return dao.list();
	}
	
	public String remove(Visitante visitante) {
		dao.delete(visitante);
		mostrarMensagem("Visitante apagado com sucesso");
		return "visitantes?faces-redirect=true";
	}
	
	public void update() {
		dao.update(visitante);
		mostrarMensagem("Visitante atualizado com sucesso");
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}

}