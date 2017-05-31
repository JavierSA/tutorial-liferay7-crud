package tutoriales.liferay.crud.libro.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Component;
import tutoriales.liferay.crud.libro.service.EscritorLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.ProcessAction;

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

    @ProcessAction(name = "addEscritor")
    public void addEscritor(ActionRequest request, ActionResponse response) {
        final ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        final String nombre = ParamUtil.getString(request, "nombreEscritor");

        EscritorLocalServiceUtil.addEscritor(td.getSiteGroupId(), td.getCompanyId(), td.getUser().getUserId(), td.getUser().getFullName(), nombre);
    }

}
