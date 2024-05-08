package com.shopping.product.web.actions;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.Validator;
import com.onlineshopping.product.service.model.ProductCategory;
import com.onlineshopping.product.service.service.ProductCategoryLocalServiceUtil;
import com.shopping.product.web.constants.MVCCommandNames;
import com.shopping.product.web.constants.ProductWebPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;


@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + ProductWebPortletKeys.PRODUCTWEB,
                "mvc.command.name=" + MVCCommandNames.VIEW_CATEGORY
        },
        service = MVCRenderCommand.class
)
public class ViewCategoryMVCRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
        getProductCategories(renderRequest, renderResponse);
        return "/view.jsp";
    }

    private void getProductCategories(RenderRequest renderRequest, RenderResponse renderResponse) {
        List<ProductCategory> categories = ProductCategoryLocalServiceUtil.getProductCategories();

        if (Validator.isNull(categories) || categories.isEmpty()) {
            SessionErrors.add(renderRequest, "no-category-exists");
            return;
        }
        renderRequest.setAttribute("categories", categories);
    }

}
