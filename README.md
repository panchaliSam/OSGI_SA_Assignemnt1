# OSGI_SA_Assignemnt1 : Smart Convenience Shop

## Overview
The **Smart Convenience Shop** is integrating smart inventory management, personalized customer preferences, dynamic pricing, and order handling. The system ensures the freshest items are delivered to customers at optimized prices, based on their preferences and real-time data. By combining these pillars, the system improves customer experience while optimizing operational efficiency.

## Features

### Inventory Management Pillar
- Real-time tracking of food items across multiple restaurant branches.
- Automatic stock level monitoring, low-stock alerts, and price adjustments based on ingredient availability.
- Integration with the **Stock Notification Consumer** to notify restaurant staff of low stock.
- Price adjustments for dishes with scarce ingredients.

### Customer Preferences Pillar
- Collects and analyzes customer dietary preferences, including vegan, gluten-free, low-sugar, etc.
- Personalized recommendations based on customer data (e.g., suggesting new vegan dishes).
- Integration with the **Personalized Recommendation Consumer** to serve relevant dish suggestions.

### Pricing Pillar
- Dynamic pricing based on ingredient availability, market conditions, and demand.
- Real-time price adjustments for dishes, with special offers and discounts applied through the **Discount Management Consumer**.
- Discounts for specific customer groups (e.g., loyal vegan customers).

### Order Management Pillar
- Comprehensive order tracking from order creation to delivery.
- **Order Confirmation Consumer** to notify customers about the order status and estimated delivery times.
- Real-time updates to inventory and pricing based on orders.
- Updates to stock levels when orders are confirmed, ensuring efficient inventory control.

## Creative Flow & Interaction

### Inventory to Customer Preferences:
- Predicting customer preferences based on stock levels (e.g., notifying customers about surplus items like bananas for smoothies).

### Customer Preferences to Pricing:
- Offering discounts on specific dietary items, such as vegan dishes, based on customer history.

### Pricing to Order Management:
- Transparent price notification, ensuring customers are aware of the final price before order confirmation.

### Order Management to Inventory:
- Automatically updating inventory once an order is confirmed (e.g., decreasing stock of ingredients like buns and lettuce when vegan burgers are ordered).
