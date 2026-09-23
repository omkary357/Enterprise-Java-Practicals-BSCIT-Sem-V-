<%@page import="java.util.List"%>
<%@page import="entity.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JPA Inventory Application</title>
        <style>
            body { font-family: Arial, sans-serif; margin: 30px; background-color: #fafafa; }
            .container { max-width: 800px; margin: 0 auto; background: white; padding: 25px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
            h2, h3 { color: #333; }
            .form-group { margin-bottom: 15px; }
            label { display: block; font-weight: bold; margin-bottom: 5px; }
            input[type=text], input[type=number] { width: 100%; padding: 8px; box-sizing: border-box; border: 1px solid #ccc; border-radius: 4px; }
            input[type=submit] { background-color: #28a745; color: white; padding: 10px 18px; border: none; cursor: pointer; border-radius: 4px; font-size: 15px; }
            input[type=submit]:hover { background-color: #218838; }
            table { width: 100%; border-collapse: collapse; margin-top: 25px; }
            th, td { border: 1px solid #ddd; padding: 10px; text-align: left; }
            th { background-color: #007bff; color: white; }
            tr:nth-child(even) { background-color: #f2f2f2; }
        </style>
    </head>
    <body>
        <div class="container">
            <h2>Practical 9.a: Simple Inventory Application Using JPA</h2>
            <hr/>

            <h3>Add New Inventory Item</h3>
            <form action="InventoryServlet" method="POST">
                <div class="form-group">
                    <label>Item Name:</label>
                    <input type="text" name="itemName" placeholder="e.g. Keyboard, Mouse" required />
                </div>

                <div class="form-group">
                    <label>Quantity:</label>
                    <input type="number" name="quantity" min="1" placeholder="e.g. 10" required />
                </div>

                <div class="form-group">
                    <label>Price (₹):</label>
                    <input type="number" step="0.01" name="price" min="0" placeholder="e.g. 450.00" required />
                </div>

                <input type="submit" value="Add Item to Database" />
            </form>

            <h3 style="margin-top: 30px;">Current Inventory</h3>
            <table>
                <thead>
                    <tr>
                        <th>Item ID</th>
                        <th>Item Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Item> items = (List<Item>) request.getAttribute("items");
                        if (items != null && !items.isEmpty()) {
                            for (Item item : items) {
                    %>
                    <tr>
                        <td><%= item.getId()%></td>
                        <td><%= item.getItemName()%></td>
                        <td><%= item.getQuantity()%></td>
                        <td>₹ <%= item.getPrice()%></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="4" style="text-align: center; color: #888;">No items in inventory. Add one above!</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>