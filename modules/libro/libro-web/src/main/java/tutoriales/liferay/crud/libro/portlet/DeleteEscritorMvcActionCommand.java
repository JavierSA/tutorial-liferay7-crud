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
                "mvc.command.name=deleteEscritor"
        },
        service = MVCActionCommand.class
)
public class DeleteEscritorMvcActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
        final String id = request.getParameter("idEscritor");

        EscritorLocalServiceUtil.deleteEscritor(Long.valueOf(id));
    }

}
