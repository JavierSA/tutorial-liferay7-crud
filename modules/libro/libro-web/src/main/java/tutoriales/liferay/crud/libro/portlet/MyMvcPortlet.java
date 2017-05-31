package tutoriales.liferay.crud.libro.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
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
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class MyMvcPortlet extends MVCPortlet {

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        final List escritores = EscritorLocalServiceUtil.getEscritors(0, Integer.MAX_VALUE);

        renderRequest.setAttribute("escritores", escritores);

        super.render(renderRequest, renderResponse);
    }

    @ProcessAction(name = "addEscritor")
    public void addEscritor(ActionRequest request, ActionResponse response) {
        final ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        final String nombre = ParamUtil.getString(request, "nombreEscritor");

        EscritorLocalServiceUtil.addEscritor(td.getSiteGroupId(), td.getCompanyId(), td.getUser().getUserId(), td.getUser().getFullName(), nombre);
    }

    @ProcessAction(name = "displayEscritorEdition")
    public void displayEscritorEdition(ActionRequest request, ActionResponse response) throws IOException, PortletException, PortalException {
        final String id = request.getParameter("idEscritor");
        final Escritor escritor = EscritorLocalServiceUtil.getEscritor(Long.valueOf(id));

        request.setAttribute("escritor", escritor);
        response.setRenderParameter("mvcPath", "/escritorEdit.jsp");
    }

    @ProcessAction(name = "editEscritor")
    public void editEscritor(ActionRequest request, ActionResponse response) throws IOException, PortletException, PortalException {
        final String id = request.getParameter("idEscritor");
        final String nombre = request.getParameter("nombreEscritor");

        EscritorLocalServiceUtil.updateEscritor(Long.valueOf(id), nombre);

        response.setRenderParameter("mvcPath", "/view.jsp");
    }

    @ProcessAction(name = "deleteEscritor")
    public void deleteEscritor(ActionRequest request, ActionResponse response) throws IOException, PortletException, PortalException {
        final String id = request.getParameter("idEscritor");

        EscritorLocalServiceUtil.deleteEscritor(Long.valueOf(id));
    }

}
