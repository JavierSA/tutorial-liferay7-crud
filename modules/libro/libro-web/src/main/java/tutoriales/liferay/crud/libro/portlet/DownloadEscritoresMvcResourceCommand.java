package tutoriales.liferay.crud.libro.portlet;

import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ContentTypes;
import org.osgi.service.component.annotations.Component;
import tutoriales.liferay.crud.libro.service.EscritorLocalServiceUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component(
        property = {
                "javax.portlet.name=tutoriales_liferay_crud_libro_portlet_MyMvcPortlet",
                "mvc.command.name=downloadEscritores"
        },
        service = MVCResourceCommand.class
)
public class DownloadEscritoresMvcResourceCommand extends BaseMVCResourceCommand {

    @Override
    protected void doServeResource(ResourceRequest request, ResourceResponse response) throws Exception {
        final String escritores = EscritorLocalServiceUtil.getEscritors(0, Integer.MAX_VALUE).toString();

        final InputStream stream = new ByteArrayInputStream(escritores.getBytes(StandardCharsets.UTF_8));

        PortletResponseUtil.sendFile(request, response, "escritores.txt", stream, ContentTypes.APPLICATION_TEXT);
    }

}
