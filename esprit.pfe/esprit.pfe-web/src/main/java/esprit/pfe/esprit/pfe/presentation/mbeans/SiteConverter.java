package esprit.pfe.esprit.pfe.presentation.mbeans;

	import javax.el.ValueExpression;
	import javax.faces.component.UIComponent;
	import javax.faces.context.FacesContext;
	import javax.faces.convert.Converter;
	import javax.faces.convert.FacesConverter;

import esprit.pfe.esprit.pfe.persistence.Departement;
import esprit.pfe.esprit.pfe.persistence.SiteUniversity;


	@FacesConverter(value = "siteConverter")
	public class SiteConverter implements Converter {

	    @Override
	    public Object getAsObject(FacesContext ctx, UIComponent uiComponent, String beerId) {
	        ValueExpression vex =
	                ctx.getApplication().getExpressionFactory()
	                        .createValueExpression(ctx.getELContext(),
	                                "#{DepartmentBean}", DepartmentBean.class);

	        DepartmentBean sitedep = (DepartmentBean)vex.getValue(ctx.getELContext());
	        return sitedep.getSii(Integer.valueOf(beerId));
	    }

		@Override
		public String getAsString(FacesContext context, UIComponent component, Object sii) {
			// TODO Auto-generated method stub
			String itemId = String.valueOf(((SiteUniversity)sii).getId());
			return  itemId;
			
		}

	  /*  @Override
	    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object sii) {
	    	return ((SiteUniversity)sii).getId().toString();
	    }*/

	}

