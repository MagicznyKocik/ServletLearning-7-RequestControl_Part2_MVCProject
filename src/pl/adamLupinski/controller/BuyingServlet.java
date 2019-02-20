package pl.adamLupinski.controller;

import pl.adamLupinski.model.Item;
import pl.adamLupinski.service.PaymentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/buy")
public class BuyingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Item> cart = createShoppingCart(request);
        PaymentService.applyDiscount(cart);
        double originalSum = PaymentService.totalPrice(cart);
        double discountSum = PaymentService.totalPriceAfterDiscount(cart);

        request.setAttribute("cart", cart);
        request.setAttribute("originalSum", originalSum);
        request.setAttribute("discountSum", discountSum);

        request.getRequestDispatcher("summary.jsp").forward(request, response);

    }

    private List<Item> createShoppingCart(HttpServletRequest request){
        List<Item> cart = new ArrayList<>();
        String firstItem =request.getParameter("firstItem");
        double firstItemPrice =Double.valueOf(request.getParameter("firstItemPrice"));
        String secondItem =request.getParameter("secondItem");
        double secondItemPrice = Double.valueOf(request.getParameter("secondItemPrice"));
        String thirdItem =request.getParameter("thirdItem");
        double thirdItemPrice = Double.valueOf(request.getParameter("thirdItemPrice"));
        cart.add(new Item(firstItem, firstItemPrice));
        cart.add(new Item(secondItem, secondItemPrice));
        cart.add(new Item(thirdItem, thirdItemPrice));
        return cart;
    }

}
