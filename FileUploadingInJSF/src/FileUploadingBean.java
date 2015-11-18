import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
/*
Doc/Docx İçin:application/vnd.openxmlformats-officedocument.wordprocessingml.document
txt İçin:text/plain
Resim İçim:image/jpeg
*/

@ManagedBean
@SessionScoped
public class FileUploadingBean implements Validator {
	Part file;
	
	public Part getFile() {
		return file;
	}
	
	public void setFile(Part file) {
		this.file = file;
	}
	
	public void upload(ActionEvent event)
	{
		try {
			file.write("/Users/ilkaygunel/Documents/"+getFileName(file));
		} catch (Exception e) {
			System.err.println("Bir Hata Meydana Geldi\nHata:"+e);
		}
	}
	
	public String getFileName(Part file)
	{
		for(String cd:file.getHeader("content-disposition").split(";"))
		{
			if(cd.trim().startsWith("filename"))
			{
				String filename=cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
				return filename;
			}
		}
		return "";
	}

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		Part partObject = (Part) arg2;
		
		if(partObject.getSize()>336154)
		{
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Dosya Boyutu Maximumdan Büyük!","Dosya Boyutu Maximumdan Büyük!"));
		}
		
		if(!"text/plain".equals(partObject.getContentType()))
		{
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,"Girilen Dosya Türü Geçersiz!Txt Seçiniz!","Girilen Dosya Türü Geçersiz!Txt Seçiniz!"));
		}
	}
}
