package tutoriales.liferay.crud.libro.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import org.osgi.service.component.annotations.Component;
import tutoriales.liferay.crud.libro.service.EscritorLocalServiceUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=tutoriales_liferay_crud_libro_portlet_MyMvcPortlet",
                "mvc.command.name=editEscritor"
        },
        service = MVCActionCommand.class
)
public class EditEscritorMvcActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
        final String id = request.getParameter("idEscritor");
        final String nombre = request.getParameter("nombreEscritor");

        EscritorLocalServiceUtil.updateEscritor(Long.valueOf(id), nombre);

        response.setRenderParameter("mvcPath", "/view.jsp");
    }

}
