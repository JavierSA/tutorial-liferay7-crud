package tutoriales.liferay.crud.libro.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;
import tutoriales.liferay.crud.libro.model.Escritor;
import tutoriales.liferay.crud.libro.service.EscritorLocalServiceUtil;

import javax.portlet.*;
import java.io.IOException;
import java.util.List;

/**
 * @author jsanchez
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=libro-web Portlet",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=tutoriales_liferay_crud_libro_portlet_MyMvcPortlet",
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class MyMvcPortlet extends MVCPortlet {

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        final List<Escritor> escritores = EscritorLocalServiceUtil.getEscritors(0, Integer.MAX_VALUE);

        renderRequest.setAttribute("escritores", escritores);

        super.render(renderRequest, renderResponse);
    }

    @ProcessAction(name = "displayEscritorEdition")
    public void displayEscritorEdition(ActionRequest request, ActionResponse response) throws IOException, PortletException, PortalException {
        final String id = request.getParameter("idEscritor");
        final Escritor escritor = EscritorLocalServiceUtil.getEscritor(Long.valueOf(id));

        request.setAttribute("escritor", escritor);
        response.setRenderParameter("mvcPath", "/escritorEdit.jsp");
    }

}
