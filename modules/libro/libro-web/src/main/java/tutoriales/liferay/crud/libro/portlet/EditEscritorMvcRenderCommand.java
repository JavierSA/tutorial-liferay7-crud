package tutoriales.liferay.crud.libro.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import org.osgi.service.component.annotations.Component;
import tutoriales.liferay.crud.libro.model.Escritor;
import tutoriales.liferay.crud.libro.service.EscritorLocalServiceUtil;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=tutoriales_liferay_crud_libro_portlet_MyMvcPortlet",
                "mvc.command.name=displayEscritorEdition"
        },
        service = MVCRenderCommand.class
)
public class EditEscritorMvcRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest request, RenderResponse response) throws PortletException {
        final String id = request.getParameter("idEscritor");

        try {
            final Escritor escritor = EscritorLocalServiceUtil.getEscritor(Long.valueOf(id));
            request.setAttribute("escritor", escritor);

        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

        return "/escritorEdit.jsp";
    }

}
