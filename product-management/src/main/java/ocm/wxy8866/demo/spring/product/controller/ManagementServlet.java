package ocm.wxy8866.demo.spring.product.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxy8866.demo.spring.product.form.ProductForm;
import com.wxy8866.demo.spring.product.model.Product;
import ocm.wxy8866.demo.spring.product.action.SaveProductAction;

@WebServlet(name = "ManagementServlet", urlPatterns = { "/input-product", "/save-product" })
public class ManagementServlet extends HttpServlet
{

    private static final long serialVersionUID = 8968877723431185329L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
    {
        String uri = req.getRequestURI();
        /*
         * uri is in this form: /contextName/resourceName, for example: /appdesign1/input-product. However, in the event
         * of a default context, the context name is empty, and uri has this form /resourceName, e.g.: /input-product
         */

        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex);

        String dispatchUrl = null;

        if ("/input-product".equalsIgnoreCase(action))
        {
            dispatchUrl = "/jsp/ProductForm.jsp";
        }
        else if ("/save-product".equalsIgnoreCase(action))
        {
            // store model in a scope variable for the view
            dispatchUrl = "/jsp/ProductDetails.jsp";

            // create form
            ProductForm productForm = new ProductForm();

            productForm.setName(req.getParameter("name"));
            try
            {
                productForm.setPrice(new BigDecimal(req.getParameter("price")));
            } catch (java.lang.NumberFormatException e)
            {
                System.out.println("input the number please. skip price field ");
            }
         
            productForm.setDescription(req.getParameter("desscription"));

            // create model
            Product product = new Product();
            product.setName(productForm.getName());
            product.setPrice(productForm.getPrice());
            product.setDescription(productForm.getDescription());

            // execute action method
            SaveProductAction saveProductAction = new SaveProductAction();
            saveProductAction.save(product);

            // store model in a scope variable for the view
            req.setAttribute("product", product);
        }

        if (dispatchUrl != null)
        {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(dispatchUrl);
            requestDispatcher.forward(req, resp);
        }
    }

}
